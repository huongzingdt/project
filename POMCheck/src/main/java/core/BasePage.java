package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }


    // --- Các hàm Wrapper nằm tại đây ---


    public void waitForPageLoad() {
        wait.until(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState").equals("complete"));
    }

    protected void clickElement(By by) {
        // Tìm element ngay trong quá trình wait để đảm bảo lấy được bản thực thể mới nhất trên DOM
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        highlightElement(element);
        element.click();
    }

    protected void sendKeys(By by, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
        element.sendKeys(text);
    }

    private void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }

    public void scrollToElement(By by) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Kết hợp: Cuộn xong rồi mới Click
    public void scrollAndClick(By by) {
        scrollToElement(by);
        clickElement(by);
    }

    public boolean waitForTextToBePresent(By by, String text) {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForElementToDisappear(By by) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            // Xử lý exception nếu cần
        }
    }

    public void setCheckbox(By by, boolean shouldBeChecked) {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(by));
        if (checkbox.isSelected() != shouldBeChecked) {
            checkbox.click();
        }
    }

    public void hoverAndClick(By rootMenuBy, By childMenuBy) {
        Actions action = new Actions(driver);
        WebElement root = wait.until(ExpectedConditions.visibilityOfElementLocated(rootMenuBy));
        action.moveToElement(root).perform(); // Di chuột tới

        // Đợi menu con hiển thị rồi click thông qua locator By
        clickElement(childMenuBy);
    }

    public String getAttribute(By by, String attribute) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getAttribute(attribute);
    }

    public void pressEnter(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(Keys.ENTER);
    }

    public void clickJS(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("Không thể click JS vào: " + by.toString());
        }
    }

    public void clickWithRetry(By by, int attempts) {
        int count = 0;
        while (count < attempts) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(by)).click();
                break;
            } catch (StaleElementReferenceException e) {
                count++;
                System.out.println("Thử lại lần " + count + " do Stale Element...");
            }
        }
    }

    public void switchToFrame(By frameLocator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }


    public void switchToWindowByTitle(String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
    }

    protected void closePopupIfPresent(By by) {
        try {
            // Chỉ đợi nhanh 5 giây để check popup
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement closeBtn = shortWait.until(ExpectedConditions.presenceOfElementLocated(by));
            if (closeBtn.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
                System.out.println("Đã đóng popup bất ngờ: " + by.toString());
            }
        } catch (Exception e) {
            // Không tìm thấy popup thì im lặng chạy tiếp
        }
    }
}
