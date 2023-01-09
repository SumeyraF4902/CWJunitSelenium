package Day7_Iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C03_WindowHandls extends BaseTest {
    //    Go to URL: https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
//    Print the existing windowHandles ids by clicking all the links on the page.
//    Click on the links that open a new page.
//    Close other pages other than the home page. ana sayfa haric digerleri kapatilacak
//    Set the driver back to the main page.
    /*
    Sayfadaki tüm bağlantılara tıklayarak mevcut windowHandles kimliklerini yazdırın.
// Yeni bir sayfa açan bağlantılara tıklayın.
// Ana sayfa dışındaki diğer sayfaları kapatın. ana sayfa haric digerleri kapatilacak
// Sürücüyü ana sayfaya geri ayarlayın.
     */
    @Test
    public void windowHandles(){
        driver.get("https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/");
        //windowsun id sini almak icin kullandıgımız method. daha sonra kullanmak adina
        String homepageId=driver.getWindowHandle();// ana sayfamizi daha sonra hangisi diye kaybetmemek icin

        //uzerinde gezinecegimiz sayfalar olusturdun. yeni sekmeler target=_blank olan linklerden 2 tanesini tikliyoruz
        List<WebElement>links = driver.findElements(By.xpath("//a[@target='_blank']"));
            // sayfalari actik
        links.get(0).click();
        links.get(1).click();

        //ıterate etmek icin(gezinmek icin)tum tab ve id lerini bir set icinde sakliyoruz
       Set<String> windows= driver.getWindowHandles();//  sayfalarin uzerinde gezmek icin id lerini set icine almıs olduk
            //handles set dondurdugu icin set olusturduk

        //gezinme islemi icin iterator objesini olusturuyoruz
        Iterator<String>iterator=windows.iterator();

        //gezinme islemi
        while (iterator.hasNext()) {
            //her bir gezinilen id kullanilarak o anki sekmeye switch ediyoruz
            driver.switchTo().window(iterator.next());
            ////Switch ettigimiz sayfanin ana sayfa olup olamdigini kontrol ediyoruz. Ana sayfa ise sekmeyi kapatmiyoruz degilse kapatiyoruz
            if(driver.getWindowHandles().equals(homepageId)){//  acılan window ana sayfa ise ana sayfayi atla

                continue;// driver.close es geciyoruz
            }
            driver.close();// sekmeyi kapatiyoruz
        }

    }
}
