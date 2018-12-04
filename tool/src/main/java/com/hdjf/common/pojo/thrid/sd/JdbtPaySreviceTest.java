package com.hdjf.common.pojo.thrid.sd;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.fastjson.JSONObject;



public class JdbtPaySreviceTest {
	private static final String VERSION = "version";
	private static final String TRADETYPE = "tradeType";
	private static final String MERCHANT_CODE = "merchantCode";
	private static final String PRIVATE_KEY = "privateKey";
	private static final String SOURCETYPE_PC = "sourceType_pc";
	private static final String SOURCETYPE_WAP = "sourceType_wap";
	private static final String ORDER_TYPE = "orderType";
	private static final String CALLBACK_URL = "callbackUrl";
	private static final String PAGEBACK_URL = "pagebackUrl";
	private static final String DATA = "data";
	private static final String SIGN = "sign";
	private static final String CHARSET = "charset";	
	private static final String DATE_FORMAT = "yyyyMMddHHmmss";
	
	
//
//
//	public static void main(String []args) {
//		String privateKey = "5Qbn9*dDS6VywpJTusQTMw!b";
//		String charset = "UTF-8";
//
//		Map<String, String> map = new HashMap<String, String>();
//		SdCreateTradeRequest request = new SdCreateTradeRequest();
//		request.setAmount("100");
//		List<SdCreateTradeBizInfo> bizInfos = new ArrayList<SdCreateTradeBizInfo>();
//		SdCreateTradeBizInfo bizinfo = new SdCreateTradeBizInfo();
//		bizinfo.setBeginCourseDate("20170919123000");
//		bizinfo.setClassFrom("走读");
//		bizinfo.setClassPeriod("12");
//		bizinfo.setClassPlace("");
//		bizinfo.setClassValidityDateCount("12");
//		bizinfo.setClassValidityTime("50");
//		bizinfo.setCourseAmount("100");
//		bizinfo.setCourseName("北大自考");
//		bizinfo.setCourseNo("北大自考");
//		bizinfo.setCourseType("4");
//		bizinfo.setRegistDegree("C");
//		bizinfo.setRegistMajor("计算机应用技术");
//		bizinfo.setRegistType("A");
//		bizinfo.setRegistUniversity("北京大学");
//		bizInfos.add(bizinfo);
//		request.setBizInfo(bizInfos);
//		request.setCallbackUrl("http://localhost:8080/app");
//		request.setExpiredDate("20170930090900");
//		request.setExtParam("");
//		request.setIpAddress("192.168.1.1");
//		request.setMerchantCode("6314347443207662593");
//		request.setMerchantOrderDate("20170919103900");
//		request.setMerchantOrderId("2017091910390001");
//		request.setMerchantUserCardId("130183198903020814");
//		request.setMerchantUserName("石亚东");
//		request.setMerchantUserPhone("13021902022");
//		request.setStageNum("12");
//		String jsonString = JSONObject.toJSONString(request);
//		System.out.println("urlEncode:" + jsonString);
//		String urlEncode = AlgorithmUtils.urlEncode(AlgorithmUtils.base64Encode(AlgorithmUtils.des3Encrypt(jsonString, privateKey,charset)), charset);
//		System.out.println("urlEncode:" + urlEncode);
//
//		String presign = "1.0"+"UTF-8"+"01"+urlEncode+"6314347443207662593"+privateKey;
//		String sign = AlgorithmUtils.sha256Digest(presign, "UTF-8");
//
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("version", "1.0");
//		params.put("charset", "UTF-8");
//		params.put("tradeType", "01");
//		params.put("data", urlEncode);
//		params.put("merchantCode", "6314347443207662593");
//		params.put("sign",sign);
//		String result = HttpClientUtil.sendPost("http://182.92.6.16:8081/hd-merchant-biz-app/service/sd/trade", JSONObject.toJSONString(params));
//		//String result = HttpClientUtil.sendPostJson("http://127.0.0.1:8080/hd-merchant-biz-app/service/sd/trade", params);
//
//		System.out.println(result);
//
////		String des3Decrypt = AlgorithmUtils.des3Decrypt(AlgorithmUtils.base64Decode(AlgorithmUtils.urlDecode(urlEncode, charset)),privateKey, charset);
////		System.out.println("des3Decrypt:" + des3Decrypt);
//
//	}
	@Test
	public void testJiemi(){
		String data = "GCo81wxjQiq08Du%2FHoyVh%2BBIpb6Ezh1My7buoIR01HMXTxeJqFwA7ts2XxFwRhF%2By%2BmGADeS1Ry7%0D%0AUdNw%2BVtLij35Ex9N893P0kB9BNmPJLxt5QX%2F7BgyKY6v0xQjBWDdQyT33n1x%2BP1x%2BHrlk6O1Yxsb%0D%0ADM7VXPLej3%2FEVjvEqWlzoD%2B10Qa2OnXdD2jyci3GVFeKNeJyeinArIZv4z7C2u2GR6XKlxuYiXoQ%0D%0AuCBWP91BqEpck6uKsPChw84Z5%2FSRbiWneIUTb3yXjvOTr30mYTBDZ0Ru69EFjmPWEZ5lzKP75iiA%0D%0AlC0PGlUGC4iycsduNp2BLQXjqarvOQQYru6ITLRzwILuJvxx%2F47%2BYRYBL%2FJwqb6SFBJClE88Cio5%0D%0AgTOgKMvVhEdHr%2Bft0WIZosTcNMSbwTGBf5vUvxSgWgm581%2FvfxDzDXiCAP1u78Fyw1zRzzDD1jvv%0D%0AuTWdY0bQG83CqeMKZlyciNrNMIclWsFcdIKVTiPRl6%2BDotan4y4f4cSldN0fG1Ajde3h91TmOr9m%0D%0Asve%2B49GinYPbu663mn8bgJHKc%2FgKJT2YnyoOaROq2k8DNVY3cc%2FNcZL9CxMauGpLnewf36kSQfie%0D%0A8yEBit7aZNwh%2FK6JJjNES%2FTTPw1YXVpDy%2BmGADeS1Rw44zsGAb4Y%2BA3TNXuMDUGHvkxVk3cxr5dW%0D%0ACFUmzyLzFxUrwhFPm4IbMCPhSiby3KBb5v3fZ4yh0lxZnGgpFpETKg5pE6raTwMuQUokbW9V9xBc%0D%0AWOBC9UNwWe7Z1zHMbgXXp5hrd29BPSH8rokmM0RL4NKlLZA4%2BnFxpfy4VzAmM3T%2FyORYJ4CJQbzI%0D%0AFjGjWsWmUcvnSIwScsCshm%2FjPsLa7YZHpcqXG5iJehC4IFY%2F3UGoSlyTq4qwiwTr8E8g%2BBTaGhqq%0D%0ABO56XljMLwWroBj6";
		
		String des3Decrypt = AlgorithmUtils.des3Decrypt(AlgorithmUtils.base64Decode(AlgorithmUtils.urlDecode(data, "UTF-8")),"5Qbn9*dDS6VywpJTusQTMw!b", "UTF-8");
		try {
			SdCreateTradeRequest tradeReq = JSON.parse(des3Decrypt, SdCreateTradeRequest.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("des3Decrypt:" + des3Decrypt);	
	
	}
//
//	@Test
//	public void test() {
//		String privateKey = "5Qbn9*dDS6VywpJTusQTMw!b";
//		String charset = "UTF-8";
//
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("merchantOrderId", "2017091910390001");
//		map.put("merchantCode", "6314347443207662593");
//		map.put("orderReqDate", "2017091910390001");
//
//		String jsonString = JSONObject.toJSONString(map);
//
//		String urlEncode = AlgorithmUtils.urlEncode(AlgorithmUtils.base64Encode(AlgorithmUtils.des3Encrypt(jsonString, privateKey,charset)), charset);
//		System.out.println("urlEncode:" + urlEncode);
//
//		String presign = "1.0"+"UTF-8"+"01"+urlEncode+"6314347443207662593"+privateKey;
//		String sign = AlgorithmUtils.sha256Digest(presign, "UTF-8");
//
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("version", "1.0");
//		params.put("charset", "UTF-8");
//		params.put("tradeType", "02");
//		params.put("data", urlEncode);
//		params.put("merchantCode", "6314347443207662593");
//		params.put("sign",sign);
//		String result = HttpClientUtil.sendPostJson("http://182.92.6.16:8081/hd-merchant-biz-app/service/sd/trade", params);
//		System.out.println(result);
//
//
//	}
	

	@Test
	public void test1() {
		String privateKey = "5Qbn9*dDS6VywpJTusQTMw!b";
		String charset = "UTF-8";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("refOrderId", "2017091910390002");
		//map.put("amount", "100");
		map.put("merchantCode", "6314347443207662593");
		map.put("merchantOrderId", "2017091910390001");
		map.put("merchantOrderId", "20170925094126010388-1506303698142-2121");
		map.put("merchantOrderId", "20170925101434010389-1506305686184-5253");
		map.put("orderSubmitTime", "20170922173807");
		map.put("tradeDate", "20170922173809");
		map.put("orderState", "5000");
		map.put("amount", "110");
		map.put("stageNum", "6");
		Map<String,Object> params1 = new HashMap<String,Object>();
		params1.put("orderEntity", map);
		params1.put("resultCode", 0);
		params1.put("resultInfo", "request success");


		String jsonString = JSONObject.toJSONString(params1);
		
		String urlEncode = AlgorithmUtils.urlEncode(AlgorithmUtils.base64Encode(AlgorithmUtils.des3Encrypt(jsonString, privateKey,charset)), charset);
		System.out.println("urlEncode:" + urlEncode);
		
		String presign = "1.0"+"UTF-8"+"01"+urlEncode+"6314347443207662593"+privateKey;
		String sign = AlgorithmUtils.sha256Digest(presign, "UTF-8");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("version", "1.0");
		params.put("charset", "UTF-8");
		params.put("tradeType", "03");
		params.put("data", urlEncode);
		params.put("merchantCode", "6314347443207662593");
		params.put("sign",sign);

//		String basReq = RequestEntityUtils.createCipherText(JSONObject.toJSONString(params),"5Qbn9*dDS6VywpJTusQTMw!b","utf-8");
//		try {
//			basReq = URLEncoder.encode(basReq,"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		//String result = HttpClientUtil.sendPost("http://172.16.7.137:8080/epay-war/ep_pay/epayPay/haierPayBackCallBack.action",JSONObject.toJSONString(params));
		String result = HttpClientUtil.sendPost("http://42.62.70.203/epay-war/ep_pay/epayPay/haierPayBackCallBack.action",JSONObject.toJSONString(params));
		//String result = HttpClientUtil.sendPost("http://127.0.0.1:8080/epay-war/ep_pay/epayPay/haierPayBackCallBack.action",JSONObject.toJSONString(params));
		System.out.println("***********************");
		System.out.println(result);


	}
}
