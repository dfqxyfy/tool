package com.hdjf.common.pojo.thrid.sd;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 功能描述：将请求参数转换成需要的格式。
 * @author yuchangcheng
 * @date 2017年9月15日
 */
public class RequestEntityUtils {
	
	/**
	 * 功能描述：将银行列表字符串形式转换成List形式。
	 * @return List<String>
	 * @author yuchangcheng
	 * @since  2017年9月15日
	 */
	public static List<String> convertStringToList(String bankNames){
		
		if(StringUtils.isBlank(bankNames)){
			return null;
		}
		String[] bankNameSplit = bankNames.split(",");
		if(StringUtils.isBlank(bankNameSplit.toString())){
			return null;
		}
		List<String> bankNameList = new ArrayList<String>();
		for (String bankName : bankNameSplit) {
			bankNameList.add(bankName);
		}
		
		return bankNameList;
	}

	/**
	 * 功能描述：根据JD文档要求，生成相应的sign。SHA256签名
	 * @return void
	 * @author yuchangcheng
	 * @since  2017年9月15日
	 */
	public static String createSignSHA256(JDRequestEntity requestEntity, String privateKey) {
		StringBuilder sb = new StringBuilder(512);
		sb.append(requestEntity.getVersion());
		sb.append(requestEntity.getCharset());
		sb.append(requestEntity.getTradeType());
		sb.append(requestEntity.getData());
		sb.append(requestEntity.getMerchantCode());
		sb.append(privateKey);
		return AlgorithmUtils.sha256Digest(sb.toString(),requestEntity.getCharset());
	}
	
	/**
	 * 功能描述：根据JD文档要求，生成相应的sign。SHA256签名
	 * @return void
	 * @author yuchangcheng
	 * @since  2017年9月15日
	 */
	public static String createSignSHA256(Map<String,String> paramMap, String privateKey) {
		StringBuilder sb = new StringBuilder();
		sb.append(paramMap.get("version"));
		sb.append(paramMap.get("charset"));
		sb.append(paramMap.get("tradeType"));
		sb.append(paramMap.get("data"));
		sb.append(paramMap.get("merchantCode"));
		sb.append(privateKey);
		return AlgorithmUtils.sha256Digest(sb.toString(),paramMap.get("charset"));
	}

	public static String createJson(String json, String privateKey) {
		StringBuilder sb = new StringBuilder();
		sb.append(json);
		sb.append(privateKey);
		return AlgorithmUtils.sha256Digest(sb.toString(),"utf-8");
	}

	/**
	 * 功能描述：加密成密文。按 des3-->base64-->url编码
	 * @return String
	 * @author yuchangcheng
	 * @since  2017年9月15日
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 * @param plainText:要加密的字符串
	 * @param privateKey
	 * @param charset
	 * @return
	 */
	public static String createCipherText(String plainText, String privateKey,String charset) {
		String cipherText = AlgorithmUtils.urlEncode(AlgorithmUtils.base64Encode(AlgorithmUtils.des3Encrypt(plainText, privateKey,charset)), charset);
		return cipherText;
	}

	/**
	 * 功能描述：解密。解密成明文。解密过程与加密相反。url解码-->base64解码-->des3解密
	 * @return String
	 * @author yuchangcheng
	 * @since  2017年9月15日
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 * @param cipherText
	 * @param privateKey
	 * @param charset
	 * @return
	 */
	public static String reverseCipherText(String cipherText,String privateKey, String charset) {
		String plainText = AlgorithmUtils.des3Decrypt(AlgorithmUtils.base64Decode(AlgorithmUtils.urlDecode(cipherText, charset)),privateKey, charset);
		return plainText;
	}
}
