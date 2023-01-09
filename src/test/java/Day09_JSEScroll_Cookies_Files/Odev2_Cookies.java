package Day09_JSEScroll_Cookies_Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.time.Duration;
import java.util.Set;

public class Odev2_Cookies {
    /*
    Go to URL: http://facebook.com
getCookies,
addCookie,
deleteCookieNamed,
deleteAllCookies.
URL'ye gidin: http://facebook.com
almakÇerezler,
ekleÇerez,
silmeÇerezAdı,
silAllCookies.

     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
       // driver.quit();
    }
    @Test
    public void testCookies(){
        driver.get("https://www.facebook.com");

        // cookie slerin sayısına bakildi
        Set<Cookie>allcookies=driver.manage().getCookies();
        int numOfcookies=allcookies.size();
        System.out.println("numOfcookies = " + numOfcookies);//4


        // ADD Cookie :
        Cookie cookie=new Cookie("cars","opel");
        driver.manage().addCookie(cookie);
        Cookie cookie1=new Cookie("car","citroen");
        driver.manage().addCookie(cookie1);
        Assert.assertEquals(cookie.getValue(),driver.manage().getCookieNamed(cookie.getName()).getValue());

        allcookies=driver.manage().getCookies();
        System.out.println(allcookies.size());//6

        // DELETE Cookie :
        driver.manage().deleteCookie(cookie);
        Assert.assertNull("cookie var mi",driver.manage().getCookieNamed(cookie.getName()));

         // Delete cookies
        allcookies=driver.manage().getCookies();
        System.out.println(allcookies.size());//5
        driver.manage().deleteAllCookies();
        allcookies=driver.manage().getCookies();
        System.out.println("allcookies.size() = " + allcookies.size());//0

    }
}
