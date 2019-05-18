package cn.ccs.spider.selenium.basic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicChromeSpider {

    private ChromeDriverService service;
    private WebDriver driver;

    public BasicChromeSpider() {
        service = new ChromeDriverService.Builder().usingDriverExecutable(new File("D:/program/chromedriver.exe"))
                .usingAnyFreePort().build();
        try {
            service.start();
            driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createAndStopService() {
        driver.quit();
        service.stop();
    }

    public static void main(String[] args) {
        BasicChromeSpider chrome = new BasicChromeSpider();
        chrome.driver.get("https://coinmarketcap.com/");

            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        chrome.driver.close();
    }

    private String initJs(Integer i, Integer count) {
        String js = "window.scrollTo(0,document.body.scrollHeight/" + count + "*" + i + ");";
        return js;
    }

    // {@literal }
    public List googleSearch(String url) {
        //String url = "http://p4psearch.1688.com/p4p114/p4psearch/offer2.htm?keywords=%E7%94%B5%E6%B1%A0&cosite=baidujj&location=&trackid=4014000002631796&p4pid=1464007107509033253184&se=&spm=a312h.7841636.1998813771.dsearch_1998813775_0";
        driver.get(url);
//        List<WebElement> list = driver.findElement(By.id("sm-maindata")).findElement(By.tagName("div"))
//                .findElement(By.tagName("ul")).findElements(By.tagName("li"));


//        return list;
        return null;
    }

}
