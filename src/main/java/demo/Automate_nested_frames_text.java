package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_nested_frames_text {

    ChromeDriver driver;

    public Automate_nested_frames_text()
    {
        //System.setProperty("webdriver.chrome.driver","C:\chromedriver-win64\chromedriver-win64\chromedriver.exe");
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public void frames_text(){

        System.out.println("Start Test case: frames_text");

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");

        //get left frame text

        WebElement leftFrame =  driver.findElement(By.tagName("body"));
        String Left = leftFrame.getText();
        System.out.println("Left Frame text is" + Left);

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");

        WebElement middleFrame = driver.findElement(By.tagName("body"));
        String Middle = middleFrame.getText();
        System.out.println("Middle Frame text is" + Middle);

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");

        WebElement rightFrame = driver.findElement(By.tagName("body"));
        String Right = rightFrame.getText();
        System.out.println("Right Frame text is" +Right);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        try {
            WebElement bottomFrame = driver.findElement(By.tagName("body"));
        String Bottom = bottomFrame.getText();
        System.out.println("Bottom Frame Text is " + Bottom);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception trying to locate Bottom Frame" + e);
        }
        

    }


}
