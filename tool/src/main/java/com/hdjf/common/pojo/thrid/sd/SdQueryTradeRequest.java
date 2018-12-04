package com.hdjf.common.pojo.thrid.sd;

import java.io.Serializable;


public class SdQueryTradeRequest implements Serializable{

    
	private static final long serialVersionUID = 1L;
	private String merchantOrderId;
    private String merchantCode;
    private String orderReqDate;
	public String getMerchantOrderId() {
		return merchantOrderId;
	}
	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getOrderReqDate() {
		return orderReqDate;
	}
	public void setOrderReqDate(String orderReqDate) {
		this.orderReqDate = orderReqDate;
	}
    
     
}
