package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver","F:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

     @AfterMethod
    public void afterSuite() {
         if (null != driver) {
            driver.close();
         }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
