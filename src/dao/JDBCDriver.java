package dao;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCDriver {
	private static String url;
	private static String username;
	private static String password;
	private static String driverName;
	private Connection con;
	private Statement st;
	private ResultSet rs;

	static {
		InputStream inputStream = JDBCDriver.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);

			username = properties.getProperty("username");
			password = properties.getProperty("password");
			url = properties.getProperty("url");
			driverName = properties.getProperty("driverName");
			Class.forName(driverName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JDBCDriver() {

		try {
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 向数据库中写入数据
	public boolean insort(String sql) {
		boolean result = false;
		try {
			result = st.execute(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	// 在数据库中查询数据
	public ResultSet query(String sql) {
		try {
			rs = st.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 判断结果集是否为空
	public boolean isNull(String sql) {
		rs = query(sql);
		try {
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	// 关闭连接
	public void close() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
