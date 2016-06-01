//package com.ccs.spider.selenium;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//public class ChromeSpider{
//
//	private ChromeDriverService service;
//	private WebDriver driver;
//
//	public ChromeSpider(){
//		service = new ChromeDriverService.Builder().usingDriverExecutable(new File("D:/chromedriver.exe"))
//				.usingAnyFreePort().build();
//		try {
//			service.start();
//			driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void createAndStopService() {
//		driver.quit();
//		service.stop();
//	}
//
//	private String initJs(Integer i,Integer count){
//		String js = "window.scrollTo(0,document.body.scrollHeight/"+count+"*"+i+");";
//		return js;
//	}
//	
//	// {@literal }
//	public List<BatteryInfo> googleSearch(String url) {
//		//String url = "http://p4psearch.1688.com/p4p114/p4psearch/offer2.htm?keywords=%E7%94%B5%E6%B1%A0&cosite=baidujj&location=&trackid=4014000002631796&p4pid=1464007107509033253184&se=&spm=a312h.7841636.1998813771.dsearch_1998813775_0";
//		List<BatteryInfo> listBattery = new ArrayList<>();
//		driver.get(url);
//		try {
//			int count = 7;
//			for(int i = 0 ;i<count;i++){
//				Thread.sleep(1000);
//				((JavascriptExecutor)driver).executeScript(initJs(i+1,count));
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		List<WebElement> list = driver.findElement(By.id("sm-maindata")).findElement(By.tagName("div"))
//				.findElement(By.tagName("ul")).findElements(By.tagName("li"));
//		List<Map<String,String>> baseList = new ArrayList<>();
//		//for(int k = 0;k<list.size();k++){
//		for(int k = 0;k<11;k++){
//			Map<String,String> map = new HashMap<>();
//			System.out.println("dealing with "+(k+1)+" 个");
//			WebElement element = list.get(k);
//			//System.out.println(element.getText());
//			WebElement lielement = element.findElement(By.tagName("div")).findElement(By.tagName("div")).findElement(By.tagName("a"));
//			String hrefUrl = lielement.getAttribute("href");
//			System.out.println("链接的url:"+hrefUrl);
//			String imageUrl = lielement.findElement(By.tagName("img")).getAttribute("src");
//			System.out.println("图片url："+imageUrl);
//			map.put("hrefUrl", hrefUrl);
//			map.put("imageUrl", imageUrl);
//			baseList.add(map);
//		}
//		for(Map<String,String> m:baseList){
//			driver.get(m.get("hrefUrl"));
//			WebElement myEle = driver.findElement(By.id("mod-detail-title"));
//			String energyName=myEle.findElement(By.tagName("h1")).getText();
//			System.out.println("电池名字："+energyName);
//			List<WebElement> trsElements = driver.findElement(By.id("mod-detail-attributes")).findElement(By.tagName("tbody"))
//					.findElements(By.tagName("tr"));
//			BatteryInfo battery = new BatteryInfo() ;
//			battery.setName(energyName);
//			battery.setFromUrl(m.get("hrefUrl"));
//			for(int i = 0;i<trsElements.size();i++){
//				List<WebElement> tdsElements = trsElements.get(i).findElements(By.tagName("td"));
//				
//				for(int j = 0 ; j+1<tdsElements.size();j++,j++){
//					String tagName = tdsElements.get(j).getText();
//					String value = tdsElements.get(j+1).getText();
//					initBatteryInfo(battery,tagName,value);
//				}
//			}
//			listBattery.add(battery);
//		}
//		return listBattery;
//	}
//	
//	//电池信息赋值
//	private void initBatteryInfo(BatteryInfo battery,String tagName,String value){
//		if(tagName == null||"".equals(tagName.trim()))
//			return;
//		ExtInfo info = new ExtInfo();
//		info.setName(tagName);
//		info.setValue(value);
//		battery.getExtList().add(info);
//		//System.out.println(tagName+":"+value);
//		switch(tagName){
//		case "品牌":
//			battery.setBrand(value);
//			break;
////		case "型号":
////			battery.setModel(value);
////			break;
////		case "加工定制":
////			battery.setIsMachining(value);
////			break;
////		case "类型":
////			battery.setType(value);
////			break;
////		case "标称电压":case "标准电压":
////			battery.setStandardVoltage(value);
////			break;
////		case "放电条件":
////			battery.setDischarge(value);break;
////		case "终止电压":
////			battery.setTermiVoltage(value);break;
////		case "产品认证":
////			battery.setProCert(value);break;
////		case "材质":
////			battery.setMaterial(value);break;
////		case "适用范围":
////			battery.setUseRegion(value);break;
////		case "包装":
////			battery.setPack(value);break;
////		case "质量认证":
////			battery.setQualityCert(value);break;
////		case "环境认证":
////			battery.setEnvironmentalCert(value);break;
////		case "保质期限":battery.setShelfLife(value);break;
////		case "净重":battery.setWeight(value);break;
//		}
//	}
//}
