package Day12_Screenshots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C03_WebTables extends BaseTest {
    /*
    Go to URL: http://demo.guru99.com/test/web-table-element.php
To find third row of table
To get 3rd row's 2nd column data
Get all the values of a Dynamic Table

URL'ye gidin: http://demo.guru99.com/test/web-table-element.php
Tablonun üçüncü sırasını bulmak için
3. satırın 3. sütun verilerini almak için
Dinamik Tablonun tüm değerlerini alın
     */

    @Test
    public void webTableExample(){// tablolarda by.xpath uzerinden arama yapariz
        //Go to URL: http://demo.guru99.com/test/web-table-element.php
        driver.get("http://demo.guru99.com/test/web-table-element.php");

        //tablomuzu locate ettik
        WebElement table= driver.findElement(By.className("dataTable")).findElement(By.tagName("tbody"));//tablomuzu objeye atadik

            //To find third row of table // 3. satir locate edildi  xpath te index 1 den baslar
        WebElement row3=table.findElement(By.xpath(".//tr[3]"));//element uzerinden aramamizi gostermek adina . ile baslıyoruz. sadebe bu satirin 3. sutununu al dedik
        System.out.println(row3.getText());

        //To get 3rd row's 3nd column data 3. satir 3 . sutun (hucre)locate edildi
        WebElement row3cell3=row3.findElement(By.xpath(".//td[3]"));// hucreler td ile basladigi icin direk yazariz bakmaya gerek yok
        System.out.println(row3cell3.getText());

        //Get all the values of a Dynamic Table satir sayimizi bulduk
        int satirSayisi=table.findElements(By.xpath(".//tr")).size();// tr satiri verdigi icin tum table ın row larini aldik. tagname de kullanabilirsin
        System.out.println(satirSayisi);//26
        //sutun sayimizi bulduk
        int sutunSayisi=row3.findElements(By.xpath(".//td")).size();//sutun sayisini verir
        System.out.println(sutunSayisi);//5

        //for donguusu ile tum hucreleri geziyoruz
        for(int i=1; i<=satirSayisi; i++){//herbir satir
            for (int j = 1; j <=sutunSayisi ; j++) {//her bir sutun
                By locator=By.xpath(".//tr["+i+"]//td["+j+"]");
                WebElement tableData=table.findElement(locator);
                System.out.print(tableData.getText()+" ");

            }
            System.out.println();
        }





}}

