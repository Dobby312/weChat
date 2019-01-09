package util;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.JDBCDriver;

public class Checkdb {
	public static String num = null;

	public static String check() {
		final long timeInterval = 1000 * 60 * 10;
		JDBCDriver jd = new JDBCDriver();
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				long time = System.currentTimeMillis() / 1000;
				while (true) {
					try {
						Thread.sleep(timeInterval);
					} catch (Exception e) {

						e.printStackTrace();
					}
					System.out.println("开始扫描");
					/**
					 * 实时扫描数据库
					 */
					String sql = "select * form equipment where time>" + time;
					if (jd.isNull(sql)) {
						ResultSet result = jd.query(sql);
						try {
							num = result.getString("num");

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(result);
					}

					time = time + 600;
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		return num;
	}
}
