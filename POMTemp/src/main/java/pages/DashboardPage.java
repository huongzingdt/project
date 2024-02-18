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

    @FindBy(xpath = "//h2[contains(text(), 'Dashboard')]")
    private WebElement titlePage;

    @FindBy(xpath = "//li//span[contains(text(),'Dashboard')]")
    private WebElement dashboardMenu;

    @FindBy(xpath = "//div/h4[contains(text(),'Total Sales')]")
    private WebElement totalSales;

    @FindBy(xpath = "//div/h4[contains(text(),'Total Orders')]")
    private WebElement totalOrders;

    @FindBy(xpath = "//div/h4[contains(text(),'Total Products')]")
    private WebElement totalProducts;

    @FindBy(xpath = "//div/h4[contains(text(),'Total Customers')]")
    private WebElement totalCustomer;

    public boolean verifyDashboard(){
        getWait().until(ExpectedConditions.visibilityOf(titlePage));
        return titlePage.isDisplayed();
    }

    public boolean verifyMenu(){
        return dashboardMenu.isDisplayed() && totalSales.isDisplayed() && totalOrders.isDisplayed() && totalCustomer.isDisplayed();
    }

}
