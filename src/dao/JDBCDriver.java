package dao;

import java.sql.*;

public class JDBCDriver {
	private String url;
	private String username;
	private String password;
	private Connection con;
	private Statement st;
	private ResultSet rs;

	public JDBCDriver() {
		url = "jdbc:mysql://127.0.0.1:3306/userscene?useUnicode=true&characterEncoding=utf-8";
		username = "root";
		password = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
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
	
	//关闭连接
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
