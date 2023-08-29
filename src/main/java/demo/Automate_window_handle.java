package demo;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_window_handle {
    ChromeDriver driver;

    public Automate_window_handle(){
        System.out.println("Constructor: Start Testcase");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest(){
        System.out.println("End Testcase");
        driver.close();
        driver.quit();
    }

    public void window_handle() throws InterruptedException{
         //get url
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        Thread.sleep(2000);

        //Switch to iframe
        driver.switchTo().frame("iframeResult");

        //click on Try it  button
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();

        //All Open Windows
        Set<String> Windowhandles = driver.getWindowHandles();

        //Switch to new window
        for(String handle:Windowhandles){
            if(!handle.equals(driver.getWindowHandle())){
                driver.switchTo().window(handle);
                break;
            }
        }

        //get URL
        String URL  = driver.getCurrentUrl();
        System.out.println("URL is:" + URL);

        //get Title
        String title = driver.getTitle();
        System.out.println("Title is: "+ title);

        //Take Screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("screenshot.png"));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        driver.close();
        driver.switchTo().window(Windowhandles.iterator().next());
    }
}
