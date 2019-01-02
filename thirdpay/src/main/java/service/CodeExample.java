package service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class CodeExample<T,K> {

	public static void main(String[] args) {
		CodeExample ex = new CodeExample();
		String paymentUrl = ex.doPayment();
		System.out.println("url thanh toan = "+paymentUrl);
	}
	
	public String doPayment() {
		// Url receive after send payment request
		String paymentUrl = "";
		
		
		String requestUrl = "https://api.pay.truemoney.com.vn/pay/api/v1/do-payment";
		String accessKey = "63x7p8thhht1zf3bk7x9"; // require your access key from Truemoney

		String secretKey = "ta96fcp6zw46jt1rtgqed52rrh73yij8"; // require your access key from Truemoney

		// Order_Id unique
		String orderId = "";
		// Order information
		String orderInfo = "";
		// Url get transaction results
		String returnUrl = "https://ecom.truemoney.com.vn/";
		// Amount
		BigDecimal amount = new BigDecimal(100000);
		//Payment methods
		String paymentType = "2";
		
		String walletCode = "TRUEMONEY";
		
		String bankCode = "";
		// Vietnamese or English language (vi or en)
		String language = "vi";
		// Signature
		String signature = generateSignatures(accessKey, amount, orderId, orderInfo, returnUrl, secretKey);
		
		
		PaymentRequest requestPayment = new PaymentRequest();
		requestPayment.setAmount(amount);
		requestPayment.setAccess_key(accessKey);
		requestPayment.setOrder_id(orderId);
		requestPayment.setOrder_info(orderInfo);
		requestPayment.setPayment_type(paymentType);
		requestPayment.setWallet_code(walletCode);
		requestPayment.setBank_code(bankCode);
		requestPayment.setReturn_url(returnUrl);
		requestPayment.setSignature(signature);
		requestPayment.setLanguage(language);
		try {
			PaymentResponse responsePayment = postToHTTPSAddress(requestUrl, requestPayment, PaymentResponse.class);
			if (responsePayment != null) {
				String responseCode = responsePayment.getResponse_code();
				if (responseCode.equals("00")) {
					PaymentBody body = responsePayment.getData();
					if (body != null) {
						paymentUrl = body.getPayment_url();
					}
				}else {
					// case processing failed
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paymentUrl;
	}
	

	public  PaymentResponse postToHTTPSAddress(String url, PaymentRequest req, Class type) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
			headers.add("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");

			HttpEntity request = new HttpEntity(req, headers);

			PaymentResponse obj = restTemplate.postForObject(url, request, PaymentResponse.class);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String generateSignatures(String access_key, BigDecimal amount, String orderId, String orderInfo,
			String returnUrl, String secretkey) {

		String requestParam = "access_key=" + access_key + "&amount=" + amount + "&order_id=" + orderId + "&order_info="
				+ orderInfo + "&return_url=" + returnUrl;

		return hmacDigest(requestParam, secretkey, "HmacSHA256");
	}

	public static String hmacDigest(String msg, String keyString, String algo) {
		String digest = "";
		try {
			if (keyString != null && keyString.length() > 0) {
				SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
				Mac mac = Mac.getInstance(algo);
				mac.init(key);
				byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));
				StringBuffer hash = new StringBuffer();
				for (int i = 0; i < bytes.length; i++) {
					String hex = Integer.toHexString(0xFF & bytes[i]);
					if (hex.length() == 1) {
						hash.append('0');
					}
					hash.append(hex);
				}
				digest = hash.toString();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		return digest;
	}
	
	
	class PaymentRequest {

		private String access_key;

		private BigDecimal amount;

		private String order_id;

		private String order_info;

		private String return_url;

		private String bank_code;

		private String wallet_code;

		private String payment_type;

		private String language;

		private String signature;

		public String getAccess_key() {
			return access_key;
		}

		public void setAccess_key(String access_key) {
			this.access_key = access_key;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}

		public String getOrder_id() {
			return order_id;
		}

		public void setOrder_id(String order_id) {
			this.order_id = order_id;
		}

		public String getOrder_info() {
			return order_info;
		}

		public void setOrder_info(String order_info) {
			this.order_info = order_info;
		}

		public String getReturn_url() {
			return return_url;
		}

		public void setReturn_url(String return_url) {
			this.return_url = return_url;
		}

		public String getBank_code() {
			return bank_code;
		}

		public void setBank_code(String bank_code) {
			this.bank_code = bank_code;
		}

		public String getWallet_code() {
			return wallet_code;
		}

		public void setWallet_code(String wallet_code) {
			this.wallet_code = wallet_code;
		}

		public String getPayment_type() {
			return payment_type;
		}

		public void setPayment_type(String payment_type) {
			this.payment_type = payment_type;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public String getSignature() {
			return signature;
		}

		public void setSignature(String signature) {
			this.signature = signature;
		}

	}
	
	class PaymentResponse {

		private String response_code;

		private String response_message;

		private PaymentBody data;

		public String getResponse_code() {
			return response_code;
		}

		public void setResponse_code(String response_code) {
			this.response_code = response_code;
		}

		public String getResponse_message() {
			return response_message;
		}

		public void setResponse_message(String response_message) {
			this.response_message = response_message;
		}

		public PaymentBody getData() {
			return data;
		}

		public void setData(PaymentBody data) {
			this.data = data;
		}
	}
	
	class PaymentBody {
		private String payment_url;

		private String trans_ref;

		public String getPayment_url() {
			return payment_url;
		}

		public void setPayment_url(String payment_url) {
			this.payment_url = payment_url;
		}

		public String getTrans_ref() {
			return trans_ref;
		}

		public void setTrans_ref(String trans_ref) {
			this.trans_ref = trans_ref;
		}

	}
	
	
}

