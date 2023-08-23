package demo;

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

public class Automate_search_amazon {
    ChromeDriver driver;

    public Automate_search_amazon(){
        //System.setProperty("webdriver.chrome.driver","C:\chromedriver-win64\chromedriver-win64\chromedriver.exe");
        //System.out.println("Constructor: TestCases");
        //WebDriverManager.chromedriver().timeout(30).setup();
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
        System.out.println("EndTest: TestCases");
        driver.close();
        driver.quit();
    }

    public void search_Amazon() throws InterruptedException{
        driver.get("https://www.google.com");

        Thread.sleep(3000);
        
        WebElement searchBar = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBar.click();

        Thread.sleep(3000);

        searchBar.sendKeys("amazon");

        searchBar.sendKeys(Keys.RETURN);

        //String expectedURL = "https://www.amazon.in";

        WebElement actualURL = driver.findElement(By.xpath("//span[text()='https://www.amazon.in']"));
        actualURL.isDisplayed();
        
        System.out.println(actualURL);


    }


}
