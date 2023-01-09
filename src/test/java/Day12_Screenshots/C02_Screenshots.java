package Day12_Screenshots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;




public class C02_Screenshots extends BaseTest {

    @Test
    public void getPageScreenshot() throws IOException {
        driver.get("https://www.n11.com/");
        ////Screenshot umuzu File class indan bir objeye aliyoruz
        File kaynak= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //// Aldigimiz screenshot istedigimiz path e kaydediyoruz
        FileHandler.copy(kaynak,new File("test-output/Screenshots/n11PageScreenshot.png"));
        // kaynak= kopyalanacak resim, new file da kopyalaancagi yer
    }
    @Test
    public void getElementScreenshot() throws IOException {
        //Screenshot u alinacak elementimizi locate ettik
        //Saving the image to the path        //Görüntüyü yola kaydetme
        //getting screenshot of orange hrm Logo   //turuncu hrm Logosunun ekran görüntüsü alınıyor
        //getting screenshot of orange hrm page Section    //turuncu hrm sayfası bölümünün ekran görüntüsü alınıyor



       driver.get("https://opensource-demo.orangehrmlive.com/");

       // //Screenshot u alinacak elementimizi  logoyu locate ettik
       WebElement logo=driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']"));

        // Element uzerinden screenshot umuzu aldik
    File logoScreenshot= logo.getScreenshotAs(OutputType.FILE);//screenshot cagirdik

       // System.out.println(new Date());//   hangi saatte hata alip almadigini belgelemek icin saat alinir Wed Dec 28 15:03:59 EET 2022
        String date=new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date());//2. yol date formatlayarak  icin obje olusturduk

        //ekran goruntumuzu ve tarihi belgelemek icin obje olusturduk
        String path="test-output\\Screenshots\\logoScreenshot"+date+".png";
        System.out.println(path);

        //kaydetmek icin
        FileUtils.copyFile(logoScreenshot,new File(path));

        //getting screenshot of orange hrm page Section    //turuncu hrm sayfası bölümünün ekran görüntüsü alınıyor
        WebElement logo2= driver.findElement(By.xpath("//div[@class='orangehrm-login-slot-wrapper']"));

        File logoOrangeHRM=logo2.getScreenshotAs(OutputType.FILE);
        String date2=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String path2="test-output\\Screenshoot\\logoOrangeHR"+date2+".png";
        FileUtils.copyFile(logoOrangeHRM,new File(path2));
        System.out.println("path2="+path2);

      //  FileUtils.copyFile(logoOrangeHRM,new File("test-output\\Screenshots\\logoOrangeHRM.png")); DATE almadan bu sekildede bulunur


    }
}
