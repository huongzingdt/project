package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public void buyBasic(){

            clickElement(pricingMenu);
            clickElement(buyBasic);
            clickElement(submitBuyAction);

            // 1. Nhập các thông tin ở trang chính trước cho chắc chắn
            sendKeys(emailBuyer, "dohuong8888@gmail.com");

            // 2. Chờ và nhảy vào iframe của Stripe
            // Lưu ý: Đảm bảo By.xpath("//iframe[contains(@name, 'privateStripeFrame')]") trả về đúng 1 kết quả
            getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                    By.xpath("//iframe[contains(@name, 'privateStripeFrame')]")
            ));

            // 3. Nhập dữ liệu bên trong iframe (Dùng chuỗi số liền nhau)
            sendKeys(cardNumber, "4242424242424242");
            sendKeys(expiryDateCard, "1228"); // Thường Stripe chỉ cần MMYY, không cần dấu /
            sendKeys(cvcCard, "100");

            // 4. Thoát khỏi iframe để quay về trang chính
            getDriver().switchTo().defaultContent();
            sendKeys(hoderCard, "Do Thi Huong");

        // Click để mở danh sách
        WebElement dropdown = getDriver().findElement(By.xpath("//button[@role='combobox']"));
        dropdown.click();

        WebElement option = getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@role, 'option')]//*[contains(text(), 'Alba')]")
        ));

// 3. Sử dụng JavaScript để click nếu click thông thường bị chặn
        try {
            option.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click();", option);
        }

        // 5. Click nút Pay Now (Nút này nằm ở trang chính)
            WebElement btnPay = getWait().until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Pay now')]")
            ));
            btnPay.click();

            getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//button[contains(text(), 'Go to Dashboard')]")))).click();
    }

    public void buyPackage(String packageName) {
        // 1. Mở menu Pricing
        clickElement(pricingMenu);

        // 2. Click vào nút "Get 50% Off Now" dựa trên tên gói (Basic, Standard, Pro, Ultimate)
        // XPath này sẽ tìm đúng khối div chứa tên gói và click vào button bên trong đó
        String packageBtnXpath = String.format("//div[h3[contains(text(), '%s')]]//button", packageName);
        WebElement btnBuy = getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(packageBtnXpath)));
        btnBuy.click();

        // Tiếp tục luồng thanh toán
        clickElement(submitBuyAction);
        sendKeys(emailBuyer, "dohuong8888@gmail.com");

        // 3. Xử lý Iframe Stripe
        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[contains(@name, 'privateStripeFrame')]")
        ));

        sendKeys(cardNumber, "4242424242424242");
        sendKeys(expiryDateCard, "1228");
        sendKeys(cvcCard, "100");

        // 4. Thoát Iframe về trang chính
        getDriver().switchTo().defaultContent();

        // Nhập tên chủ thẻ
        sendKeys(hoderCard, "Do Thi Huong");

        // 5. Xử lý Dropdown quốc gia
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

        // 6. Click nút Pay Now và đợi chuyển hướng
        WebElement btnPay = getWait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(., 'Pay now')]")
        ));
        btnPay.click();

        // Đợi và click Go to Dashboard
        getWait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Go to Dashboard')]")
        )).click();
    }
}
