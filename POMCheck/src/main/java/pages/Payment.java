package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class Payment extends BasePage {
    public Payment(WebDriver driver) {
        super(driver);
    }

    private By pricingMenu = By.xpath("//div//span[contains(text(), 'Pricing')]");
    private By buyBasic = By.xpath("//div[h3[contains(text(), 'Basic')]]//button");
    private By submitBuyAction = By.xpath("//button/span[contains(text(), 'Pay Now')]");

    private By emailBuyer = By.name("customer_email");
    private By buyByCard = By.xpath("//button/span[contains(text(), 'Card')]");
    private By cardNumber = By.xpath("//div/input[@id='payment-numberInput']");
    private By expiryDateCard = By.id("payment-expiryInput");
    private By cvcCard = By.id("payment-cvcInput");
    private By hoderCard = By.name("customer_name");

    private By myAccountMenu = By.xpath("//div/span[contains(text(), 'My')]");
    private By currentCredit = By.xpath("//div[contains(., 'Credits:')]");



    public void buyBasic(){

            clickElement(pricingMenu);
            clickElement(buyBasic);
            clickElement(submitBuyAction);
            sendKeys(emailBuyer, "dohuong8888@gmail.com");
            getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                    By.xpath("//iframe[contains(@name, 'privateStripeFrame')]")
            ));

            sendKeys(cardNumber, "4242424242424242");
            sendKeys(expiryDateCard, "1228");
            sendKeys(cvcCard, "100");
            getDriver().switchTo().defaultContent();
            sendKeys(hoderCard, "Do Thi Huong");

        WebElement dropdown = getDriver().findElement(By.xpath("//button[@role='combobox']"));
        dropdown.click();

        WebElement option = getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@role, 'option')]//*[contains(text(), 'Alba')]")
        ));

        try {
            option.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click();", option);
        }
            WebElement btnPay = getWait().until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Pay now')]")
            ));
            btnPay.click();

            getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//button[contains(text(), 'Go to Dashboard')]")))).click();
    }

    public void buyPackage(String packageName) {
        clickElement(pricingMenu);
        String packageBtnXpath = String.format("//div[h3[contains(text(), '%s')]]//button", packageName);
        WebElement btnBuy = getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(packageBtnXpath)));
        btnBuy.click();
        clickElement(submitBuyAction);
        sendKeys(emailBuyer, "dohuong8888@gmail.com");
        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[contains(@name, 'privateStripeFrame')]")
        ));
        sendKeys(cardNumber, "4242424242424242");
        sendKeys(expiryDateCard, "1228");
        sendKeys(cvcCard, "100");
        getDriver().switchTo().defaultContent();
        sendKeys(hoderCard, "Do Thi Huong");
        WebElement dropdown = getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@role='combobox']")));
        dropdown.click();
        WebElement option = getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@role, 'option')]//*[contains(text(), 'Alba')]")
        ));

        try {
            option.click();
        } catch (Exception e) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", option);
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement btnPay = getWait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(., 'Pay now')]")
        ));
        btnPay.click();

        getWait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Go to Dashboard')]")
        )).click();
    }

    public double checkCurrentCredit() {
        clickElement(myAccountMenu);
        List<WebElement> elements = getDriver().findElements(By.xpath("//div[contains(., 'Credits:')]"));

        for (WebElement el : elements) {
            String text = el.getText();
            if (text.contains("Credits:") && text.matches(".*\\d+.*") && !text.contains("+")) {
                String cleanNumber = text.replaceAll("[^0-9]", "");
                return Double.parseDouble(cleanNumber);
            }
        }
        return 0;
    }

    public void verifyCreditAdded(String packageName, double expectedAddedAmount){
        double creditBefore = checkCurrentCredit();
        System.out.println("Credit truoc khi mua: " + creditBefore);
        buyPackage(packageName);
        double creditAfter = checkCurrentCredit();
        System.out.println("Credit sau khi mua: " + creditAfter);
        double actualAdded = creditAfter - creditBefore;
        Assert.assertEquals(actualAdded, expectedAddedAmount, "Credit added not correctly");
    }

}
