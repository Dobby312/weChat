package filter;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 自定义一个安全证书信任管理器，实现X509TrustManager接口
 * 方法全部为空，默认为所有链接都安全，可能存在安全隐患
 * @author Wzf
 *
 */

public class MyX509TrustManager implements X509TrustManager {

	//检查客户端证书
	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

	}

	//检查服务器端证书
	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

	}

	//返回受信任的X509证书数组
	@Override
	public X509Certificate[] getAcceptedIssuers() {

		return null;
	}

}
