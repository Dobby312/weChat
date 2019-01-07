package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public static BaseMessage dealMessage(Map<String, String> requestMap, String msgType) {
		// 用户发来的内容
		String content = requestMap.get("Content");

		/**
		 * 回复图文消息
		 */

		if (content != null && content.equals("设备状态")) {
			List<Article> articles = new ArrayList<>();
			articles.add(new Article("当前设备状态", "图文消息的介绍",
					"http://mmbiz.qpic.cn/mmbiz_jpg/pnW3cx0mRlpoG3Pgv3F4dvATIMF3vhBCeHQbwiaGiazd8xR8Q6iaiaib4NUz0nFP4OsQicQp1YBkJ8icaFcLjdPycnOew/0",
					"http://www.baidu.com"));
			NewsMessage nm = new NewsMessage(requestMap, articles);
			return nm;
		}

		if (content != null && content.equals("看板")) {
			List<Article> articles = new ArrayList<>();
			articles.add(new Article("当前看板内容", "图文消息的介绍",
					"http://mmbiz.qpic.cn/mmbiz_jpg/pnW3cx0mRlpk2nUZ0E2AHgve2evBcSrzxbyI28iaiayyJBYpLG7YE34hx2TAY77ePtZZNGGXahecM9F1ENAXesOw/0",
					"http://www.baidu.com"));
			NewsMessage nm = new NewsMessage(requestMap, articles);
			return nm;
		}
		/**
		 * 回复文本消息
		 */
		// 调用处理各类消息的接口，将回复给用户的XML数据包各个标签内容设置好
		TextMessage tm = null;
		switch (msgType) {
		case "text":
			tm = new TextMessage(requestMap, "该信息是文字信息，我已经做出了处理");
			// tm = new TextMessage(requestMap,resp);
			break;
		case "image":
			tm = new TextMessage(requestMap, "该信息是图片信息，我已经做出了处理");
			// tm = new TextMessage(requestMap,resp);
			break;
		default:
			break;
		}

		// 将内容返回
		return tm;
	}
}
