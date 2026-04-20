package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TC01 extends BaseTest {
    @Test
    public void tc04(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateUrl("https://bodapark.ai/");
       // loginPage.login("dohuong8888@gmail.com", "05101988dothihuong");

       DashboardPage dashboardPage = new DashboardPage(getDriver());
       Assert.assertTrue(dashboardPage.verifyLoginSuccess());
       dashboardPage.configStep1();
//
//        MarketingPage marketingPage = new MarketingPage(getDriver());
//        Assert.assertTrue(marketingPage.verifyGotoMarketingPageSuccess());
//
//        marketingPage.inputNewCamp();
//        marketingPage.verifyCreateCampSuccess();

    }
}
