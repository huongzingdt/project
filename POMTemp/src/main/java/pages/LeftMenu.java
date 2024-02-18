package pages;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeftMenu extends BasePage {
    public LeftMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li//a//span[contains(text(),'Products')]")
    private WebElement productMenu;

    @FindBy(xpath = "//li//a//span[contains(text(),'Catalog')]")
    private WebElement catalog;

    @FindBy(xpath = "//li//a//span[contains(text(),'Categories')]")
    private WebElement categories;

    public void directToProductMenu(){
        getWait().until(ExpectedConditions.visibilityOf(productMenu));
        productMenu.click();
        getWait().until(ExpectedConditions.visibilityOf(catalog));
    }
    public boolean verifyContentProduct(){
        return catalog.isDisplayed() && categories.isDisplayed();
    }

    public void directToCatalog(){
        catalog.click();
    }
}
