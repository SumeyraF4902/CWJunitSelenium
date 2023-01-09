package Day09_JSEScroll_Cookies_Files;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C01_ScrollActions extends BaseTest {


    @Test
    public void scrollPageUpDown() throws InterruptedException {
        driver.get("https://amazon.com/");
        Actions act=new Actions(driver);
        //DAHA HIZLI HAREKET EDER
        act.sendKeys(Keys.PAGE_DOWN).perform();// KLAVYEDEKİ UP VE DOWM TUSLARINI KULLANIYORsayfada asaginmek
        Thread.sleep(2000);
        act.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.PAGE_UP).perform();// sayfada yukari cikmak
        Thread.sleep(2000);
        act.sendKeys(Keys.PAGE_UP).perform();
    }
    @Test
    public void scrollArrowUpDown() throws InterruptedException {//ArrowUpDown klavyedeki ok tuslari
        driver.get("https://amazon.com/");
        Actions act=new Actions(driver);
        //DAHA YAVAS HARAKET EDER
        act.sendKeys(Keys.ARROW_DOWN).perform();// IKI TIK ASAGI GITTIK
        Thread.sleep(2000);
        act.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.ARROW_UP).perform();//2 TIK YUKARI CIKTIK
        Thread.sleep(2000);
        act.sendKeys(Keys.ARROW_UP).perform();
    }
}