package Day12_Screenshots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class Odev_Tables extends BaseTest {

    /*
    Go to URL: https://the-internet.herokuapp.com/tables
    Print the entire table
    Print All Rows
    Print Last row data only
    Print column 5 data in the table body
    Write a method that accepts 2 parameters
    parameter 1 = row number
    parameter 2 = column number
    printData(3,4); => prints
    parameter 3 = table id
    printData(3,4,"table1") => prints data in 3rd row 4th Column with table id

    URL'ye gidin: https://the-internet.herokuapp.com/tables
    Tüm tabloyu yazdır***
    Tüm Satırları Yazdır***
    Yalnızca Son satır verilerini yazdır
    Tablo gövdesinde sütun 5 verilerini yazdır
    2 parametre kabul eden bir metot yazınız.
    parametre 1 = sıra numarası
    parametre 2 = sütun numarası
    printData(3,4); => yazdırır
    parametre 3 = tablo kimliği
    printData(3,4,"table1") => 3. sıra 4. sütundaki verileri tablo kimliği ile yazdırır
     */
    @Test
    public void tablo() {
        driver.get("https://the-internet.herokuapp.com/tables");
        //Tablomuzu locate ettik
        WebElement table1 = driver.findElement(By.id("table1"));
        WebElement table2 = driver.findElement(By.id("table2"));

        //table 1 ve 2yazdirildi
        System.out.println("TABLO 1");
        System.out.println(table1.getText());

        System.out.println("TABLO 2");
        System.out.println(table2.getText());

        //satir sayisi    //Tüm row=satirlari yazdır
        System.out.println("TABLO1 SATIR SAYISI");
        int numberOfRow = table1.findElements(By.xpath(".//tr")).size();
        System.out.println(numberOfRow);//5
        System.out.println("TABLO2 SATIR SAYISI");
        int numberOfRow2 = table2.findElements(By.xpath(".//tr")).size();
        System.out.println(numberOfRow2);//5

        System.out.println("TABLO 1");
        List<WebElement>table1rows=table1.findElements(By.xpath(".//tr"));

        for (WebElement each:table1rows) {
            System.out.println(each.getText());
            System.out.println();
        }
        System.out.println("TABLO 1");
        List<WebElement>table2rows=table2.findElements(By.xpath(".//tr"));
        table2rows.forEach(t-> System.out.println(t.getText()));
        System.out.println();

        System.out.println("SON SATIR ");
        System.out.println(table2rows.get(table2rows.size() - 1).getText());

        System.out.println("5. SUTUN ELEMANLARI");
        List<WebElement> table1columns5=table1.findElements(By.xpath(".//tr//td[5]"));
        List<WebElement>table2columns5=table2.findElements(By.xpath(".//tr//td[5]"));
        table1columns5.forEach(t-> System.out.println(t.getText()));
        table2columns5.forEach(t-> System.out.println(t.getText()));
      twoParameters(3,4,"table1");
        //  printData(3,4,"table1") => prints data in 3rd row 4th Column with table id

    }
    //  printData(3,4,"table1") => prints data in 3rd row 4th Column with table id
    public void twoParameters(int satir, int sutun,String table){
        WebElement tablex=driver.findElement(By.id(table));
        System.out.println(tablex.findElement(By.xpath(".//tr["+satir+"]//td["+sutun+"]")).getText());;


    }


}

