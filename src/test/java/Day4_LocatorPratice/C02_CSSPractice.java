package Day4_LocatorPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_CSSPractice {


    //http://the-internet.herokuapp.com/add_remove_elements/
// Click on the "Add Element" button 100 times.
// Write a function that takes a number, and clicks the "Delete" button.
// Given number of times, and then validates that given number of buttons was deleted.
// 1. Method: createButtons(100)
// 2. Method: DeleteButtonsAndValidate()// yardimci methoddur diger metodun icinde sonra cagrilir
    WebDriver driver;

    @Before
    public void setup(){
        //driver ile ilgili her türlü initial (baslangıic)islemi burada yapilir
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @After
    public void tearDown(){
        //test sonrasinda driver kapatmak (varsa raporları dosyalamak) icin kullanilir
       // driver.quit();
    }
    @Test
    public void cssSelectortest(){
        //site linkine gidiyoruz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //createButtons metodu ile 100 defa create elements e tikliyoruz.
        createElements(100);

        //deleteButtonsAndValidate methodu ile 40 button silinir  ve kontrol edilir
      deleteButtonsAndValidate(40);

    }

    public void  createElements(int amount) {// yardimci method oldugu icin test acilmadi diger methodun icinde cagrılacak

        WebElement addElemanButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < amount; i++) {
            addElemanButton.click();//girilen sayi kadar tikla demek

        }
    }
        public void deleteButtonsAndValidate(int amount) {//hem silme hemde kontrol edecek method

            //sayfadaki delete button sayisini saklariz
            List<WebElement> deleteButtonsList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
            int silinmedenOnceDeleteButtonSayisi = deleteButtonsList.size();


            // bizden istenen sayi kadar botunu sileriz
            for (int i = 0; i < amount; i++) {
                deleteButtonsList.get(i).click();

            }

            //silindikten sonraki buton sayisini buluruz
          List<WebElement>deleteButtonsListAfter=driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
            int silinmedenSonraDeleteButtonSayisi=deleteButtonsListAfter.size();

            //ilk sayi ile son sayi arasindaki farki dogrularız
            Assert.assertEquals(silinmedenOnceDeleteButtonSayisi-amount,silinmedenSonraDeleteButtonSayisi);


        }


        }

