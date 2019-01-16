package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import dao.JDBCDriver;
import handle.Article;
import handle.BaseMessage;
import handle.NewsMessage;
import handle.TextMessage;

public class DealTextMessage {
	/**
	 * 对文本消息做处理
	 * 
	 * @param requestMap
	 * @return
	 */
	private static String name;
	static JDBCDriver jd = new JDBCDriver();

	public static BaseMessage dealMessage(Map<String, String> requestMap, String msgType) {
		ArrayList<String> list = new ArrayList<String>();
		// 用户发来的内容
		String content = requestMap.get("Content");
		// 查询所有的客户名称
		String sql1 = "select name from company";
		ResultSet rs = jd.query(sql1);

		try {
			while (rs.next()) {
				name = rs.getString("name");
				list.add(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (String cname : list) {
			if (content != null && content.equals(cname)) {
				String sql2 = "select url from company where name = '" + cname + "'";
				// 查询该客户所对应的url
				ResultSet rs2 = jd.query(sql2);
				try {
					while (rs2.next()) {
						String url = rs2.getString("url");
						TextMessage tm = new TextMessage(requestMap, url);
						return tm;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				TextMessage tm = new TextMessage(requestMap, "请输入正确的公司名称");
				return tm;
			}
		}
		return null;
	}

	/**
	 * 回复图文消息
	 */

	// if (content != null && content.equals("设备状态")) {
	// List<Article> articles = new ArrayList<>();
	// articles.add(new Article("当前设备状态", "图文消息的介绍",
	// "http://mmbiz.qpic.cn/mmbiz_jpg/pnW3cx0mRlpoG3Pgv3F4dvATIMF3vhBCeHQbwiaGiazd8xR8Q6iaiaib4NUz0nFP4OsQicQp1YBkJ8icaFcLjdPycnOew/0",
	// "http://www.baidu.com"));
	// NewsMessage nm = new NewsMessage(requestMap, articles);
	// return nm;
	// }
	//
	// if (content != null && content.equals("看板")) {
	// List<Article> articles = new ArrayList<>();
	// articles.add(new Article("当前看板内容", "图文消息的介绍",
	// "http://mmbiz.qpic.cn/mmbiz_jpg/pnW3cx0mRlpk2nUZ0E2AHgve2evBcSrzxbyI28iaiayyJBYpLG7YE34hx2TAY77ePtZZNGGXahecM9F1ENAXesOw/0",
	// "http://www.baidu.com"));
	// NewsMessage nm = new NewsMessage(requestMap, articles);
	// return nm;
	// }
}
