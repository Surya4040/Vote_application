

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Voter_signin_servlet")
public class Voter_signin_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Voter_signin_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String a=request.getParameter("fname");
		String b=request.getParameter("sname");
		String c=request.getParameter("number");
		String d=request.getParameter("email");
		String e=request.getParameter("pwd");
		String f=request.getParameter("pwd2");
		if(Voter_signin.validate( a,b,c,d,e,f)){
			out.print("signin Successfully");
	    	RequestDispatcher rd=request.getRequestDispatcher("Voter_login.html");
	    	 rd.include(request, response);
		}else{
			out.println("Something went wrong");
			RequestDispatcher rd=request.getRequestDispatcher("Voter_signin.html");
	    	 rd.include(request, response);
		}
	
		

	

	}

}
