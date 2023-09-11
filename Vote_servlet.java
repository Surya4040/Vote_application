

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Vote_servlet")
public class Vote_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public Vote_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			String l=request.getParameter("Voting");
			if(Vote.validate(l)){
				out.print("Added  Successfully");
		    	RequestDispatcher rd=request.getRequestDispatcher("Votepage.html");
		    	 rd.include(request, response);
			}else{
				out.println("Something went wrong");
				RequestDispatcher rd=request.getRequestDispatcher("Home.html");
		    	 rd.include(request, response);
			};
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}


