package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHandler {

	private static String database = "adventureworksdw2012";
	private static String user = "root";
	private static String password = "root";

	public static void main(String[] args) {
		System.out.println(countRecords("agg1_salesamount_day"));
	}

	public static Connection getConnection() {

		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection( "jdbc:mysql://localhost:3306/" + database, user, password );
			
		} catch (Exception e) {
			
			e.printStackTrace();

		}

		return null;

	}

	public static Statement getStatement() {

		Connection c = getConnection();

		try {

			if (c != null) {

				return c.createStatement();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static PreparedStatement prepareStatement( String sql ) {

		Connection c = getConnection();

		try {

			if (c != null) {

				return c.prepareStatement(sql);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static int countRecords(String tableName) {

		int result = 0;

		try {
			ResultSet rs = getStatement().executeQuery("SELECT COUNT(*) FROM " + tableName);

			if (rs.next()) {
				result = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
