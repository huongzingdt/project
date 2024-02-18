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
    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(tagName = "button")
    private WebElement loginButton;

    @FindBy(xpath = "//label[contains(text(),'Remember me')]")
    private WebElement rememberMe;

    @FindBy(xpath = "//a[contains(text(), 'forgot password')]")
    private WebElement forgotPassword;

    public void navigate(String url){
        getDriver().get(url);
    }
    public void login(String email1, String password1){
        getWait().until(ExpectedConditions.visibilityOf(email));
        email.clear();
        password.clear();
        email.sendKeys(email1);
        password.sendKeys(password1);
        loginButton.click();
    }

    public boolean verifyLogin(){
        return email.isDisplayed() && password.isDisplayed() && loginButton.isDisplayed()
                && rememberMe.isDisplayed()&& forgotPassword.isDisplayed();
    }

}
