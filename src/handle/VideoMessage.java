package handle;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("xml")
public class VideoMessage extends BaseMessage{
		@XStreamAlias("Description")
		private String description;
		@XStreamAlias("Title")
		private String title;
		@XStreamAlias("MediaId")
		private String mediaId;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		public VideoMessage(Map<String,String> requestMap,String description,String mediaId,String title) {
			super(requestMap);
			this.setMsgType("video");
			this.mediaId = mediaId;
			this.title = title;
			this.description = description;
		}
}
