package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.JDBCDriver;

public class SearchDB {
	static JDBCDriver jd = new JDBCDriver();

	public static ArrayList<String> search(String num) {
		String touser;
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select userID from userscene where sceneID = " + num;
		if (jd.isNull(sql)) {
			ResultSet rs = jd.query(sql);
			try {
				while (rs.next()) {
					touser = rs.getString("userID");
					list.add(touser);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return list;
	}
}
