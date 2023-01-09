package Day8_WindowHandles_Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C03_Actions {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @After
    public void teardown(){
       // driver.quit();
    }
    @Test
    public void dragAndDrop(){

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        //drag elements
        WebElement washington=driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));

        //drop elements
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement southKorea = driver.findElement(By.id("box105"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement us = driver.findElement(By.id("box103"));

        Actions actions = new Actions(driver);

        // tekli kullanim
        actions.dragAndDrop(madrid,spain).perform();// Madrid i spain in icine tasidik
        actions.dragAndDrop(rome,italy).perform();
        actions.dragAndDrop(washington,us).perform();
        actions.dragAndDrop(oslo,norway).perform();
        actions.                                           // 2 yollada yapilabilir            method zinciri seklinde kullanim
                dragAndDrop(copenhagen,denmark).
                dragAndDrop(seoul,southKorea).
                dragAndDrop(stockholm,sweden).perform();// eger calısmazsa build ile dene




    }
}
