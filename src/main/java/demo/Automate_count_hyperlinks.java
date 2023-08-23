package demo;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Automate_count_hyperlinks {
    ChromeDriver  driver;
    public Automate_count_hyperlinks(){
        //System.out.println("Constructor: TestCases");
       // WebDriverManager.chromedriver().timeout(30).setup();
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest(){
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void count_hyperlinks() throws InterruptedException{
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> list = driver.findElements(By.tagName("a"));
        Thread.sleep(2000);
        System.out.println(list.size());
    }
}
