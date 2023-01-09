package Day10_GarryHoca;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class Task_02 extends BaseTest {
    /*
    1. "https://facebook.com" adresine gidin.
    2. "Create New Account" butonuna basın.
    3. "firstName" giriş kutusuna bir isim yazın.
    4. "surname" giriş kutusuna bir soyisim yazın.
    5. "email" giriş kutusuna bir email yazın.
    6. "email" onay kutusuna emaili tekrar yazın.
    7. Bir şifre girin.
    8. Tarih için gün seçin.
    9. Tarih için ay seçin.

    10. Tarih için yıl seçin.
    11. Cinsiyeti seçin. radio buton vardir
    12. İşaretlediğiniz cinsiyetin seçili, diğer cinsiyet kutularının seçili olmadığını doğrulayın. radio buton vardir
    13. Sayfayı kapatın.
*/
    @Test
    public void setup(){
        driver.get("https://facebook.com");

        WebElement newAccount= driver.findElement(By.linkText("Yeni Hesap Oluştur"));
        newAccount.click();
        // CEREZLER VARSA SAYFADA CEREZLERE IZIN VERMEK ICIN YAPMAMIZ GEREKEN
       /* WebElement cookies = driver.findElement(By.xpath("//*[.='Temel ve isteğe bağlı çerezlere izin ver']"));
        cookies.click();*/
       // 2. "Create New Account" butonuna basın.
        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
        //otomatik isim uretsin diye faker objesi olusturduk
        Faker faker = new Faker();
        Actions actions= new Actions(driver);
        String email=faker.internet().emailAddress();//Bizden iki defa amail istedigi icin obje ureterek gonderdik. eger obje uretmeseydik faker iki
        //ayri mail uretecekti . o zaman hata alirdik

        actions.click(firstName).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB)// iki defa sordugu icin iki tane yapıldı.
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)//dogum tarihine gecmek icin iki defa taba bastik
                .sendKeys(String.valueOf(faker.number().numberBetween(1,30))).sendKeys(Keys.TAB)//dogum tarihi gün  icin 1,30 arası bir say, gir dedik
                .sendKeys("Şub").sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1980,2000))).sendKeys(Keys.TAB).sendKeys(Keys.TAB)// 1980 ile 2000 yillari arasi bir yil sec dedik  cinsiiyet secimine gelmek icin iki tefa tab bastik
                .sendKeys(Keys.ARROW_RIGHT)// bir saga gidip erkegi secer kadini sectirmek istersek tekrar bir sola gelmemiz gerekir
               .sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB)// bir solo gelip kadini sectim
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        // bes defa tab a basınca kaydol butonun ustune geliyor sonra enter diyoruz kayit tamam

        //12. İşaretlediğiniz cinsiyetin seçili, diğer cinsiyet kutularının seçili olmadığını doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='1']")).isSelected());// kadin butonu secili mi dogrula
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='2']")).isSelected());  //diger secim kutularinin secili olmadigini dogrula
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='-1']")).isSelected());  //diger secim kutularinin secili olmadigini dogrula


          }
}
