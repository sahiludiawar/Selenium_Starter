package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_imdb_ratings {
    
    ChromeDriver driver;

    public Automate_imdb_ratings(){
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
        System.out.println("End Test: Testcase");
        driver.close();
        driver.quit();
    }

    public void imdb_ratings() throws InterruptedException{
        //Open URL
        driver.get("https://www.imdb.com/chart/top/");

        //Refresh Page
        driver.navigate().refresh();

        //No.1 IMDB rated movie
        try {
            
            WebElement no1IMDBRatedMovie_locator = driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]"));
            String no1IMDBmovie = no1IMDBRatedMovie_locator.getText();

            System.out.println("No.1 IMDB Rated Movie is: " + no1IMDBmovie);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Failed to locate no1 IMDB Rated Movie" +e);
        }

        //Total count of movies
        try {
            WebElement totalMovies_locator = driver.findElement(By.xpath("//span[@class='sc-f98e5d7f-0 gtxTpS']"));
            String totalMovies = totalMovies_locator.getText();
            //List <WebElement> totalMovies_Locator = driver.findElements(By.xpath("//ul[@class='ipc-metadata-list ipc-metadata-list--dividers-between sc-3f13560f-0 sTTRj compact-list-view ipc-metadata-list--base']"));
            //int total =totalMovies_Locator.size();
            System.out.println("Total Movies in list: " + totalMovies);

            
        } catch (Exception e) {
            // TODO: handle exception
             System.out.println("Failed to locate Total Movies" +e);
        }

        //Oldest movie on list

        //driver.findElement(By.xpath("//span[contains(@class, 'bKdMGY')]")).click();
        //System.out.println("Clicked on Ranking dropdown");

        WebElement dropdownList = driver.findElement(By.xpath("//select[@id='sort-by-selector']"));

        Select dropdown = new Select(dropdownList);
        Thread.sleep(2000);
        dropdown.selectByVisibleText("Release date");

        driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
        Thread.sleep(2000);

        WebElement oldestMovie_locator = driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]"));
        String oldestMovie = oldestMovie_locator.getText();
        System.out.println("The oldest movie is: " + oldestMovie);

        //Most Recent movie on the list

        WebElement dropdown_list = driver.findElement(By.xpath("//select[@id='sort-by-selector']"));

        Select dropdown1 = new Select(dropdown_list);

        dropdown1.selectByVisibleText("Release date");

        driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();

        WebElement recentMovie_locator = driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]"));
        String recentMovie =  recentMovie_locator.getText();
        System.out.println("Most recent movie on the list: " +recentMovie);

        //Highest rated IMDB movie

        WebElement dropdownlist = driver.findElement(By.xpath("//select[@id='sort-by-selector']"));

        Select dropdown2 = new Select(dropdownlist);

        dropdown2.selectByVisibleText("IMDb rating");

        WebElement highestRatedMovie_locator  = driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]"));
        String highestRatedMovie = highestRatedMovie_locator.getText();

        System.out.println("Highest Rated IMDB Movie is: " + highestRatedMovie);

    }
}
