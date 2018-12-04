package com.ccs.spider;
//
//import java.io.IOException;
//import java.util.ListIterator;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.junit.Test;
//
//public class Spider {
//
//	public void getType(String url){
//		try {
//			Document doc = Jsoup.connect(url).get();
//			System.out.println(doc);
//			Elements sel = doc.select("#sm-maindata");
//			sel = doc.select("#sm-maindata div ul li");
//			//����ÿһ����ص�������Ϣ
//			ListIterator<Element> listIterator = sel.listIterator();
//			while(listIterator.hasNext()){
//				Element element = listIterator.next();
//				Elements batteryList = element.select("div div");
//				ListIterator<Element> batteryInfoList = batteryList.listIterator();
//				while(batteryInfoList.hasNext()){
//					Element div1 = batteryInfoList.next();
//					String nextPageUrl = div1.select("a").get(0).attr("href");
//					String imageUrl = div1.select("a").select("img").get(0).attr("src");
//					System.out.println("ҳ����Ϣ:"+nextPageUrl +":"+imageUrl);
//				}
//				//System.out.println(element.html());
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void myTest(){
//		//������ҳ��Ϣ
//		String url = "http://p4psearch.1688.com/p4p114/p4psearch/offer.htm?keywords=%E7%94%B5%E6%B1%A0&cosite=baidujj&location=&trackid=4014000002631796&p4pid=1463540912761033253169&spm=...dsearch__0";
//		getType(url);
//		
//		String energyInfo = "<a class=\"category-name  current \" href=\"/p4p114/p4psearch/offer2.htm?keywords=%E6%B1%82%E8%B4%AD%E7%94%B5%E6%B1%A0&amp;cosite=baidujj&amp;trackid=4014000002631796&amp;pid=&amp;location=&amp;p4pid=1463551808815033253967&amp;se=&amp;step=2\" target=\"_self\" data-spm=\"drel_1998813771_1\" keywords=\"�󹺵��\">�󹺵��</a>";
//		//��һ�������ҳ��Ϣ
//		String tempUrl="http://dj.1688.com/ci_bb?spm=a312h.7841636.1998813769.d_pic_1.Milnbc&a=937948601&e=4oqtN216x2AOqIWD3kSLB85k6t0xdd.nGhO-3zWKuvSr8vCnAXfvJyFHJAcyeE2yvbo6FBttBPBqWs9XGwgKdGpTVgL.gS8WRwEY-g7UQUILf72FBX.-5If6OVMHXUijzkrFrL0xW4lcshWQljLSYFOeRvRLD9OybjaNcMiVLViRNAERnC6brWrnqlIbYRCsY1dtmQEYpzSeCwArEIMDZxpBvWC52O3bhXCrBgi6lbgf9vAAFoN9S5pce5xMOJNYBQC0m14S-ySWGv1DVya0cQTWUfcEMDwWcxZCrxUbJS2sb5vVD2WkXQSXDXwiUkeiAseRJxanVKn0TqQqU6cmyVMrHhk4fYevFDXUPQIOqa1N9f02-YEpUjkj1RSV9YCPFZybhYHVG1QKhFh-sbYAKLVfTObiMZcctiVYglpCQwSGdI8AMePWAG06QnPfO3PmzcQtUglZms1ckB16eURrePmD9ICf9lmcty3heM3TfK1mSqve0aWgth9WUkrWHfOyyJmyj9VyrFdefL58gqxm3Q1b3XGlUhI-p4XadLqlj3PsQ.UACh6VssfMw4gwVmPv0STYIFIMlcj3hy7XL5ocbOFj0ch7OmjXxt-7QpNjSQ27x1dqueXipxQOf5mZALDb&v=4&ap=1&rp=1";
//		
//		url="https://detail.1688.com/offer/40571479446.html?spm=a312h.7841636.1998813769.d_pic_1.YWAZfX&tracelog=p4p";
//		
//	}
//	
//}
