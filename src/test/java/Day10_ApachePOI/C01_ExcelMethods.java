package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelMethods {
    public static void main(String[] args) throws IOException {
        /*
        Add the excel file on the resources folder.
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

Excel dosyasını kaynaklar klasörüne ekleyin.
Dosyayı aç.
Dosya giriş akışını kullanarak çalışma kitabını açın.
İlk çalışma sayfasını açın.
İlk sıraya git.
İlk satırdaki ilk hücreye gidin ve yazdırın.
İlk satırdaki ikinci hücreye gidin ve yazdırın.
2. sıradaki ilk hücreye gidin ve verilerin Rusya'ya eşit olup olmadığını onaylayın.
3. sıra 2. hücre zincirine gidin, sıra ve hücre.
Kullanılan satır sayısını bulun.
Ülke, alan anahtar değeri çiftlerini harita nesnesi olarak yazdırın.
         */
        //Excel dosyamizin pathini aldik
        String path="src/test/java/resources/excelfile.xlsx";

        //Dosyamizi actik
        FileInputStream fileInputStream = new FileInputStream(path);

        //actigimiz dosyayi excel workbook una cevirdik
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //workbook umuzdan sheetimizi gecis yaptik
        Sheet sheet1= workbook.getSheetAt(0);//ilk sayfayi acmis olduk

        Row row1= sheet1.getRow(0);//ilk indexi almis olduk  hucreye erisim satir index 0 dan baslar

        //satirimizdan istedigimiz hucreyi aldık index 0 dan baslar
        Cell cell1=row1.getCell(0);// satirin ilk sutunu

        System.out.println("cell1 = " + cell1);//COUNTRY

        //// Hucrelerimizde string operasyonlari gerceklestirmek istersek toString() methodunu kullanarak hucreyi stringe cevirmeliyiz
        //System.out.println("cell1.toString().toLowerCase() = " + cell1.toString().toLowerCase());//country
    }
}
