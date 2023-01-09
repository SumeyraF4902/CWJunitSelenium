package Day09_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class C08_FileExists {

    @Test
    public void fileExists() {
        //C:\Users\Muhsin Cevdet\Desktop\fileExist.png
        //C:\Users\Muhsin Cevdet\IdeaProjects\CWJunitSelenium\src\test\java\resources\fileExist.png
        System.out.println(System.getProperty("user.home")); // Home yolunu yazdirdik     C:\Users\Muhsin Cevdet

        String homePath = System.getProperty("user.home"); // Home yolunu atadik

        String filePath = "\\Desktop\\fileExist.png"; // Dosyanin kalan yolunu atadik

        String fullPath = homePath + filePath; // home ve dosya yollarini birlestirip full path i elde ettik

        File image = new File(fullPath); //String fullPath  imizi file a cevirdik

        Assert.assertTrue(image.exists()); // exists metoduyla varolup olmadigini kontrol ettik

    }
}
