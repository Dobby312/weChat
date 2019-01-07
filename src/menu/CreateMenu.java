package menu;

import menu.Button;
import menu.ClickButton;
import menu.PhotoOrAlbum;
import menu.SubButton;
import menu.ViewButton;
import net.sf.json.JSONObject;
import service.WxService;
import util.Util;

public class CreateMenu {
	
	public static void main(String[] args) {
		// 菜单对象
		Button btn = new Button();
		// 第一个一级菜单
		btn.getButton().add(new ClickButton("激活账号", "1"));
		// 第二个一级菜单
		btn.getButton().add(new ViewButton("一级跳转", "http://www.coolman.top/hcdpm"));
		// 第三个一级菜单
		SubButton sb = new SubButton("含子菜单");
		// 第三个一级菜单添加二级菜单
		sb.getSub_button().add(new PhotoOrAlbum("传图", "31"));
		sb.getSub_button().add(new ClickButton("合作", "32"));
		sb.getSub_button().add(new ViewButton("新闻", "http://news.163.com"));
		// 将包含子菜单的一级菜单加入
		btn.getButton().add(sb);
		// 转为JSON
		JSONObject jsonObject = JSONObject.fromObject(btn);
		// 准备url
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", WxService.getAccessToken());
		// 发送请求
		@SuppressWarnings("unused")
		String result = Util.post(url, jsonObject.toString());
		//System.out.println(result);
	}
}
