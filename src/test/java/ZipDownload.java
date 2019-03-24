import DriverFactory.DriverFactory;
import org.junit.jupiter.api.*;
import DriverFactory.DriverType;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ZipDownload {
    //https://sourceforge.net/projects/freedos/files/latest/
    private WebDriver driver;

    @Test
    void setUp() {
        driver = DriverFactory.getDriver(DriverType.IE);
        driver.get("https://sourceforge.net/projects/freedos/files/latest/");
        try{
            Thread.sleep(6000);
        }catch (InterruptedException e){}
        try {
            String text = "E:\\IR robot\\report.zip";
            StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, stringSelection);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
        }catch (Exception e){}
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }






}
