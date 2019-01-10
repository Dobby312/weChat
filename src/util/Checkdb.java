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

					// 扫描实时数据库
					String sql = "select * from equipment where time>" + time;
					if (jd.isNull(sql)) {
						ResultSet result = jd.query(sql);
						try {
							while (result.next()) {
								num = result.getString("num");
							}

						} catch (SQLException e) {

							e.printStackTrace();
						}
						System.out.println(num);
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
