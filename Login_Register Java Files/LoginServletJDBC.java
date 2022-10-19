import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServletJDBC extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String a, b;
		PrintWriter out = response.getWriter(); 
		response.setContentType("text/html");
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from registerUser");
			while(rs.next()) {
				
				 a = rs.getString(1);
				 b = rs.getString(2);
				 if(username.equalsIgnoreCase(a) && password.equalsIgnoreCase(b)) {
						
						out.println("<html><head><title>Login</title></head>"
								+ "<body><h1> Login successful.</h1></body></html>");
						
					}
			
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
