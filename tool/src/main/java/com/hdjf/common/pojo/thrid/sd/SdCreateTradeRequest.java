package com.hdjf.common.pojo.thrid.sd;

import java.io.Serializable;
import java.util.List;


public class SdCreateTradeRequest implements Serializable{

    
	private static final long serialVersionUID = 1L;
	private String amount;
     private String merchantCode;
     private String subMerchantId;
     private String merchantOrderId;
     private String productName;
     private String merchantOrderDate;
     private String expiredDate;
     private String callbackUrl;
     private String ipAddress;
     private String merchantUserName;
     private String merchantUserCardId;
     private String merchantUserPhone;
     private String stageNum;
     private List<SdCreateTradeBizInfo> bizInfo;
     private String extParam;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getSubMerchantId() {
		return subMerchantId;
	}
	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}
	public String getMerchantOrderId() {
		return merchantOrderId;
	}
	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMerchantOrderDate() {
		return merchantOrderDate;
	}
	public void setMerchantOrderDate(String merchantOrderDate) {
		this.merchantOrderDate = merchantOrderDate;
	}
	public String getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMerchantUserName() {
		return merchantUserName;
	}
	public void setMerchantUserName(String merchantUserName) {
		this.merchantUserName = merchantUserName;
	}
	public String getMerchantUserCardId() {
		return merchantUserCardId;
	}
	public void setMerchantUserCardId(String merchantUserCardId) {
		this.merchantUserCardId = merchantUserCardId;
	}
	public String getMerchantUserPhone() {
		return merchantUserPhone;
	}
	public void setMerchantUserPhone(String merchantUserPhone) {
		this.merchantUserPhone = merchantUserPhone;
	}
	public String getStageNum() {
		return stageNum;
	}
	public void setStageNum(String stageNum) {
		this.stageNum = stageNum;
	}
	
	public List<SdCreateTradeBizInfo> getBizInfo() {
		return bizInfo;
	}
	public void setBizInfo(List<SdCreateTradeBizInfo> bizInfo) {
		this.bizInfo = bizInfo;
	}
	public String getExtParam() {
		return extParam;
	}
	public void setExtParam(String extParam) {
		this.extParam = extParam;
	}
     
     
     
}
