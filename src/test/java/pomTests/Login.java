package pomTests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Login extends BaseTest{
    @Test(priority = 1)
    public void  login() throws Exception {
    	
        lp.enterUserName(prop.getProperty("un"));
        log.info("Enter username");
        lp.enterPassword(prop.getProperty("pwd"));
        log.info("Enter password");
        lp.clickLoginButton();
        log.info("Click on login button");
        lp.clickLogout();
    }

//    @Test(priority = 2)
//    public void logout() {
//        lp.clickLogout();
//        log.info("Click on logout");
//
//    }

    @Test
    public void verifyTitle() {

        Assert.assertTrue(lp.getAppTitle().contains(""), "validation of application title");
    }

    @Test
    public void verifyLogo() {

        Assert.assertTrue(lp.verifyAppLogo(), "validation of application Logo");
    }
}
