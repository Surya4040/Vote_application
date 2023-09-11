

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Voter_login_servlet")
public class Voter_login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Voter_login_servlet() {
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
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(voter_login.validate(email,password)) {
			out.println("Login Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("Votepage.html");
			rd.forward(request, response);
		}
		else {
			out.print("password or username is incorrect");
			RequestDispatcher rd=request.getRequestDispatcher("Voter_login.html");
			rd.include(request, response);
		}
		out.close();
		

	}

}
