package vn.iotstar.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
	private final String serverName = "localhost";

	private final String dbName = "LTWEB34";

	private final String portNumber = "1433";

	private final String instance = "";

	private final String userID = "sa";

	private final String password = "123456789";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName
				+ ";encrypt=true;trustServerCertificate=true;";

		if (instance == null || instance.trim().isEmpty())

			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "; databaseName=" + dbName;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		return DriverManager.getConnection(url, userID, password);

	}

	public static void main(String[] args) {

		try {
			System.out.println(new DBConnect().getConnection());
			String sqlInsert = "INSERT INTO users VALUES(?, ?)";
			String selectAll = "SELECT * FROM users";
			// connect to database
			Connection conn = new DBConnect().getConnection();
			// crate statement to insert GiaoVien
			PreparedStatement stmt = conn.prepareStatement(sqlInsert);
			stmt.setString(1, "Kế");
			stmt.setString(2, "Khánh Hòa");
			stmt.execute();
			// select all
			stmt = conn.prepareStatement(selectAll);
			// get data from table GiaoVien
			ResultSet rs = stmt.executeQuery();
			// show data
			while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			stmt.close();
			conn.close(); 
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
