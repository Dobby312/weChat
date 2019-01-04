package handle;

public class AccessToken {
	private String accessToken;
	private long expiresTime;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public long getExpiresTime() {
		return expiresTime;
	}
	public void setExpiresTime(long expiresTime) {
		this.expiresTime = expiresTime;
	}
	public AccessToken(String accessToken, String expiresIn) {
		super();
		this.accessToken = accessToken;
		expiresTime = System.currentTimeMillis()+Integer.parseInt(expiresIn)*1000;
	}
	
	/**
	 * 判断token是否过期
	 * @return
	 */
	public boolean isExpired() {
		return  System.currentTimeMillis() > expiresTime;
			
		}
	}
	

