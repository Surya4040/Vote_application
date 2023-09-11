import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class voter_login {
	public static boolean validate(String Email,String confirmpwd) {
		boolean surya=false;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/vote","root","123456789");
			 PreparedStatement ps=con.prepareStatement("select * from voter_signin where email=? and confirmpassword=?");
			ps.setString(1, Email);
			ps.setString(2, confirmpwd);
			ResultSet rs=ps.executeQuery();
			surya=rs.next();
		}catch(Exception e) {System.out.println();}
		return surya;
	}
}
