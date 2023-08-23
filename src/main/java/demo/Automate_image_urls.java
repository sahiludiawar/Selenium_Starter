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

public class Automate_image_urls {

    ChromeDriver driver;

    public Automate_image_urls(){

        System.out.println("Constructor: Start TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest(){
        System.out.println("End TestCase");
        driver.close();
        driver.quit();
    }

    public void image_urls() throws InterruptedException{
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(2000);

        WebElement movie1 = driver.findElement(By.xpath("//img[@alt='Jailer']"));
        movie1.getAttribute("src");
        String recom_movie1 = movie1.getAttribute("src");
        System.out.println("Movie 1 Image URL:"+ recom_movie1);

        WebElement movie2 =  driver.findElement(By.xpath("//img[@alt='King of Kotha']"));
        String recom_movie2 = movie2.getAttribute("src");
        System.out.println("Movie 2 Image URL:"+ recom_movie2);

        WebElement movie3 =  driver.findElement(By.xpath("//img[@alt='Adiyae']"));
        String recom_movie3 = movie3.getAttribute("src");
        System.out.println("Movie 3 Image URL:"+ recom_movie3);

        WebElement movie4 =  driver.findElement(By.xpath("//img[@alt='DD Returns']"));
        String recom_movie4 = movie4.getAttribute("src");
        System.out.println("Movie 4 Image URL:"+ recom_movie4);

        WebElement movie5 =  driver.findElement(By.xpath("//img[@alt='Gadar 2: The Katha Continues']"));
        String recom_movie5 = movie5.getAttribute("src");
        System.out.println("Movie 5  Image URL:"+ recom_movie5);

        WebElement premeire2_name = driver.findElement(By.xpath("//div[contains(text(),'Follow Me')]"));
        String premeireMovieName = premeire2_name.getText();
        System.out.println("2nd Premeir movie name is:" + premeireMovieName);

        WebElement premeire2_lang = driver.findElement(By.xpath("//*[@id=\"https://in.bookmyshow.com/chennai/movies/follow-me/ET00365828-1\"]/div/div[3]/div[2]/div"));
        String premeireMovieLang = premeire2_lang.getText();
        System.out.println("2nd Premeir movie lang is:" + premeireMovieLang);



           // List<WebElement> list = driver.findElements(By.xpath("//*[@id='super-container']/div[2]/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div[1]"));
           // for (WebElement imageElement:list){
              //  String imageURL = imageElement.getAttribute("src");
               // System.out.println("Recommended Movies URL:" + imageURL);
           // }
    }
}
