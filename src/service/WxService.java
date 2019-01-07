package service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import handle.AccessToken;
import handle.BaseMessage;
import net.sf.json.JSONObject;
import util.DealPushEvents;
import util.DealTextMessage;
import util.ToXml;
import util.Util;

public class WxService {

	private static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String APPID = "wx50544760ab6889af";
	private static final String APPSECRET = "9b59b79ffdd5a6941a6bf336d6700ceb";
	// 用于存储 token
	private static AccessToken at;

	/**
	 * 获取accesstoken
	 */
	private static void getToken() {
		String url = GET_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		String tokenStr = Util.get(url);
		JSONObject jsonObject = JSONObject.fromObject(tokenStr);
		String token = jsonObject.getString("access_token");
		String expiresIn = jsonObject.getString("expires_in");
		// 创建token对象并存起来
		at = new AccessToken(token, expiresIn);
	}

	/**
	 * 供外部调用的获取token的方法
	 * 
	 * @return
	 */
	public static String getAccessToken() {
		if (at == null || at.isExpired()) {
			getToken();
		}
		return at.getAccessToken();
	}

	/**
	 * 解析用户发送的XML数据包
	 * 
	 * @param is
	 * @return
	 */
	public static Map<String, String> parseRequest(InputStream is) {
		Map<String, String> map = new HashMap<>();
		SAXReader reader = new SAXReader();
		try {
			// 读取输入流，获取文档对象
			Document document = reader.read(is);
			// 根据文档对象获取根节点
			Element root = document.getRootElement();
			// 获取根节点的所有子节点
			List<Element> elements = root.elements();
			for (Element e : elements) {
				map.put(e.getName(), e.getStringValue());
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 用于处理所有的事件和消息回复
	 * 
	 * @param requestMap
	 * @return 返回的是XML数据包
	 */
	public static String getResponse(Map<String, String> requestMap) {
		// 获取用户的消息类型
		String msgType = requestMap.get("MsgType");

		BaseMessage msg = null;
		switch (msgType) {
		// 文本消息
		case "text":
			// 对用户的文本消息进行处理
			msg = DealTextMessage.dealMessage(requestMap, msgType);
			break;
		// 对推送事件进行处理
		case "event":
			msg = dealEvent(requestMap);
		default:
			break;
		}

		/**
		 * 将返回内容处理成XML数据包
		 */
		if (msg != null) {
			return ToXml.beanToXml(msg);
		}
		return null;
	}

	/**
	 * 处理不同事件推送的方法
	 * 
	 * @param requestMap
	 * @return
	 */

	private static BaseMessage dealEvent(Map<String, String> requestMap) {
		String event = requestMap.get("Event");
		switch (event) {
		case "subscribe":
			return DealPushEvents.dealSubscribe(requestMap);

		case "SCAN":
			return DealPushEvents.dealScan(requestMap);

		case "CLICK":
			return DealPushEvents.dealClick(requestMap);

		case "VIEW":
			return DealPushEvents.dealView(requestMap);
		}
		return null;
	}

}
