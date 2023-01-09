package Day10_GarryHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class Task_10 extends BaseTest {
    /*
  1- https://www.amazon.com/ sayfasına gidelim.
  2- Arama kutusunu locate edelim.
  3- "Samsung headphones" ile arama yapalım.
  4- Bulunan sonuç sayısını yazdıralım.
  5- İlk ürünü tıklayalım.
  6- Sayfadaki tüm ürün başlıklarını yazdıralım.
*/
    @Test
    public void Test() {
        //https://www.amazon.com/ sayfasına gidelim.

        driver.get("https://www.amazon.com/");
        //2- Arama kutusunu locate edelim.
        WebElement searcbox=driver.findElement(By.id("twotabsearchtextbox"));

        //  3- "Samsung headphones" ile arama yapalım.
        searcbox.sendKeys("Samsung headphones"+Keys.ENTER);
        //4- Bulunan sonuç sayısını yazdıralım.
        WebElement result=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("result:"+result.getText());

        //5- İlk ürünü tıklayalım.
        WebElement firstProduct= driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        firstProduct.click();

        //6- Sayfadaki tüm ürün başlıklarini yazdirin
        // bunun icin once geri gelmemiz gerekiyor
        driver.navigate().back();// geri geldik
        List<WebElement> allProducts= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement each:allProducts){
            System.out.println(each.getText());
        }

    }
}
