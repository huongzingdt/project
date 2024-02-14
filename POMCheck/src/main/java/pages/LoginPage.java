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

    @FindBy(id="field_id__1")
    private WebElement username;

    @FindBy(id="field_id__2")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Forgot')]")
    private WebElement forgotPassword;

    public void navigateUrl(String url){
        getDriver().get(url);
        getWait().until(ExpectedConditions.visibilityOf(username));
    }

    public void login(String u, String p){
        getWait().until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("admin");
        password.sendKeys("scipio");
        loginButton.click();
    }

}
