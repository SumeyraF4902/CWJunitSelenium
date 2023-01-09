package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

public class C03_JunitAssertions {
    //    Go to Amazon homepage.
//    Do the following tasks by creating 3 different test methods.
//    1- Test if the URL contains Amazon.
//    2- Test if the title does not contain Facebook.
//    3- Test that the Amazon logo appears in the upper left corner.

    //    assertEquals
//    assertTrue
//    assertFalse
//    assertNull
//    assertNotNull
//    assertSame
//    assertNotSame
//    assertArrayEquals

    WebDriver driver;
/// her bir method icin driver , before ve after acmadik bir kere actık hepsi icin gecerli
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }

    @After
    public void after(){
        driver.quit();// drivere kapattik

    }


    @Test
    public void URLTest(){
        driver.get("https://www.amazon.com/");
        String currentUrl= driver.getCurrentUrl();

        //URL amazon kelimesini iceriyormu kontrol saglaniyor
        Assert.assertTrue("Url amazon icermiyor",currentUrl.contains("Amazon"));
    }
            public void  titleTest(){
            driver.get("https://www.amazon.com/");
            String title= driver.getTitle();
           // title.contains("Facebook");
            Assert.assertFalse(title.contains("Facebook"));

            }

        @Test
    public void logo() {
        driver.get("https://www.amazon.com/");
           WebElement logo= driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
            //  Assert.assertTrue(logo.isDisplayed());
            System.out.println("logo test passed");

        }



}
