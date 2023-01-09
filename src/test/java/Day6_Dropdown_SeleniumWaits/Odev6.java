package Day6_Dropdown_SeleniumWaits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class Odev6 extends BaseTest {
    /*
    Launch the browser.
Open "https://demoqa.com/select-menu".
Select the Standard Multi-Select using the element id.
Verifying that the element is multi-select.
Select 'Opel' using the index and deselect the same using index.
Select 'Saab' using value and deselect the same using value.
Deselect all the options.
Close the browser.

Tarayıcıyı başlatın.
"https://demoqa.com/select-menu" öğesini açın.****
Öğe kimliğini kullanarak Standart Çoklu Seçimi seçin.***
Öğenin çoklu seçim olduğu doğrulanıyor.****
Dizini kullanarak 'Opel'i seçin ve dizini kullanarak aynı seçimi kaldırın.***
Değer kullanarak 'Saab'ı seçin ve aynı kullanım değeri seçimini kaldırın.***
Tüm seçeneklerin seçimini kaldırın.
Tarayıcıyı kapatın.

     */
    @Test
    public void CokluSeciml(){
        driver.get("https://demoqa.com/select-menu");
        Select select=new Select(driver.findElement(By.id("cars")));
        Assert.assertTrue(select.isMultiple());// coklu secim mi kontrol edildi
        select.selectByIndex(2);// opel secildi
        select.deselectByIndex(2);// opel secim kaldirildi
        select.selectByValue("saab");// Saab secildi
        select.deselectByValue("saab");// Saab secim kaldirildi
        select.deselectAll();// butun secimler kaldirildi


    }

}
