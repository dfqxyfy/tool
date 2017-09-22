package com.hdjf.common.pojo.thrid.sd;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * 功能描述：具体算法的实现
 * @author yinyachuan
 * @date 2017年2月21日
 */
@SuppressWarnings("restriction")
public class AlgorithmUtils {
	
	/**
	 * 功能描述：加密des3
	 * @return
	 */
	public static byte[] des3Encrypt(String plainText, String key,String charset) {
		try {
			SecretKey secretKey = new SecretKeySpec(key.getBytes(charset),"DESede");
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(1, secretKey);
			return cipher.doFinal(plainText.getBytes(charset));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 功能描述：解密des3
	 * @return String
	 * @author yinyachuan
	 * @since  2017年2月21日
	 * @return
	 */
	public static String des3Decrypt(byte[] cipherText, String key,String charset) {
		try {
			SecretKey secretKey = new SecretKeySpec(key.getBytes(charset),"DESede");
			Cipher c1 = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			c1.init(2, secretKey);
			byte[] bytes = c1.doFinal(cipherText);
			return new String(bytes, charset);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 功能描述：base64编码
	 * @return String
	 * @author yinyachuan
	 * @return
	 */
	public static String base64Encode(byte[] input) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		return base64Encoder.encode(input);
	}

	/**
	 * 功能描述：base64解码
	 * @return byte[]
	 * @author yinyachuan
	 * @return
	 */
	public static byte[] base64Decode(String input) {
		try {
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] bytes = base64Decoder.decodeBuffer(input);
			return bytes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 功能描述：url编码
	 * @return String
	 * @author yinyachuan
	 * @return
	 */
	public static String urlEncode(String input, String charset) {
		try {
			return URLEncoder.encode(input, charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 功能描述：url解码
	 * @return String
	 * @author yinyachuan
	 * @return
	 */
	public static String urlDecode(String input, String charset) {
		try {
			return URLDecoder.decode(input, charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 功能描述：加密SHA256签名
	 * @return String
	 * @author yinyachuan
	 * @return
	 */
	public static String sha256Digest(String input, String charset) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] bytes = md.digest(input.getBytes(charset));
			StringBuilder sb = new StringBuilder(64);
			for (int i = 0; i < bytes.length; ++i) {
				String hex = Integer.toHexString(0xFF & bytes[i]);
				if (hex.length() == 1) {
					sb.append('0');
				}
				sb.append(hex);
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		String ss = "8X5kgFRO8S%2FNS2AY356OGGNEqhJpvrfGMMhYLut%2F5XuRbCncjqAI2M4C8HgHqg14nWNG0BvNwqkv%0ABhB7ddf%2Fr52tq0e%2F8YgphJRSsbhyIwcWiOtvVDMa1ZRgLT3Q%2FXm6eYl%2F5jnkNEPC0XBO8ffENAZO%0AlsV0vkzSOOF%2B0QBJYbmjRPoKyPK1KPlHjFwg%2FSctMCF%2BqgQAbWAAmUSO%2BI1JG4rVu0luiWDM8k4k%0AMn5kdo6XIm31q3Ui%2Fw5pmELNoU3TBGZqGbvGcf8qm39Lb3MA6k3JUslCNy0IWMRQZ2ZQES064zUc%0AYRvouMCMnXPu72KG";
		String res = RequestEntityUtils.reverseCipherText(ss, "5Qbn9*dDS6VywpJTusQTMw!b", "utf-8");
		System.out.println(res);
	}
}
