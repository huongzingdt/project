package tests;

import core.BaseTest;
import core.FileUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TC01VerifyLogin extends BaseTest {

    @Test(dataProvider = "testdata")
    public void TC02(String url, String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        loginPage.navigate(url);
        loginPage.login(username, password);
        Assert.assertTrue(dashboardPage.verifyDashboard());
        Assert.assertTrue(dashboardPage.verifyMenu());
    }

    @DataProvider(name = "testdata")
    public Object[][] getTestDat(){
        return FileUtil.getTableArray("F:\\data.xlsx", "data", 0, 3);
    }
}

