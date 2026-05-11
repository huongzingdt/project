package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TC01 extends BaseTest {
    @Test
    public void doStoryBoard() throws InterruptedException {
        //Login vào dashboard
        //Verify login success then go to the Dashboad page
        //Config Story Board - BLOCK cause having many update UI feature Story Board
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateUrl("https://bodapark.ai/");
  //     loginPage.login("dohuong8888@gmail.com", "05101988dothihuong");

       DashboardPage dashboardPage = new DashboardPage(getDriver());
       Assert.assertTrue(dashboardPage.verifyLoginSuccess());
       dashboardPage.configStep1();

    }
}
