package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiMain {
    WebDriver driver ;

    public WikiMain(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name = \"search\"]")
    WebElement searchButton;


    public void sendText(String text){
        searchButton.sendKeys(text);
        searchButton.submit();
    }


}
