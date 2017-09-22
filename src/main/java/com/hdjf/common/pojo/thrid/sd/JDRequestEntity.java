package com.hdjf.common.pojo.thrid.sd;

public class JDRequestEntity {
	private String version;// 版本号
	private String charset;// 字符编码
	private String tradeType;// 交易类型
	private String merchantCode;// 商户号
	private String data;// 加密数据 按参数列表组成JSON格式数据，然后使用3DES加密,base64编码,url编码
	private String sign;// 数据签名
						// SHA256签名，签名顺序为version+charset+tradetype+data+merchantCode+privateKey

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "JDRequestEntity [version=" + version + ", charset=" + charset + ", tradeType=" + tradeType
				+ ", merchantCode=" + merchantCode + ", data=" + data + ", sign=" + sign + ", getVersion()="
				+ getVersion() + ", getCharset()=" + getCharset() + ", getTradeType()=" + getTradeType()
				+ ", getMerchantCode()=" + getMerchantCode() + ", getData()=" + getData() + ", getSign()=" + getSign()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
