	package handle;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {
	@XStreamAlias("Content")
	private String content;

	//提供外部访问的方法
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	//通过构造函数设置所有标签内容
	public TextMessage(Map<String,String> requestMap,String content) {
		//通过调用父类的构造函数设置某些固定的标签内容
		super(requestMap);
		
		//设置返回的文本消息的msgtype为text
		this.setMsgType("text");
		
		//回复内容单独在构造函数里设置
		this.content = content;
	}
	
}
