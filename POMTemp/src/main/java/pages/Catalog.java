package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Catalog extends BasePage {
    public Catalog(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "DataTables_Table_0")
    private WebElement catalogTable;

    @FindBy(xpath = "//table//tr")
    private List<WebElement> lsCatalog;

    public int sizeCatalog(){
       getWait().until(ExpectedConditions.visibilityOf(catalogTable));
       return lsCatalog.size();
    }

}
