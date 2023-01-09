package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcelExample {
    /*
    Store the path of the file as string and open the file.
Open the workbook.
Open the first worksheet.
Go to the first row.
Create a cell on the 3rd column (2nd index) on the first row.
Write “POPULATION” on that cell.
Create a cell on the 2nd row 3rd cell(index2), and write data.
Create a cell on the 3rd row 3rd cell(index2), and write data.
Create a cell on the 4th row 3rd cell(index2), and write data.
Write and save the workbook.
Close the file.
Close the workbook.
Dosyanın yolunu dize olarak saklayın ve dosyayı açın.
Çalışma kitabını açın.
İlk çalışma sayfasını açın.
İlk satıra git.
İlk satırda 3. sütunda (2. dizin) bir hücre oluşturun.
Bu hücreye “Nüfus” yazın.
2. sıra 3. hücreye(index2) bir hücre oluşturun ve veriyi yazın.
3. sıra 3. hücrede (index2) bir hücre oluşturun ve verileri yazın.
4. sıra 3. hücreye(index2) bir hücre oluşturun ve veriyi yazın.
Çalışma kitabını yazın ve kaydedin.
Dosyayı kapatın.
Çalışma kitabını kapatın.

     */


    @Test
    public void writeExcel() throws IOException {
        //Dosyamizin pahthini belirttik  ->Dosyanın yolunu dize olarak saklayın ve dosyayı açın.
        String path="src/test/java/resources/excelfile.xlsx";

        //Dosyamizi aciyoruz--->Çalışma kitabını açın.
        FileInputStream fis=new FileInputStream(path);

        //Dosyamizi bir workbook haline getiriyoruz opende woorbook
        Workbook workbook= WorkbookFactory.create(fis);

        //İlk çalışma sayfasını açın.  Sheetimizi  olusturduk   SAYFA ==SHEET
        Sheet sheet2=workbook.getSheetAt(1);// excel de 2 sayfanin (2. sayfada calisacagimiz icin)  1 satirini aldik

        //İlk satıra git.  satir==ROW
        Row row1=sheet2.getRow(0);// 1 satir demek

        //İlk satırda 3. sütunda (2. dizin) bir hücre oluşturun.  3 satir bos oldugu icin  yeni bir method deniyoruz cell=dizin  SUTUN
        Cell row1cell3=row1.createCell(2);//ilk satirimizin 3. hucresini (sutununu) olusturduk 0-1-2

        //Bu hücreye “Nüfus”  POPULATION yazın. Hucremize deger atadik
        row1cell3.setCellValue("POPULATION");

       // 2. sıra 3. hücreye(index2) bir hücre oluşturun ve veriyi yazın.
        sheet2.getRow(1).createCell(2).setCellValue("Rusyanin populasyonu");//2. satirin ilk hucresi

        //3. sıra 3. hücrede (index2) bir hücre oluşturun ve verileri yazın.  2. satirin ilk hucresi
        sheet2.getRow(2).createCell(2).setCellValue("Cin'in populasyonu");//SUTUN DEGISMIYOR SATIR DEGISIYOR 2. SUTUNDA İSLEM YAPIYORUZ

        //4. sıra 3. hücreye(index2) bir hücre oluşturun ve veriyi yazın. 3 satirin 3 hucresi
        sheet2.getRow(3).createCell(2).setCellValue("ABD nin populasyonu");

       // Çalışma kitabını yazın ve kaydedin. excell dosyamiza yazma islemi yapiyoruz
        FileOutputStream fos=new FileOutputStream(path);//dosyamizi cagirdik
        workbook.write(fos);

            //    Dosyayı kapatın.
        fis.close();
        fos.close();
             //   Çalışma kitabını kapatın.
        workbook.close();



    }
}
