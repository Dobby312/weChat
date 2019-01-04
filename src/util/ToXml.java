package util;

import com.thoughtworks.xstream.XStream;

import handle.BaseMessage;
import handle.ImageMessage;
import handle.NewsMessage;
import handle.TextMessage;
import handle.VideoMessage;

public class ToXml {
	/**
	 * 把消息对象处理成xml数据包
	 * 
	 * @param msg
	 * @return
	 */
	public static String beanToXml(BaseMessage msg) {
		XStream stream = new XStream();
		stream.processAnnotations(TextMessage.class);
		stream.processAnnotations(ImageMessage.class);
		stream.processAnnotations(NewsMessage.class);
		stream.processAnnotations(VideoMessage.class);
		String xml = stream.toXML(msg);
		return xml;
	}

}
