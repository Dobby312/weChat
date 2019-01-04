package qrCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class QrCodeJson {
	private Map<String,Object> map;
	private Map<String,Object> action_info;
	private String action_name = "QR_LIMIT_STR_SCENE";
	
	public QrCodeJson(String sceneID) {
		 map = new LinkedHashMap<String,Object>();
		 action_info = new LinkedHashMap<String,Object>();
		 
		 LinkedHashMap<String,String> scene = new LinkedHashMap<String,String>();
		 scene.put("scene_str", sceneID);
		 
		 action_info.put("scene", scene);
		 
		 map.put("action_name", action_name);
		 map.put("action_info", action_info);
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Map<String, Object> getAction_info() {
		return action_info;
	}

	public void setAction_info(Map<String, Object> action_info) {
		this.action_info = action_info;
	}

	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	
	

}
