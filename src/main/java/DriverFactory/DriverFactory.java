package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class DriverFactory {
    private static final Map <DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        return driver;
    };

    private static final Supplier<WebDriver> fireFoxSupplier = () -> {
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\Drivers\\geckodriver.exe" );
        return new FirefoxDriver();
    };

    private static final Supplier<WebDriver> ieSupplier = () -> {
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\Drivers\\IEDriverServer.exe");
        InternetExplorerOptions options = new InternetExplorerOptions()
                .introduceFlakinessByIgnoringSecurityDomains()
                .requireWindowFocus()
                .destructivelyEnsureCleanSession();

        WebDriver driver = new InternetExplorerDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        return driver;
    };

    static{
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, fireFoxSupplier);
        driverMap.put(DriverType.IE, ieSupplier);
    }
    public static final WebDriver getDriver(DriverType type){
        return driverMap.get(type).get();
    }
}
