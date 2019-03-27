package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Wtables {

    WebDriver driver;
    WebElement webElement;

    public Wtables(WebDriver driver, WebElement webElement){
        this.driver = driver;
        this.webElement = webElement;
    }

    @FindBy(xpath = "//table[@id=\"customers\"]")
    private WebElement tableElement;

    public List <WebElement> getRows(){
        List<WebElement> rowList = tableElement.findElements(By.xpath(".//tr"));
        rowList.remove(0);
        return rowList;
    }

    public List<List<WebElement>> getTableElementByIndex(int rowNum, int columnNum){
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsList = new ArrayList <>();
        for( WebElement row : rows){
            List<WebElement> rowWithColumn = row.findElements(By.xpath(".//td"));
            rowsList.add(rowWithColumn);
        }
        return rowsList;
    }
}
