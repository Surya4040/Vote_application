import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Vote {
	static PreparedStatement ps;
	static ResultSet rs;
	public static boolean validate(String Voting) {
		 boolean status=false;
		
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/vote","root","123456789");
			    ps=con.prepareStatement("insert into voting(`result`)values(?)");
			 	
			    ps.setString(1, Voting);
			 	if(ps.executeUpdate()>0) {
			 		status=true;
			 	}
		 }catch(Exception e) {
			 System.out.println(e);
		 }
		 return status;
	 }
	
}
