package Day10_GarryHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class Task_05 extends BaseTest {
    /*
    1- https://html.com/tags/iframe/ sayfasına gidelim.
    2- Video'yu görecek kadar aşağı inin.
    3- Videoyu izlemek için Play tuşuna basın.
    4- Videoyu çalıştırdığınızı test edin.
*/
    @Test
    public void test(){

        driver.get("https://html.com/tags/iframe/");

        //Video'yu görecek kadar aşağı inin.
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //Videoyu izlemek için Play tuşuna basın.
        WebElement iFrame=driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]"));
        driver.switchTo().frame(iFrame);

        WebElement play= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        //play.click();//Vieo baslasın     2 yol asagi
        actions.click(play).perform();

       // Videoyu çalıştırdığınızı test edin.
        Assert.assertFalse(play.isDisplayed());
}}
