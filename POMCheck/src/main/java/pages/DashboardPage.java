package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Dashboard')]")
    private WebElement dashboardMenu;

    @FindBy(xpath = "(//li/a[contains(text(),'Marketing')])[2]")
    private WebElement marketingMenu;

    public boolean verifyLoginSuccess(){
        getWait().until(ExpectedConditions.visibilityOf(dashboardMenu));
        return dashboardMenu.isDisplayed();
    }

    public void gotoMarketing(){
        getWait().until(ExpectedConditions.visibilityOf(marketingMenu));
        marketingMenu.click();
    }
}
