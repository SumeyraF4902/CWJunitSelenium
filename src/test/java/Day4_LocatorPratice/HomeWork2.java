package Day4_LocatorPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork2 {
    //Navigate to https://testpages.herokuapp.com/styled/index.html
// Click on Calculate under Micro Apps.   Mikro Uygulamalar altında Hesapla'ya tıklayın.
// Type any number in the first input.    İlk girişe herhangi bir sayı yazın.
// Type any number in the second input.     İkinci girişe herhangi bir sayı yazın.
// Click on Calculate.   Hesapla'ya tıklayın.
// Get the result.  sonucu alin
// Print the result.   sonucu yazdirin

WebDriver driver;

@Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
@After
    public void tearDown(){
    //driver.quit();
}
@Test
    public void test(){
    //Navigate to https://testpages.herokuapp.com/styled/index.html
    driver.get("https://testpages.herokuapp.com/styled/index.html");

    // Mikro Uygulamalar altında Hesapla'ya tıklayın.
    driver.findElement(By.xpath("//a[@id='calculatetest']")).click();

    //  İlk girişe herhangi bir sayı yazın.
    driver.findElement(By.cssSelector("input[id='number1']")).sendKeys("20");

    //ikinci girişe herhangi bir sayı yazın.
    driver.findElement(By.cssSelector("input[id='number2']")).sendKeys("35");

    //  Hesapla'ya tıklayın.
    driver.findElement(By.cssSelector("input[id='calculate']")).click();

    //sonucu alın ve yazdirin
    String result= driver.findElement(By.xpath("//span[@id='answer']")).getText();//sonuc alindi
    System.out.println("sonuc = " + result);//sonuc yazdirildi


}

}
