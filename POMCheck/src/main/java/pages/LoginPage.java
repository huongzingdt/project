package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName="button")
    private WebElement directLogin;

    @FindBy(id="identifierId")
    private WebElement username;

    @FindBy(xpath = "//span[@class = 'VfPpkd-vQzf8d' and contains (text(), 'Next')]")
    private WebElement nextButton;

    @FindBy(name = "Passwd")
    private WebElement password;



    public void navigateUrl(String url){
        getDriver().get(url);
        getWait().until(ExpectedConditions.visibilityOf(directLogin));
        directLogin.click();
    }

    public void login(String u, String p){
        getWait().until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(u);
        nextButton.click();
        getWait().until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(p);
        nextButton.click();
    }

}
