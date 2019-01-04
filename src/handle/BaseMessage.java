package handle;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class BaseMessage {
	@XStreamAlias("ToUserName")
	private String toUserName;
	@XStreamAlias("FromUserName")
	private String fromUserName;
	@XStreamAlias("MsgType")
	private String msgType;
	@XStreamAlias("CreateTime")
	private String createTime;
	
	//提供外部访问的方法
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	//通过构造函数设置固定的标签内容
	public BaseMessage(Map<String,String> requestMap) {
		this.toUserName = requestMap.get("FromUserName");
		this.fromUserName = requestMap.get("ToUserName");
		this.createTime = System.currentTimeMillis()/1000+"";
	}
	
	public BaseMessage(String toUserName, String fromUserName, String msgType, String createTime) {
		super();
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.msgType = msgType;
		this.createTime = createTime;
	}
	
	
	
	
}
