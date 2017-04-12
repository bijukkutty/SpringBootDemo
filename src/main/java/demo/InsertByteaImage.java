package demo;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class InsertByteaImage {/*
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "test";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			File file = new File("D:\\img\\spread.jpg");
			FileInputStream fis = new FileInputStream(file);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO public.so_details VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, 1);
			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			ps.setString(3, "Biju");
			ps.setBinaryStream(4, fis, file.length());
			ps.setString(5, "RAVI,NEAR CYBER PARK,ELCTRONIC CITY,BANGALORE-560100");
			
			ps.setString(6, "VIDYA HALL");
			ps.setString(7, "WEDDING PURPOSE");
			ps.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			ps.setString(9, "Biju1");
			ps.setInt(10, 1);
			ps.setInt(11, 1);
			ps.executeUpdate();
			ps.close();
			fis.close();
			String sql;
			sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", First: " + first);
				System.out.println(", Last: " + last);
			}
			// STEP 6: Clean-up environment
			//rs.close();
			//stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");

	}

*/}
