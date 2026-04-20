package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Collections;

public class BaseTest {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

// Chú ý: Dùng dấu / và thêm -- trước tham số
       // options.addArguments("--user-data-dir=C:/Users/Admin/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--user-data-dir=C:/ChromeTest");
        options.addArguments("--profile-directory=Profile 8");

// Các flag bắt buộc để sửa lỗi DevToolsActivePort
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-software-rasterizer");

// Bypass bot detection
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        try {
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterSuite
    public void afterSuite(){
        if(null != driver)
            driver.close();
    }
}
