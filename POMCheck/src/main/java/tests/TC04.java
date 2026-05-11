package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.ImageGenerate;
import pages.LoginPage;

public class TC04 extends BaseTest {

    @Test
    public void useImageSample () {
        //Login page
        //Generate image/video using sample
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateUrl("https://bodapark.ai/");

        ImageGenerate imageGenerate = new ImageGenerate(getDriver());
        imageGenerate.generateImageVideoSample();
    }
}
