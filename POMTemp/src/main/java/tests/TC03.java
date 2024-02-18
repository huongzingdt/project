package tests;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Catalog;
import pages.LeftMenu;
import pages.LoginPage;

public class TC03 extends BaseTest {

    @Test (priority = 3)
    public void TC03_01(){
        LoginPage loginPage = new LoginPage(getDriver());
        LeftMenu leftMenu = new LeftMenu(getDriver());
        Catalog catalog = new Catalog(getDriver());

        loginPage.navigate("https://fleetcart.envaysoft.com/en/admin/login");
        loginPage.login("admin@email.com", "123456");

        leftMenu.directToProductMenu();
        Assert.assertTrue(leftMenu.verifyContentProduct());
        leftMenu.directToCatalog();
        System.out.println("size of the table:"+ catalog.sizeCatalog());

    }
}
