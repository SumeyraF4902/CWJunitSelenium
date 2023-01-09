package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C04_Actions extends BaseTest {  // YATAYDA SAGA SOLA KAYDIRMA ISLEMI
    @Override
    public void tearDown() {

    }

    @Test
    public void dragAndDropOffsetHorizontal() {


        driver.get("https://rangeslider.js.org/");

        //Slider locate ediliyor
        WebElement slider = driver.findElement(By.xpath("(//div[@class='rangeslider__handle'])[1]"));
        Actions actions=new Actions(driver);

        // saga tasima islemleri icin xOffset + olmali, sola tasima islemleri icin xOffset - olmali
        // Ayni zamanda dikey eksende hareket olmasini engellemek adina yOffset 0 olarak belirlenmelidir

        actions.dragAndDropBy(slider,-100, 0).build().perform();


    }
}