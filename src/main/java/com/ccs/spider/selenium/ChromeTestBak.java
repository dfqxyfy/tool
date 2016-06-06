package com.ccs.spider.selenium;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.TestCase;

//@literal
@RunWith(JUnit4.class)
public class ChromeTestBak extends TestCase {

	private static ChromeDriverService service;
	private WebDriver driver;

	// @literal
	@BeforeClass

	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder().usingDriverExecutable(new File("D:/chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();
	}

	// @literal
	@AfterClass

	public static void createAndStopService() {
		service.stop();
	}

	// {@literal }
	@Before
	public void createDriver() {
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
	}

	// {@literal}
	@After
	public void quitDriver() {
		driver.quit();
	}

	// {@literal }
	@Test
	public void testGoogleSearch() {
		String url = "http://p4psearch.1688.com/p4p114/p4psearch/offer.htm?keywords=%E7%94%B5%E6%B1%A0&cosite=baidujj&location=&trackid=4014000002631796&p4pid=1463540912761033253169&spm=...dsearch__0";

		driver.get(url);
		WebElement element = driver.findElement(By.id("sm-maindata"));
		System.out.println(element);
//		String linkedUrl = findElement.findElement(By.className("imgofferresult-mainBlock"))
//				.findElement(By.tagName("a")).getAttribute("href");
		//System.out.println(linkedUrl);
		//element.findElement(By("imgofferresult-mainBlock"));
		WebElement ele = element.findElement(By.tagName("a"));
		System.out.println(ele.getAttribute("href"));
		String imageUrl = ele.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(imageUrl);
		
		
		// WebElement searchBox = driver.findElement(By.name("q"));
		// searchBox.sendKeys("webdriver");
		// searchBox.quit();
		// assertEquals("webdriver - Google Search", driver.getTitle());
	}
}