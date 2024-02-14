package pages;

import core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MarketingPage extends BasePage {
    public MarketingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Marketing Campaign')]")
    private WebElement marketingTitle;

    @FindBy(id="field_id__1")
    private WebElement inputCampaignId;

    @FindBy(id="field_id__2")
    private WebElement inputCampaignName;

    @FindBy(id="field_id__3")
    private WebElement inputParentCampaignId;

    @FindBy(id="field_id__4")
    private WebElement statusCampaign;

    @FindBy(id="field_id__5")
    private WebElement findButton;

    @FindBy(xpath = "//a[contains(text(),'Create Marketing Campaign')]")
    private WebElement createMarketButton;

    @FindBy(id="EditMarketingCampaign_marketingCampaignId")
    private WebElement idCamInput;

    @FindBy(id="EditMarketingCampaign_parentCampaignId")
    private WebElement parentCamInput;

    @FindBy(id="EditMarketingCampaign_campaignName")
    private WebElement campNameInput;

    @FindBy(id="EditMarketingCampaign_campaignSummary")
    private WebElement campSummaryInput;

    @FindBy(id="EditMarketingCampaign_budgetedCost")
    private WebElement budgetCostInput;

    @FindBy(id="EditMarketingCampaign_actualCost")
    private WebElement actualCostInput;


    @FindBy(id="EditMarketingCampaign_estimatedCost")
    private WebElement estimateCostInput;


    @FindBy(id="EditMarketingCampaign_convertedLeads")
    private WebElement convertLeadInput;

    @FindBy(id="EditMarketingCampaign_expectedResponsePercent")
    private WebElement expectInput;

    @FindBy(id="EditMarketingCampaign_expectedRevenue")
    private WebElement expectedRevenue;

    @FindBy(id="EditMarketingCampaign_numSent")
    private WebElement numSent;

    @FindBy(xpath="//a[contains(text(),'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//li[contains(text(),'Marketing Campaign created successfully')]")
    private WebElement successText;

    public boolean verifyGotoMarketingPageSuccess(){
        getWait().until(ExpectedConditions.visibilityOf(marketingTitle));
        return inputCampaignName.isDisplayed() && inputParentCampaignId.isDisplayed() && statusCampaign.isDisplayed()
                && inputCampaignId.isDisplayed() && findButton.isDisplayed();
    }

    public void inputNewCamp(){
        getWait().until(ExpectedConditions.visibilityOf(createMarketButton));
        createMarketButton.click();
        getWait().until(ExpectedConditions.visibilityOf(idCamInput));
        idCamInput.sendKeys("900012");
        Select sc = new Select(parentCamInput);
        sc.selectByValue("9002");
        campNameInput.sendKeys("Test");
        campSummaryInput.sendKeys("Test");
        budgetCostInput.sendKeys("12000");
        actualCostInput.sendKeys("10000");
        estimateCostInput.sendKeys("11000");
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", saveButton);

        js.executeScript("document.getElementById('EditMarketingCampaign_fromDate_i18n').value ='2024-01-09 00:00:00.000'");
        js.executeScript("document.getElementById('EditMarketingCampaign_thruDate_i18n').value='2024-01-28 00:00:00.000'");

        convertLeadInput.sendKeys("test");
        expectInput.sendKeys("10");
        expectedRevenue.sendKeys("12345");
        numSent.sendKeys("89");
        js.executeScript("document.getElementById('EditMarketingCampaign_startDate_i18n').value='2024-01-23 00:00:00.000'");
        saveButton.click();
    }

    public boolean verifyCreateCampSuccess(){
        getWait().until(ExpectedConditions.visibilityOf(successText));
        return successText.isDisplayed();
    }
}
