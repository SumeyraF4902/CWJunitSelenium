package Day4_LocatorPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Practice {

//Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the ORIGINAL CONTENTS
// Click on Alerts
// Print the URL
// Navigate back
// Print the URL
// Click on Basic Ajax
// Print the URL
// Enter value  20 and Enter
// And then verify Submitted Values is displayed open page
// Close driver.
WebDriver driver;//butun methodlar ulassın diye


@Before
    public void setup(){
    //driver ile ilgili her türlü initial (baslangıic)islemi burada yapilir
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

}
@After
    public void tearDown(){
    //test sonrasinda driver kapatmak (varsa raporları dosyalamak) icin kullanilir
  driver.quit();
}
@Test
    public void test(){
    driver.get("https://testpages.herokuapp.com/styled/index.html");

    //Alert linki locate edildi ve tiklandi
    WebElement alertLink=driver.findElement(By.xpath("//a[@id='alert']"));
    alertLink.click();// tikla

    //Current URL yazdirildi
    String alertUrl=driver.getCurrentUrl();
    System.out.println("alertUrl = " + alertUrl);

    // back =geri bir sayfa geri gelindi
    driver.navigate().back();


    //Current URL yazdirildi
    String homeUrl=driver.getCurrentUrl();
    System.out.println("homeUrl = " + homeUrl);

    //// Click on Basic Ajax linli locate edildi. ve tiklandi
    WebElement basicAjaxLink= driver.findElement(By.id("basicajax"));
    basicAjaxLink.click();// tiklandi

    //basic Ajax URL print edildi

    String basicAjaxUrl= driver.getCurrentUrl();
    System.out.println(basicAjaxUrl);

    // Text ALANİNA 20 YAZİLİP ENTER basildi
    driver.findElement(By.id("lteq30")).sendKeys("20"+ Keys.ENTER);


//Subbitted Values yazisinin goruntulendigini dogrula
    WebElement SubbittedValuesText = driver.findElement(By.xpath("//p[text()='Submitted Values']"));
    Assert.assertTrue((SubbittedValuesText.isDisplayed()));
}

}
