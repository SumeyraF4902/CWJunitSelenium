package Day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTestReport;

public class C02_ExtentReport extends BaseTestReport {


    @Test
    public void test(){

        //testi yapacak olan her turlu mesaji gecip kaldigini belirtecek extentTest objemizi olusturuyoruz
        // Testi yapacak olan her turlu mesaji gecip kaldigini belirtecek extentTest objemizi olusturuyoruz
        loger = extentReports.createTest("My Test", "Bu bir aciklamadir");
        //info mesaji yazdiriliyor
        loger.info("Amazon a gidiliyor");
        driver.get("https://www.amazon.com.tr/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        loger.info("Arama kismina log4j yaziliyor");
        searchBox.sendKeys("log4j");


        //Pass mesaji
        loger.pass("Testimiz gecerli");

        //Fail mesaji
        loger.fail("Testimiz gecersiz");

        //Skip mesaji
        loger.skip("Testimiz skip edildi");
    }
}
