package templateMessage;

import org.junit.Test;
import net.sf.json.JSONObject;
import service.WxService;
import util.Util;

public class TemplateMessageManager {

//	private static String touser = "obMc01sradiJc-tdgwm_mjI33LrY";
//	private static String linkUrl = "http://www.coolman.top/Gifit";
//	private static String num = "21";
//	private static String adress = "合欢路19号";
//	private static long currentTime = System.currentTimeMillis();
//	static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	static Date date = new Date(currentTime);
//	private static String time = formatter.format(date);

	/**
	 * 设置行业
	 */

	public void set() {
		String token = WxService.getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=" + token;
		String data = " {\r\n" + "          \"industry_id1\":\"1\",\r\n" + "          \"industry_id2\":\"3\"\r\n"
				+ "       }";
		String result = Util.post(url, data);

	}

	/**
	 * 获取行业
	 */

	public void get() {
		String token = WxService.getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=" + token;
		String result = Util.get(url);
	}

	/**
	 * 发送报警模板消息
	 */
	@Test
	public  void sendTemplateMessage(String touser, String linkUrl, String num, String time, String adress) {
		String token = WxService.getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + token;
		String data = toJson(touser, linkUrl, num, time, adress);
		String result = Util.post(url, data);

	}

	/**
	 * 生成需要发送的json数据模板
	 * 
	 * @param touser
	 * @param url
	 * @param num
	 * @param time
	 * @param adress
	 * @return
	 */
	public String toJson(String touser, String url, String num, String time, String adress) {
		TemplateJson tj = new TemplateJson(touser, url, num, time, adress);
		JSONObject jsonObject = JSONObject.fromObject(tj.getMap());
		return jsonObject.toString();
	}

}
