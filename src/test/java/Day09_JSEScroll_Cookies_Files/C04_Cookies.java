package Day09_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class C04_Cookies extends BaseTest {
    /*Go to URL: https://kitchen.applitools.com/ingredients/cookie
    Get Cookie.
    Find the total number of cookies.
    Print all the cookies.
    Add Cookie.
    Edit Cookie.
    Delete Cookie.
    Delete All Cookies.*/

    @Test
    public void testCookies() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        System.out.println("test get cookie");

        Cookie cookie = driver.manage().getCookieNamed("protein");//cookie isimle cagirdik
        Assert.assertEquals("chicken",cookie.getValue());// valuse chicken mi

        //Find the total number of cookies. cookie sayilarini bul
        Set<Cookie> allCookies=driver.manage().getCookies();
        int numOfCookies=allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies);//   2

        //Print all the cookies. hepsini yazdir
        for (Cookie c : allCookies) {// herbir cooki yazdir
            System.out.println(c);// degeri
            System.out.println(c.getName() + " = " + c.getValue());
            /*protein = chicken
             vegetable = broccoli*/
            //lambda ile;
            driver.manage().getCookies().forEach(t-> System.out.println(t.getName()));
        }

        // ADD Cookie : cookie ekle
        System.out.println("add cookie");
        Cookie cookie1=new Cookie("fruit","apple");//cookie olusturduk
        driver.manage().addCookie(cookie1);
        Assert.assertEquals(cookie1.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());
        //ekledigimiz cookinin valusu ekleyip ekrana gonderdigimiz ekranıdakinin vausu ile ayni mi bakildi

        allCookies=driver.manage().getCookies();// sayfada var olan cokileri dondurur
        System.out.println(allCookies.size());// 3

        //Edit Cookie. guncelleme, adini degistirme
        System.out.println("Edit Cookie.");
        Cookie editeCookie=new Cookie(cookie1.getName(),"mango");//cookie1 mango olarak degistirdik
        driver.manage().addCookie(editeCookie);//editlenmis cookiyi ekle

        Assert.assertEquals(editeCookie.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());
        System.out.println(driver.manage().getCookieNamed(cookie1.getName()).getValue());}

        //Delete Cookie. cookie  sil
        @Test
                public void deleteCookie() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
            Set<Cookie> allCookies = driver.manage().getCookies();
            int numOfCookies = allCookies.size();
            System.out.println("numOfCookies = " + numOfCookies); //numOfCookies = 2


            Cookie cookie2=new Cookie("drinks","ayran");//  cookie olusturduk
             driver.manage().addCookie(cookie2);// cookie ekledik
            allCookies=driver.manage().getCookies();// sayfada var olan cookileri dondurur
            System.out.println("allCookies = " + allCookies.size()); //allCookies = 3
            System.out.println("delete cookies");

            driver.manage().deleteCookie(cookie2);// cookie silindi
            driver.manage().deleteCookie(cookie2); // cookie sildik
            Assert.assertNull("cookie halen var", driver.manage().getCookieNamed(cookie2.getName())); //PASSED

            //Delete All Cookies.   cookie leri sil
            allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
            System.out.println("allCookies = " + allCookies.size()); //allCookies = 2
            driver.manage().deleteAllCookies(); //browserdan hepsi sildik
            allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
            System.out.println("allCookies = " + allCookies.size()); // allCookies = 0

        }




    }


