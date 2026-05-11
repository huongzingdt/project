package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ImageGenerate extends BasePage {
    public ImageGenerate(WebDriver driver) {
        super(driver);
    }

    private By imageVideoGenerate = By.xpath("//div[@class='feature-card-grid']/div[4]");
    private By textEditor = By.xpath("//textarea");
    private By firstImageSample = By.xpath("(//img)[14]");
    private By buttnUseThisPrompt = By.xpath("//button[contains (text(), 'Use this prompt')]");
    private By buttnGenerate = By.xpath("//button//span[contains (text(), 'Generate')]");
    private By loadingImage = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[5]/div[1]/div/div[1]/span");
    private By firstElement = By.xpath("(//div[contains(@style, 'cursor: pointer') and contains(@style, 'position: absolute')])[2]");

    public void generateImageVideoSample(){
        clickElement(imageVideoGenerate);
        waitForPageLoad();
        clickElement(firstElement);
        waitForPageLoad();
        clickElement(buttnUseThisPrompt);
        waitForPageLoad();
        clickWithRetry(buttnGenerate, 3);
        waitForPageLoad();
        waitForImageGenerating(loadingImage);
    }

    public void sendText(By by, String prompt){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(textEditor));
        getDriver().findElement(textEditor).sendKeys(prompt);
    }



}
