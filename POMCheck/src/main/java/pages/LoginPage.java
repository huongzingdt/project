package pages;

import core.BasePage;
import core.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By directLogin = By.tagName("button");
    private By username = By.id("identifierId");
    private By nextButton = By.xpath("//span[@class = 'VfPpkd-vQzf8d' and contains (text(), 'Next')]");
    private By password = By.tagName("Passwd");




    public void navigateUrl(String url){
       getDriver().get(url);
       waitForPageLoad();
       clickElement(directLogin);
    }

    public void login(String u, String p){
       sendKeys(username, u);
       clickElement(nextButton);

        sendKeys(password, p);
       clickElement(nextButton);

    }

}
