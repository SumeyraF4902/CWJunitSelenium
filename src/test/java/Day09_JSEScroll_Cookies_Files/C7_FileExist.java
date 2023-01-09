package Day09_JSEScroll_Cookies_Files;

import org.junit.Test;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C7_FileExist extends BaseTest {

    public static  void main(String[] args) {
      //DOSYA BULMA DOSYA OKUMA
        System.getProperty("user.dir");//projemizin rootunun yolunu verir
        System.out.println(System.getProperty("user.dir"));//C:\Users\Muhsin Cevdet\IdeaProjects\CWJunitSelenium
        String projectRoot=System.getProperty("user.dir");//Bulmak istedigimiz file proje icerisinde oldugundan proje yolunu aldik OBJEYE ATADIK
        String filePath="//src/test/java/resources/fileExist.jpg";//Bulmak istedigimiz dosyanin proje klasorunden sonraki yolunu aldik (Copy path from content root)
        filePath=projectRoot+filePath;//Almis oldugumuz 2 yolu birlestirip absolute path imizi elde ettik

        System.out.println(Files.exists(Paths.get(filePath)));// Bu path de bir dosya olup olmadigini dogruladik   TRUE

        //Paths.get(filePath) BU Method string olan filePathi Paths e cevirdi

        if(Files.exists(Paths.get(filePath))){//eger dosya varsa;
            System.out.println("Dosya bulundu");// varsa bulundu yazdirdik
        }else{
            System.out.println("Dosya bulunamadi");//Yoksa bulunamadi yazdirdik
        }
    }

}
