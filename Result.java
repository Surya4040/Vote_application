import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Result {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/vote","root","123456789");
			Statement stmnt=con.createStatement();
			ResultSet rs=stmnt.executeQuery("select * from voting");
	        }
		catch(Exception e) {
		System.out.println(e);
	        }
	}
}
