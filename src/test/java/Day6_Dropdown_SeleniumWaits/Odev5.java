package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Odev5 {
    /*
    Go to URL: https://the-internet.herokuapp.com/dropdown
Create method selectByIndexTest and Select Option 1 using index .
Create method selectByValueTest Select Option 2 by value.
Create method selectByVisibleTextTest Select Option 1 value by visible text.
Create method printAllTest Print all dropdown value.
Verify the dropdown has Option 2 text.
Create method printFirstSelectedOptionTest Print first selected option.
Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.

URL'ye gidin: https://the-internet.herokuapp.com/dropdown   ***
method selectByIndexTest oluşturun ve index kullanarak Seçenek 1'i seçin.**
Yöntemi oluştur selectByValueTest Seçenek 2'yi değere göre seçin.**
Yöntem selectByVisibleTextTest oluşturun Görünür metinle Seçenek 1 değerini seçin.***
printAllTest yöntemini oluştur Tüm açılır değeri yazdır.***
Açılır listede Seçenek 2 metni olduğunu doğrulayın.***
Yöntem oluşturun printFirstSelectedOptionTest İlk seçilen seçeneği yazdırın.****
Açılır listenin boyutunu bulun, açılır listede 3 öğe yoksa "Beklenen Eşit Gerçek Değil" yazdırın.
     */
    WebDriver driver;
    @Before
    public void setUp(){
        //Driver ile ilgili her turlu initial(baslangic) islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown() {
        // test sonrasinda driver kapatmak (varsa raporlari dosyalamak) icin kullanilir.
        //  driver.quit();
    }

    @Test
            public void selectByIndexTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // 1. YOL
      /*  Select select=new Select(driver.findElement(By.id("dropdown")));
        select.selectByIndex(1);
        select.selectByValue("2");
        select.selectByVisibleText("Option 1");
        List<WebElement> options=select.getOptions();
        options.forEach(x-> System.out.println(x.getText()));//Please select an option---- Option 1---- Option 2
        System.out.println(options.get(2).isDisplayed());
        System.out.println(select.getFirstSelectedOption());
        System.out.println("options.size() = " + options.size());
        Assert.assertTrue("Beklenen Eşit Gerçek Değil",options.size()==3);
*/ // 2 . YOL
        WebElement select=driver.findElement(By.id("dropdown"));
        selectByIndexTest(select,1);
        selectByValue(select,"2");
        selectByVisibleText(select,"Option 1");
        printAllText(select);
        printFirstSelectedOption(select);
        Verifythedropdown(select,"2");
        Assert.assertTrue(Verifythedropdown(select,"Option 2"));
    }

    private boolean Verifythedropdown(WebElement selec,String a) {
        Select select2=new Select(selec);
        long count=select2.getOptions().stream().filter(t->t.getText().contains(a)).count();
        return count!=0;

    }

    private void printFirstSelectedOption(WebElement select) {
        Select select2=new Select(select);
        System.out.println(select2.getFirstSelectedOption().getText());
    }

    private void printAllText(WebElement select) {
        Select select1=new Select(select);
        select1.getOptions().forEach(t-> System.out.println(t.getText()));
        //Please select an option---- Option 1---- Option 2
    }

    private void selectByVisibleText(WebElement select, String s) {
        Select select1=new Select(select);
        select1.selectByVisibleText(s);
    }

    private void selectByValue(WebElement select, String s) {
        Select select1=new Select(select);
        select1.selectByValue(s);
    }

    private void selectByIndexTest(WebElement select, int i) {
        Select select1=new Select(select);
        select1.selectByIndex(i);
    }
}
