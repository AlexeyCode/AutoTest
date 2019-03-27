import DriverFactory.DriverFactory;
import DriverFactory.DriverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class W3tables {
    WebDriver driver = DriverFactory.getDriver(DriverType.CHROME);

    @BeforeEach
    void setUp(){
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();
    }

    @Test
    void testNum(){
        WebElement table = driver.findElement(By.xpath("//table[@id=\"customers\"]"));
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        rows.remove(0);
        //rows.forEach(row -> System.out.println(row.getText()));
        List<List<WebElement>> rowsElements = new ArrayList <>();
        int i = 0;
        for(WebElement elementRow : rows){
            List<WebElement> againList = elementRow.findElements(By.xpath(".//td"));
            rowsElements.add(againList);

        }
        System.out.println(rowsElements.size());
        for(List<WebElement> list : rowsElements){
           // System.out.println(list.get(0).getText());
            if(list.get(0).getText().equals("Ernst Handel"))
                System.out.println(list.get(2).getText());
        }
//        for(List<WebElement> list : rowsElements)
//        {
//            if(list.get(0).getText().equals("Ernst Handel"))
//                System.out.println(list.get(2));
//        }


    }
}
