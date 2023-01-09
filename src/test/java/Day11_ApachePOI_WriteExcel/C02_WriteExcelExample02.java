package Day11_ApachePOI_WriteExcel;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.*;

public class C02_WriteExcelExample02 {
    /*
    Create an object of File class to open xlsx file.
Create an object of FileInputStream class to read excel file.
Create an object of FileInputStream class to read excel file.
Creating workbook instance that refers to .xlsx file.
Creating a Sheet object.
Get all rows in the sheet.
Create a row object to retrieve row at index 3.
Create a cell object to enter value in it using cell Index.
Write the data in excel using output stream.
xlsx dosyasını açmak için File sınıfından bir nesne oluşturun.
Excel dosyasını okumak için FileInputStream sınıfından bir nesne oluşturun.
Excel dosyasını okumak için FileInputStream sınıfından bir nesne oluşturun.
.xlsx dosyasına başvuran çalışma kitabı örneği oluşturma.
Sayfa nesnesi oluşturma.
Sayfadaki tüm satırları alın.
Dizin 3'teki satırı almak için bir satır nesnesi oluşturun.
Hücre Dizini'ni kullanarak değer girmek için bir hücre nesnesi oluşturun.
Çıkış akışını kullanarak verileri excel'e yazın.
     */

    @Test
    public void changeExcelData() throws IOException {
        //xlsx dosyasını açmak için File sınıfından bir nesne oluşturun.
        //src/test/java/resources/excelData.xlsx dosyamizin pathini aldik
        String filePath="src/test/java/resources/excelData.xlsx";

        File file=new File(filePath);//pathimizden file olusturuldu

        FileInputStream fis=new FileInputStream(file);//file mizi actik

        Workbook wb=WorkbookFactory.create(fis);//workbook dosyamizi olusturduk


        //Sayfa nesnesi oluşturma. sheeti olusturduk
        Sheet informationData=wb.getSheet("informationData");//woorkbook un icinden istedigim sayfayi secmis olduk

        //Sayfadaki tüm satırları alın.
        int totalRowsUsed=informationData.getLastRowNum()-informationData.getFirstRowNum();//son satirdan ilk satiri cikararak kac satir kullanildigini gorduk
        System.out.println("Total rows="+totalRowsUsed);//11. aradaki bos satirlarda dahil

        //Yeni bir row olusturup row icersindeki celleri de olusturarak degerlerini atadik.
        Row row5=informationData.createRow(4);//5. satiri olusturuyoruz
        //4. satir bos oldugu icin bize null verir. once icini dolduruyoruz
        row5.createCell(0).setCellValue("Karl");//5. satirin 0. hücresini (sutununu) doldurduk
        row5.createCell(1).setCellValue("Ortis");
        row5.createCell(2).setCellValue("Ortis.coom");
        row5.createCell(3).setCellValue("male");
        row5.createCell(4).setCellValue("12354687");
        row5.createCell(5).setCellValue("Adress");

        //dosyamizin yazma islemini gerceklestirdik
        FileOutputStream fos=new FileOutputStream(file);
        wb.write(fos);
        //Çıkış akışını kullanarak verileri excel'e yazın.
        fis.close();
        fos.close();
        wb.close();
    }

}
