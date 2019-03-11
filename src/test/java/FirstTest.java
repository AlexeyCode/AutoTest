
import DriverFactory.DriverFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.WikiLoginPage;
import pages.WikiMain;
import DriverFactory.DriverType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FirstTest {
    private WebDriver driver;
    private WikiMain wikiMain;
    private WikiLoginPage wikiLoginPage;

    @BeforeEach
    void setUp(){
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org/");
    }

    @Test
    void searchTest(){
        wikiMain = new WikiMain(driver);
        wikiMain.sendText("Selenium");
        assertEquals("Selenium",driver.getTitle().substring(0,8));

    }

    @Test
    void loginTest(){
        wikiLoginPage = new WikiLoginPage(driver);
        wikiLoginPage.login("Logintest1","Gthtljp22");
        assertTrue(wikiLoginPage.isLogged("Logintest1"));
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    //    @ParameterizedTest(name = "run #{index} with [{arguments}]")
//    @ValueSource(strings = {"Hello", "JUnit5"})
//    void valueNotNull(String word){
//        assertNotNull(word);
//    }
}
