package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MarketingPage;

import java.util.ArrayList;
import java.util.List;

public class TC04 extends BaseTest {
    @Test
    public void tc04(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateUrl("https://ce.scipioerp.com/crm");
        loginPage.login("admin", "scipio");
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.verifyLoginSuccess());
        dashboardPage.gotoMarketing();

        MarketingPage marketingPage = new MarketingPage(getDriver());
        Assert.assertTrue(marketingPage.verifyGotoMarketingPageSuccess());

        marketingPage.inputNewCamp();
        marketingPage.verifyCreateCampSuccess();

    }
}
