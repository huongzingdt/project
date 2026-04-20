package pages;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[contains(text(), 'AI Story Video')]")
    private WebElement aiStoryVideo;

    @FindBy(xpath = "//h3[contains(text(), 'AI Avatar Video')]")
    private WebElement aiAvatarVideo;

    @FindBy(xpath = "//h3[contains(text(), 'AI Video Editor')]")
    private WebElement aiVideoEditor;

    @FindBy(xpath = "//h3[contains(text(), 'AI Image/Video')]")
    private WebElement aiImageVideo;

    @FindBy(xpath = "//span[contains(text(), 'AI Story Video')]")
    private WebElement titleAIStoryVideo;

    @FindBy(tagName = "textarea")
    private WebElement chatArea;

    @FindBy(xpath = "(//button)[12]")
    private WebElement buttonGenerateScript;

    @FindBy(xpath = "//span[contains(text(),'Ready to generate. Press the → button in the chat input to proceed.')]")
    private WebElement lineReadyToGenerate;

    @FindBy(xpath = "//button[contains (text(),'Use as is')]")
    private WebElement buttonUseAsIs;

    @FindBy(xpath = "(//button)[13]")
    private WebElement ratio;

    @FindBy(xpath = "(//img)[1]")
    private WebElement cinematicStyle;

    @FindBy(xpath = "(//button)[18]")
    private WebElement narrationVoice;

    @FindBy(xpath = "//span[contains(text(), 'Next: Generate Key Image')]")
    private WebElement nextToStep02;

    public boolean verifyLoginSuccess(){
        getWait().until(ExpectedConditions.visibilityOf(aiStoryVideo));
        return aiStoryVideo.isDisplayed() && aiAvatarVideo.isDisplayed() && aiVideoEditor.isDisplayed() && aiImageVideo.isDisplayed();
    }

    public void configStep1(){
    //Chat and generate the script
        getWait().until(ExpectedConditions.visibilityOf(aiStoryVideo));
        aiStoryVideo.click();
        getWait().until(ExpectedConditions.visibilityOf(titleAIStoryVideo));
        chatArea.click();
        chatArea.sendKeys("Dog food" + Keys.ENTER);
        getWait().until(ExpectedConditions.visibilityOf(lineReadyToGenerate));

        buttonGenerateScript.click();
        getWait().until(ExpectedConditions.visibilityOf(buttonUseAsIs));
        buttonUseAsIs.click();
    //Select the ratio and style
        getWait().until(ExpectedConditions.visibilityOf(ratio));
        ratio.click();
        getWait().until(ExpectedConditions.visibilityOf(cinematicStyle));
        cinematicStyle.click();
   //Select the voice
        getWait().until(ExpectedConditions.visibilityOf(narrationVoice));
        narrationVoice.click();

    //Go to step 02
        getWait().until(ExpectedConditions.visibilityOf(nextToStep02));
        nextToStep02.click();

    }
}
