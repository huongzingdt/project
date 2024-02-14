package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    WebDriver driver;
    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver", "F:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
