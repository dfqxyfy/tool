package com.hdjf.common.pojo.thrid.sd;


import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Http客户端工具类<br/>
 * 这是内部调用类，请不要在外部调用。
 * 
 * @author miklchen
 * 
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class HttpClientUtil {

	public static final String SunX509 = "SunX509";
	public static final String JKS = "JKS";
	public static final String PKCS12 = "PKCS12";
	public static final String TLS = "TLS";
	private static Object lock = new Object();
	private static CloseableHttpClient httpClient = null;

	public static synchronized HttpClient getHttpClient() {
		if (null == httpClient) {
			PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000).setConnectTimeout(3000).build();
			httpClient = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(requestConfig)
					.setConnectionManager(cm).build();
		}
		return httpClient;
	}

	/**
	 * 功能描述：向制定url发送参数 取得其返回内容
	 * 
	 * @param url
	 * @param param
	 * @return
	 * 
	 * @author 褚勇文
	 * 
	 * @since 2015年7月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public static String sendPost(String url, String param) {
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和url之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			//conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type","application/octet-stream");
			// 设置连接时间
			conn.setConnectTimeout(3000);
			// 设置接收数据时间
			conn.setReadTimeout(3000);
			// 设置是否向httpUrlConnection输出,post请求参数放在http正文内,因此需要设为true
			conn.setDoOutput(true);
			// 设置是否从httpUrlConnection 读入，
			conn.setDoInput(true);
			// post请求不能使用缓存
			conn.setUseCaches(false);
			// 设定请求的方法为post
			conn.setRequestMethod("POST");

			// 获取HttpURLConnection对象对应的输出流 已包含 conn.connect();
			PrintWriter out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			if (out != null) {
				out.close();
			}

			// 定义BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			if (in != null) {
				in.close();
			}
		} catch (Exception e) {
			new RuntimeException("连接微信服务器发生错误");
		}
		return result;
	}

	public static String readProperties(String configName, String key) {
		String messageUrl = "";
		synchronized (lock) {
			messageUrl = ResourceBundle.getBundle(configName).getString(key);
		}
		return messageUrl;
	}

	/**
	 * get HttpURLConnection
	 * 
	 * @param strUrl
	 *            url地址
	 * @return HttpURLConnection
	 * @throws IOException
	 */
	public static HttpURLConnection getHttpURLConnection(String strUrl) throws IOException {
		URL url = new URL(strUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		return httpURLConnection;
	}

	/**
	 * get HttpsURLConnection
	 * 
	 * @param strUrl
	 *            url地址
	 * @return HttpsURLConnection
	 * @throws IOException
	 */
	public static HttpsURLConnection getHttpsURLConnection(String strUrl) throws IOException {
		URL url = new URL(strUrl);
		HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
		return httpsURLConnection;
	}

	/**
	 * 获取不带查询串的url
	 * 
	 * @param strUrl
	 * @return String
	 */
	public static String getURL(String strUrl) {

		if (null != strUrl) {
			int indexOf = strUrl.indexOf("?");
			if (-1 != indexOf) {
				return strUrl.substring(0, indexOf);
			}

			return strUrl;
		}

		return strUrl;

	}

	/**
	 * 获取查询串
	 * 
	 * @param strUrl
	 * @return String
	 */
	public static String getQueryString(String strUrl) {

		if (null != strUrl) {
			int indexOf = strUrl.indexOf("?");
			if (-1 != indexOf) {
				return strUrl.substring(indexOf + 1, strUrl.length());
			}

			return "";
		}

		return strUrl;
	}

	/**
	 * 查询字符串转换成Map<br/>
	 * name1=key1&name2=key2&...
	 * 
	 * @param queryString
	 * @return
	 */
	public static Map queryString2Map(String queryString) {
		if (null == queryString || "".equals(queryString)) {
			return null;
		}

		Map m = new HashMap();
		String[] strArray = queryString.split("&");
		for (int index = 0; index < strArray.length; index++) {
			String pair = strArray[index];
			HttpClientUtil.putMapByPair(pair, m);
		}

		return m;

	}

	/**
	 * 把键值添加至Map<br/>
	 * pair:name=value
	 * 
	 * @param pair
	 *            name=value
	 * @param m
	 */
	public static void putMapByPair(String pair, Map m) {

		if (null == pair || "".equals(pair)) {
			return;
		}

		int indexOf = pair.indexOf("=");
		if (-1 != indexOf) {
			String k = pair.substring(0, indexOf);
			String v = pair.substring(indexOf + 1, pair.length());
			if (null != k && !"".equals(k)) {
				m.put(k, v);
			}
		} else {
			m.put(pair, "");
		}
	}

	/**
	 * BufferedReader转换成String<br/>
	 * 注意:流关闭需要自行处理
	 * 
	 * @param reader
	 * @return String
	 * @throws IOException
	 */
	public static String bufferedReader2String(BufferedReader reader) throws IOException {
		StringBuffer buf = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			buf.append(line);
			buf.append("\r\n");
		}

		return buf.toString();
	}

	/**
	 * 处理输出<br/>
	 * 注意:流关闭需要自行处理
	 * 
	 * @param out
	 * @param data
	 * @param len
	 * @throws IOException
	 */
	public static void doOutput(OutputStream out, byte[] data, int len) throws IOException {
		int dataLen = data.length;
		int off = 0;
		while (off < data.length) {
			if (len >= dataLen) {
				out.write(data, off, dataLen);
				off += dataLen;
			} else {
				out.write(data, off, len);
				off += len;
				dataLen -= len;
			}

			// 刷新缓冲区
			out.flush();
		}

	}

	/**
	 * 获取SSLContext
	 * 
	 * @param trustPasswd
	 * @param keyPasswd
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 * @throws IOException
	 * @throws CertificateException
	 * @throws UnrecoverableKeyException
	 * @throws KeyManagementException
	 */
	public static SSLContext getSSLContext(FileInputStream trustFileInputStream, String trustPasswd,
			FileInputStream keyFileInputStream, String keyPasswd) throws NoSuchAlgorithmException, KeyStoreException,
			CertificateException, IOException, UnrecoverableKeyException, KeyManagementException {

		// ca
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(HttpClientUtil.SunX509);
		KeyStore trustKeyStore = KeyStore.getInstance(HttpClientUtil.JKS);
		trustKeyStore.load(trustFileInputStream, HttpClientUtil.str2CharArray(trustPasswd));
		tmf.init(trustKeyStore);

		final char[] kp = HttpClientUtil.str2CharArray(keyPasswd);
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(HttpClientUtil.SunX509);
		KeyStore ks = KeyStore.getInstance(HttpClientUtil.PKCS12);
		ks.load(keyFileInputStream, kp);
		kmf.init(ks, kp);

		SecureRandom rand = new SecureRandom();
		SSLContext ctx = SSLContext.getInstance(HttpClientUtil.TLS);
		ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), rand);

		return ctx;
	}

	/**
	 * 获取CA证书信息
	 * 
	 * @param cafile
	 *            CA证书文件
	 * @return Certificate
	 * @throws CertificateException
	 * @throws IOException
	 */
	public static Certificate getCertificate(File cafile) throws CertificateException, IOException {
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream(cafile);
		Certificate cert = cf.generateCertificate(in);
		in.close();
		return cert;
	}

	/**
	 * 字符串转换成char数组
	 * 
	 * @param str
	 * @return char[]
	 */
	public static char[] str2CharArray(String str) {
		if (null == str)
			return null;

		return str.toCharArray();
	}

	/**
	 * 存储ca证书成JKS格式
	 * 
	 * @param cert
	 * @param alias
	 * @param password
	 * @param out
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 */
	public static void storeCACert(Certificate cert, String alias, String password, OutputStream out)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		KeyStore ks = KeyStore.getInstance("JKS");

		ks.load(null, null);

		ks.setCertificateEntry(alias, cert);

		// store keystore
		ks.store(out, HttpClientUtil.str2CharArray(password));

	}

	public static InputStream String2Inputstream(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}

	/**
	 * InputStream转换成Byte 注意:流关闭需要自行处理
	 * 
	 * @param in
	 * @return byte
	 * @throws Exception
	 */
	public static byte[] InputStreamTOByte(InputStream in) throws IOException {

		int BUFFER_SIZE = 4096;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;

		while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);

		data = null;
		byte[] outByte = outStream.toByteArray();
		outStream.close();

		return outByte;
	}

	/**
	 * InputStream转换成String 注意:流关闭需要自行处理
	 * 
	 * @param in
	 * @param encoding
	 *            编码
	 * @return String
	 * @throws Exception
	 */
	public static String InputStreamTOString(InputStream in, String encoding) throws IOException {

		return new String(InputStreamTOByte(in), encoding);

	}
	
	

}
