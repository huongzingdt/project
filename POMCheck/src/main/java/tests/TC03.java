package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Payment;

public class TC03 extends BaseTest {
    @Test
    public void buyBasic() {
        //Login
        //Verify the amount credit be added success

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateUrl("https://bodapark.ai/");

        Payment payment = new Payment(getDriver());
        payment.verifyCreditAdded("Basic", 400);
        payment.verifyCreditAdded("Standard", 1300);
        payment.verifyCreditAdded("Pro", 3000);
        payment.verifyCreditAdded("Ultimate", 6000);
    }
}
