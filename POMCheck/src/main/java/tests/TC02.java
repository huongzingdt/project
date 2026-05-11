package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Payment;

public class TC02 extends BaseTest {
    @Test
     public void buyBasic() {
        //Login page
        //Go to Payment page
        //Buy success BASIC, STANDARD, PRO, ULTIMATE
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateUrl("https://bodapark.ai/");

        Payment payment = new Payment(getDriver());
        payment.buyPackage("Basic");
        payment.buyPackage("Standard");
        payment.buyPackage("Pro");
        payment.buyPackage("Ultimate");
    }
}
