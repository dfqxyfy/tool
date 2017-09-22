package com.hdjf.common.pojo.thrid.sd;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;


public class SdReturnObj implements Serializable{

    private static final long serialVersionUID = 2122571529078856666L;
	private Object orderEntity;
    private int resultCode;
	private String resultInfo;
	
	public SdReturnObj(){
		this.resultCode = 0;
		this.resultInfo = "request success!";
	}
	
	
	public int getResultCode() {
		return resultCode;
	}


	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}


	public String getResultInfo() {
		return resultInfo;
	}


	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}


	public Object getOrderEntity() {
		return orderEntity;
	}


	public void setOrderEntity(Object orderEntity) {
		this.orderEntity = orderEntity;
	}


	@Override
	public String toString() {
		String string = null;
		try {
            string = JSON.toJSONString(this);
		} catch (Exception e) {
			string = "ReturnObj JOSN 转换异常 {code:"+this.resultCode+", message:"+this.resultInfo+", result:"+this.orderEntity+"}";
		}
		return string;
	}

	
}
