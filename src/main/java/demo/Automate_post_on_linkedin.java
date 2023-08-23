package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_post_on_linkedin {
    ChromeDriver driver;

    public Automate_post_on_linkedin() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void linkedinPost() throws InterruptedException{
        driver.get("https://www.linkedin.com");
        Thread.sleep(5000);
        driver.navigate().refresh();
        //username
        driver.findElement(By.xpath("//input[@id='session_key']")).click();
        driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("testse254@gmail.com");

        //password
        driver.findElement(By.xpath("//input[@id='session_password']")).click();
        driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("Test@123");

        //Sign-In
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Profile Views
        Thread.sleep(2000);
        WebElement count = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[2]/div/div/div/div[1]/div[2]/div/ul/li[1]/a/div/div[2]"));
        count.getText();
        String profileCount = count.getText();
        System.out.println(profileCount);

        //Post Impressions
        WebElement postImpressions = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[2]/div/div/div/div[1]/div[2]/div/ul/li[2]/a"));
        postImpressions.getText();
        String postImp = postImpressions.getText();
        System.out.println(postImp);

        //Click on start a post

        try {

            driver.findElement(By.xpath("//button[@id='ember26']")).click();
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Start a post not clicked:" + e);
        }

        Thread.sleep(2000);

        // Click on post to anyone drop down

        try {
            driver.findElement(By.xpath("//span[@class='text-body-large-bold truncate']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@aria-checked='false']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Done']")).click();
        
        Thread.sleep(2000);


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("issue in clicking dropdown" +e);
        }

        driver.findElement(By.xpath("//div[@role='textbox']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("Test Post");

        Thread.sleep(2000);

        try {
            WebElement uploadImage = driver.findElement(By.xpath("//span//button[@aria-label='Add a photo']"));
        uploadImage.click();
        System.out.println("Upload image clicked");
        Thread.sleep(2000);
        String imagePath = "\\C:\\Users\\Sahil\\test.png";
        uploadImage.sendKeys(imagePath);
        uploadImage.click();
        //uploadImage.sendKeys("\\Users\\Sahil\\Desktop\\test.png");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Image upload failed:" + e);
        }
        
    }
}
