package templateMessage;

import java.util.LinkedHashMap;
import java.util.Map;

public class TemplateJson {

	private Map<String,Object> map;

	   private Map<String,Object> data;
	   
	   private  String  template_id = "iZ0o0SaB7b8PuggND_w4WJe95AYeiS2tdXrqOUhD8CI"; 

	  

	   public TemplateJson(String touser, String url, String num,String time,String adress) {

	      map = new LinkedHashMap<String,Object>();

	      data = new LinkedHashMap<String,Object>();

	     

	      LinkedHashMap<String,String> first=new LinkedHashMap<String,String>();

	      first.put("value","有新的报警");

	      first.put("color","#743A3A");

	      data.put("first",first);

	 

	      LinkedHashMap<String,String> keyword1=new LinkedHashMap<String,String>();

	      keyword1.put("value",num);

	      keyword1.put("color","#FF0000");

	      data.put("keyword1",keyword1);

	 

	      LinkedHashMap<String,String> keyword2=new LinkedHashMap<String,String>();

	      keyword2.put("value",time);

	      keyword2.put("color","#C4C400");

	      data.put("keyword2",keyword2);

	 

	      LinkedHashMap<String,String> keyword3=new LinkedHashMap<String,String>();

	      keyword3.put("value",adress);

	      keyword3.put("color","#0000FF");

	      data.put("keyword3",keyword3);

	 


	      LinkedHashMap<String,String> remark=new LinkedHashMap<String,String>();

	      remark.put("value","请尽快确认并处理");

	      remark.put("color","#000000");

	      data.put("remark",remark);

	 

	      map.put("touser",touser);

	      map.put("template_id",template_id);

	      map.put("url",url);

	      

	      map.put("data",data);

	   }

	 

	   public Map<String,Object> getMap() {

	      return map;

	   }

	 

	   public void setMap(Map<String,Object> map){

	      this.map =map;

	   }

	 

	   public Map<String,Object> getDate() {

	      return data;

	   }

	 

	   public void setDate(Map<String,Object> date){

	      this.data =date;

	   }





	public String getTemplate_id() {
		return template_id;
	}



	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}




}
