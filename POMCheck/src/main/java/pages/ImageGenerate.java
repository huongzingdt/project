package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImageGenerate extends BasePage {
    public ImageGenerate(WebDriver driver) {
        super(driver);
    }

    private By imageVideoGenerate = By.xpath("//div[@class='feature-card-grid']/div[4]");
    private By textEditor = By.xpath("//textarea");


}
