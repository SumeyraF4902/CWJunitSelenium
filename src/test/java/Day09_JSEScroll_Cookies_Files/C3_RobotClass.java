package Day09_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;// keyEvent klavyedeki tuslari cagirma methoduu

public class C3_RobotClass extends BaseTest {

/// BIR DOSYA YOLLAYIP ONU KAYDETTIK
    @Test
    public void test() throws AWTException, InterruptedException {

       driver.get("https://demo.guru99.com/test/upload/");
        WebElement input= driver.findElement(By.id("uploadfile_0"));
        input.sendKeys("C:\\Users\\Muhsin Cevdet\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\resources\\robot.txt");

        Robot robot=new Robot();// Robot obj olusturduk klavyeyi komut tuslarıyla robot gibi yonlendirdik

        robot.keyPress(KeyEvent.VK_CONTROL);//keyPress tasa basili tutar, ctrl ye bastik
        robot.keyPress(KeyEvent.VK_S);// s tusuna bastik kaydetmis olduk  (ctrl+s ile)
        Thread.sleep(3000);

        robot.keyRelease(KeyEvent.VK_CONTROL);// ctrl den elimizi kaldirdik keyRelease serbest birak yani tusa basma
        robot.keyRelease(KeyEvent.VK_S);// S den elimizi kaldirdik
        Thread.sleep(3000);

        robot.keyPress(KeyEvent.VK_ENTER);//enter tusuna bastik
        robot.keyRelease(KeyEvent.VK_ENTER);//enter tusunu serbest birakelimizi cektik gibi dusun)
        Thread.sleep(3000);


        //UZERINE KAYDETMEK ICIN KULLANABILIRIZ
        robot.keyPress(KeyEvent.VK_LEFT);// SOL SECENEGE GEC
        robot.keyPress(KeyEvent.VK_ENTER);//ENTERE BAS
        robot.keyRelease(KeyEvent.VK_LEFT);// SOL SECENEKTEN ELINI KALDIR
        robot.keyRelease(KeyEvent.VK_ENTER);






    }}
