import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQL {
	
	Connection conn = null;
	Statement state = null;
	ResultSet result = null;
	
	public MySQL() throws SQLException{
		conn = DriverManager.getConnection("jdbc://localhost/hrptoshoprenter?user=hrptoshoprenter&password=1234");
	}
	
	public ResultSet execute (String sql){
		return result;		
	}
}
