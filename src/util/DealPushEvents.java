package util;

import java.util.Map;

import dao.JDBCDriver;
import handle.BaseMessage;
import handle.TextMessage;

public class DealPushEvents {
	// 数据库引用
	static JDBCDriver jd = new JDBCDriver();

	/**
	 * 处理view类型的按钮菜单
	 * 
	 * @param requestMap
	 * @return
	 */
	public static BaseMessage dealView(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 处理click类型的按钮菜单
	 * 
	 * @param requestMap
	 * @return
	 */
	public static BaseMessage dealClick(Map<String, String> requestMap) {
		String key = requestMap.get("EventKey");
		switch (key) {
		case "1":
			// 处理点击了第一个一级菜单	
			return new TextMessage(requestMap, "账户激活成功");
		case "AnHui":
			return new TextMessage(requestMap, "显示安徽地区的客户");
		case "JiangSu":
			return new TextMessage(requestMap,"显示江苏地区的客户");
		case "HuNan": 
			return new TextMessage(requestMap,"显示湖南地区的客户");

		default:
			break;
		}
		return null;
	}

	/**
	 * 处理扫描二维码事件
	 */
	// 用户已关注公众号
	public static BaseMessage dealScan(Map<String, String> requestMap) {

		String openID = requestMap.get("FromUserName");
		String sceneID = requestMap.get("EventKey");
		String sql = "insert into userScene(userID,sceneID) values('" + openID + "','" + sceneID + "')";
		jd.insort(sql);
		System.out.println(openID);
		System.out.println(sceneID);
		return new TextMessage(requestMap, "绑定成功");
	}

	// 用户未关注公众号
	public static BaseMessage dealSubscribe(Map<String, String> requestMap) {

		String openID = requestMap.get("FromUserName");
		String sceneID = requestMap.get("EventKey").substring(8);
		String sql = "insert into userScene(userID,sceneID) values('" + openID + "','" + sceneID + "')";
		jd.insort(sql);
		System.out.println(openID);
		System.out.println(sceneID);
		return new TextMessage(requestMap, "绑定成功");
	}
}
