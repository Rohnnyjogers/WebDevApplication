import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServletJDBC extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
			PreparedStatement createUser = connection.prepareStatement("INSERT into registerUser "+
					" (username, password) "+" VALUES (?,?)");
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			createUser.setString(1, username);
			createUser.setString(2, password);
			int rowUpdate = createUser.executeUpdate();
			createUser.close();
			
			response.sendRedirect("login.html");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} 
	
}
