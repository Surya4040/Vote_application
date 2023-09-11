

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Vote_compare")
public class Vote_compare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Vote_compare() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/vote","root","123456789");
		    PreparedStatement statement = conn.prepareStatement("SELECT * FROM voting WHERE result");
		    
		    ResultSet resultSet = statement.executeQuery();
		    
		    // Initialize your variable
		    String compareValue = "bjp";
		    
		    while (resultSet.next()) {
		        String storedValue = resultSet.getString("value");
		        
		        // Compare storedValue with compareValue
		        if (storedValue.equals(compareValue)) {
		        	response.getWriter().append("Served at: ");
		            // Do something when they match
		            // For example, set a flag or perform an action
		        } else {
		        	response.getWriter().append("Served at: ");
		            // Do something when they don't match
		            // For example, set a different flag or perform a different action
		        }
		    }
		    
		    // Close resources
		    resultSet.close();
		    statement.close();
		    conn.close();
		} catch (Exception e) {
		    System.out.println(e);
		}
	}

		
	

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		}
}
