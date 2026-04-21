package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    private By aiStoryVideo = By.xpath("//h3[contains(text(), 'AI Story Video')]");
    private By aiAvatarVideo = By.xpath("//h3[contains(text(), 'AI Avatar Video')]");
    private By aiVideoEditor = By.xpath("//h3[contains(text(), 'AI Video Editor')]");
    private By aiImageVideo = By.xpath("//h3[contains(text(), 'AI Image/Video')]");
    private By titleAIStoryVideo = By.xpath("//span[contains(text(), 'AI Story Video')]");
    private By chatArea = By.tagName("textarea");

    private By buttonGenerateScript = By.xpath(" //*[@id=\"root\"]/div/div[2]/div/div/div/div/div[4]/div[2]/div/div[1]/div[4]/div/button");
    private By lineReadyToGenerate = By.xpath("//span[contains(text(),'Ready to generate. Press the → button in the chat input to proceed.')]");
    private By buttonUseAsIs = By.xpath("//button[contains (text(),'Use as is')]");
    private By ratio = By.xpath("(//button)[13]");
    private By cinematicStyle = By.xpath("(//img)[1]");
    private By narrationVoice = By.xpath("(//button)[18]");
    private By nextToStep02 = By.xpath("//span[contains(text(), 'Next: Generate Key Image')]");

    private By popupClaimReward = By.xpath("//button[contains(text(), '✕')]");


    public boolean verifyLoginSuccess(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(aiStoryVideo));
        return getDriver().findElement(aiAvatarVideo).isDisplayed() && getDriver().findElement(aiVideoEditor).isDisplayed()
                && getDriver().findElement(aiImageVideo).isDisplayed();
    }

    public void configStep1(){
    //Chat and generate the script
        closePopupIfPresent (popupClaimReward);
        clickElement(aiStoryVideo);

        sendKeys(chatArea, "Dog food");
        clickElement(buttonGenerateScript);
        clickElement(buttonUseAsIs);

    //Select the ratio and style
        clickElement(ratio);
        clickElement(cinematicStyle);
   //Select the voice
        clickElement(narrationVoice);
    //Go to step 02
        clickElement(nextToStep02);
    }
}
