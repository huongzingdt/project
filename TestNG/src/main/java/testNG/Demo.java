package testNG;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo {

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "F:\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ce.scipioerp.com/majorleague/control/login");
        driver.manage().window().maximize();
        driver.findElement(By.name("USERNAME")).sendKeys("admin");
        driver.findElement(By.name("PASSWORD")).sendKeys("123456");
        driver.findElement(By.id("field_id__7")).click();
        driver.close();
    }

    @Test
    public void test1(){
        System.setProperty("webdriver.gecko.driver", "F:\\Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://ce.scipioerp.com/majorleague/control/login");
        driver.manage().window().maximize();
    }

    @Test
    public void test2(){
      System.setProperty("webdriver.chrome.driver", "F:\\Driver\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.get("https://demo.automationtesting.in/Windows.html");

      driver.findElement(By.xpath("//a/button")).click();

      for(String windows: driver.getWindowHandles()){
          driver.switchTo().window(windows);
          if(driver.getTitle().equals("Selenium"))
              break;
      }
      driver.findElement(By.xpath("//span[contains(text(),'Downloads')]")).click();
      driver.close();

    }
}
