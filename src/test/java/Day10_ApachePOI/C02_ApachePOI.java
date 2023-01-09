package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_ApachePOI {
   /* Add the excel file on the resources folder.
    Open the file.
    Open the workbook using file input stream.
    Open the first worksheet.
    Go to first row.
    Go to first cell on that first row and print.
    Go to second cell on that first row and print.
    Go to 2nd row first cell and assert if the data equal to Russia.
    Go to 3rd row 2nd cell-chain the row and cell.
    Find the number of used row.
    Print country, area key value pairs as map object.

    */

@Test
    public  void apacheTask() throws IOException {

        String path="src/test/java/resources/excelfile.xlsx";

        //Open the file.
        FileInputStream fileInputStream=new FileInputStream(path);

        // Open the workbook using file input stream.
        Workbook workbook= WorkbookFactory.create(fileInputStream);

      // Open the first worksheet.
    Sheet sheet1= workbook.getSheetAt(0);

    //Go to first row. row gideceksek data tipi Row methodu ile
    Row row1= sheet1.getRow(0);// 1 satir oluusturuldu

   // Go to first cell on that first row and print.
    Cell row1cell1= row1.getCell(0);

    //Go to second cell on that first row and print.
    System.out.println("row1cell1 = " + row1cell1);


    //    Go to second cell on that first row and print.
    Cell row1cell2= row1.getCell(1);
    System.out.println("row1cell2 = " + row1cell2);

    //Go to 2nd row first cell and assert if the data equal to Russia.

    Row row2= sheet1.getRow(1);// 2. satir olusturuldu
    Cell row2cell1= row2.getCell(0);//ilk hücre alindi
    Assert.assertEquals("Rusya", row2cell1.toString());


    //    Go to 3rd row 2nd cell-chain the row and cell.
    Cell row3cell2=  sheet1.getRow(2).getCell(1);
    System.out.println("row3cell2 = " + row3cell2);


    //    Find the number of used row.// kullanilan satirlarin sayisini bulun
    System.out.println("sheet1.getPhysicalNumberOfRows() = " + sheet1.getPhysicalNumberOfRows());// satir  sayisini  direkt verir   16
    System.out.println("sheet1.getLastRowNum() = " + sheet1.getLastRowNum()+1);// son satirin indexini   verir    15+1
    //iki method aralasindaki fark index farki  -1 ,

    int totalRows=sheet1.getPhysicalNumberOfRows();

    //    Print country, area key value pairs as map object.

    Map<String,String> countryAreas= new HashMap<String,String>();
       for(int row=1; row<totalRows; row++){// basliklarimizi istemedigimiz icin 1 .indexten baslattik
        String country=sheet1.getRow(row).getCell(0).toString();


        //Her satirdaki ulkeyi yazdiriyoruz
       System.out.println(row+1+". satir="+country);//2 satirdan baslamis olduk

        String area=sheet1.getRow(row).getCell(1).toString();

        //herbir ülkeyi ve yuz olcumlerini yazdirdik
        System.out.println("Country ="+country+"--Area="+area);

           // Her bir satirdaki ulke ve yuzolcumu degerlerini map imizin icerisine yerlestirdik.
           countryAreas.put(country,area);
       }

    // Map imizi yazdiriyoruz
    System.out.println(countryAreas);
}

}

