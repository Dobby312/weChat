package qrCode;

import net.sf.json.JSONObject;
import service.WxService;
import util.Util;

public class QrCode {
	/**
	 * 获取ticket
	 * 
	 * @return
	 */
	public static String getQrCode(String id) {

		String token = WxService.getAccessToken();
		String url = " https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + token;
		QrCodeJson qc = new QrCodeJson(id);
		JSONObject jsonObject = JSONObject.fromObject(qc.getMap());
		String data = jsonObject.toString();
		String result = Util.post(url, data);
		String ticket = JSONObject.fromObject(result).getString("ticket");

		return ticket;
	}

}
