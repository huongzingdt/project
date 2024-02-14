package testNG;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestDemo {
  ThreadLocal<WebDriver> ls = new ThreadLocal<>();
  @BeforeTest
  @Parameters({"Browser"})

  public void beforeTest(String browserName) throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setBrowserName(browserName);
    RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
     ls.set(remoteWebDriver);
  }

  public WebDriver getDriver(){
    return ls.get();
  }
  @Test
  public void test(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");

    getDriver().get("https://demo.worksuite.biz/login");
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("admin@example.com");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("123456");
    getDriver().findElement(By.id("submit-login")).submit();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2/span[contains(text(),'Dashboard')])[1]")));
    Assert.assertEquals(getDriver().getTitle(), "Dashboard");
  }
  @AfterTest
  public void afterTest(){
   ls.remove();
  }

  @Test
  public void test34() throws IOException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"F:\\Driver\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
    WebDriver driver = new PhantomJSDriver(desiredCapabilities);
    driver.get("https://demo.worksuite.biz/login");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().window().maximize();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("admin@example.com");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("123456");
    driver.findElement(By.id("submit-login")).submit();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2/span[contains(text(),'Dashboard')])[1]")));
    Assert.assertEquals(driver.getTitle(), "Dashboard");
    File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(image, new File("F:\\imagedd.png"));
  }
}
