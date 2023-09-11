

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Result_servlet")
public class Result_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Result_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/vote","root","123456789");
			Statement stmnt=con.createStatement();
			ResultSet rs=stmnt.executeQuery("select * from voting");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("VOTE COUNT");
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>");
			out.println("NO");
			out.println("</th>");
			out.println("<th>");
			out.println("VOTE");
			out.println("</th>");
			out.println("</tr>");
			out.println("</body>");

			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(rs.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(2));
				out.println("</td>");
				out.println("<tr>");

			}
			out.println("</table>");
			out.println("</body>");
			
			

		}catch(Exception e) {
			System.out.println(e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
}	
