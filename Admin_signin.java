import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin_signin {
	static PreparedStatement ps;
	static ResultSet rs;
	public static boolean validate(String fname,String sname, String number,String email,String pass1,String pass2) {
		 boolean status=false;
		
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/vote","root","123456789");
			 	 ps=con.prepareStatement("insert into admin_signin(`firstname`,`lastname`,`number`,`email`,`newpassword`,`confirmpassword`)values(?,?,?,?,?,?)");
			 	ps.setString(1, fname);
			 	ps.setString(2, sname);
			 	ps.setString(3, number);
			 	ps.setString(4, email);
			 	ps.setString(5, pass1);
			 	ps.setString(6, pass2);
			 	if(ps.executeUpdate()>0) {
			 		status=true;
			 	}
		 }catch(Exception e) {
			 System.out.println(e);
		 }
		 return status;
	 }
	
}
