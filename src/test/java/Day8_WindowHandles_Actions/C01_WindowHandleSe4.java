package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class C01_WindowHandleSe4 extends BaseTest {
    /*
    driver.switchTo()..window(swicth)-->Window handle değerini kullanarak pencereler arası geçiş yapar.
    driver.switchTo(). getWindowHandle()→ Mevcut sayfanın window handle  değerini alır. String olarak dondurur.
    driver.switchTo(). getWindowHandles()→→ Tüm sayfaların window handle değerini alır.. TUM ACIK SAYFALARIN
    WINDOWSHANDLE DEGERINI SET<String> olarak dondurur(
     driver.switchTo().newWindow(WindowType.TAB);→ Yeni TAB oluşturarak geçiş yapar
     driver.switchTo().newWindow(WindowType.WINDOW); → Yeni WINDOW oluşturarak geçiş yapar.
     */
// https://testproject.io/

    // https://blog.testproject.io/


    @Override
    public void tearDown() {//DRIVERIMIZ KAPATILMASIN DIYE OVERLOD ETTIK

    }

    @Test
    public void newWindow(){
        //YENI PENCERE ACMA

            //// Ana sekmemizde url i ziyaret ediyoruz.
        driver.get("https://testproject.io");

        //Yeni pencere olusturup o pencereye switch ediyoruz.
        driver.switchTo().newWindow(WindowType.WINDOW);

        //switcto methodu driveri yeniledi

        //Yeni penceremizde url imizi ziyaret ediyoruz ikiside ayni adres oldu
        driver.get("https://testproject.io");
    }
        @Test
    public void newTab(){
        //YENI TAB OLUSTURMA VE TAPLAR ARASI GEZINME ISLEMI

    // https://www.amazon.com/

                // Ana(penceremiz ) sekmemizden testproject acildi
            driver.get("https://testproject.io/");

            // Yeni bir sekme olusturuldu
            WebDriver newTab=driver.switchTo().newWindow(WindowType.TAB);// bad practis

            // Yeni sekmeden amazona gidildi
            newTab.get("https://www.amazon.com/");// bad practis
           // driver.get("https://www.amazon.com");// best practis

            // burada newTab=driver gorevi gordu. hic webelement objesi olusturmadanda driver ile yapabiliriz

            //Aktif tab in title i yazdirildi -> Aktif tab imiz = yeni olusturulan tab
            driver.getTitle();


        }
        @Test
    public void handleWindows(){


            // Ana sekmemizde amazon aciliyor
        driver.get("https://www.amazon.com/");

          //getWindowHandle--> id degerler dondurur.

         String homePageHandle=driver.getWindowHandle();// ana sayfamizi daha sonra kullanmak uzere id sini stringe atadik

            //yeni pencere olusturduk
            driver.switchTo().newWindow(WindowType.WINDOW);

        //Yeni  pencerede actik
            driver.get("https://www.google.com/");

            //dongumuze hazirlik methodu ikisi bir . Taplar arasi gecis icin
            Set<String> handles=driver.getWindowHandles();// gezinmek istedigimiz handlerin id lerini set e atamıs olduk elimizde id listesi olustu
            Iterator<String> i= handles.iterator(); // set icinde gezinmek icin olusturuldu.  gezinme islemi icin olusturulması zorunludur.

            while(i.hasNext()) {//hasNext methodu  listedeki id ler bitene kadar  sırasıyla id leri getirir
                String currentTab=i.next();// gelen id yi currentTab atadik

               driver.switchTo().window(currentTab);// ilgili sekmeye gecis saglandi

                System.out.println(driver.getTitle()); //  acilan pencerelerin title methodu ile  (isimlerini ) yazdirdik

              //  driver.close();//butun pencereler kapandi ana sayfa dahil.

                //KONTROLLU KAPATMA İSLEMİ

                //1 YOL
             /*   if(!driver.getWindowHandle().equals(homePageHandle)){// gelen sayfa, ana sayfaya esit degilse kapat demek
                driver.close();}

                //2 YOL EGER ANA SAYFANIN ID SINI BASTA ALMAYI UNUTTUYSAK
                if(!driver.getTitle().contains("Spend")){// tekrar ana sayfayı ac en uste solda title icinde ki diger sekmelerin icinde olmayan bir kelimesini al ve onu
                    //contains iicne koy.. veya Url icinden bir kelime alabilirsin. burada dedik ki; gelen sayfa  speed kelimesi icermiyorsa kapat.
                    //***AMA İD İLE KAPATMAK EN GARANTİDİR BASTA MUTLAKA ID SINI AL CUNKU DİGER. TITLE . URL DEGİSEBİLİR
                    driver.close();    }

*/
            }
        }
}
