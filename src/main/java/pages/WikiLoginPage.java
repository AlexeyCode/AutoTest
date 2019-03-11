package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiLoginPage {
    private WebDriver driver ;
    private WebDriverWait wait;

    public WikiLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,10);
    }
    @FindBy(xpath = "//a[@id=\"js-link-box-ru\"]")
    private WebElement ruWikiLink;

    @FindBy(xpath = "//li[@id=\"pt-login\"]")
    private WebElement openloginPage;

    @FindBy(xpath = "//input[@id=\"wpName1\"]")
    private WebElement login;

    @FindBy(xpath = "//input[@id=\"wpPassword1\"]")
    private WebElement passwd;

    @FindBy(xpath = "//input[@id=\"wpRemember\"]")
    private WebElement stayLogged;

    @FindBy(xpath = "//button[@id=\"wpLoginAttempt\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//li[@id=\"pt-userpage\"]")
    private WebElement isLoginDisplayed;

    public void login(String name, String password){
        ruWikiLink.click();
        openloginPage.click();
        login.sendKeys(name);
        passwd.sendKeys(password);
        stayLogged.click();
        loginButton.click();

    }
    public boolean isLogged(String name){
        return isLoginDisplayed.getText().equals(name);
    }
}
