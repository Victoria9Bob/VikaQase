package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    protected static final String VALID_EMAIL = "233vika-5egd@mailinator.com";
    protected static final String VALID_PASSWORD = "S12345Vika";
    protected static final String INVALID_EMAIL = "1235vika-5egd@mailinator";

    @Test(retryAnalyzer = Retry.class)
    public void positiveLoginTest(){
        loginPage.open();
        loginPage.signUp(VALID_EMAIL,VALID_PASSWORD);
        Assert.assertTrue(loginPage.isConfirmMessageDisplayed());
    }
    @Test
    public void negativeLoginTest(){
        loginPage.open();
        loginPage.signUp(INVALID_EMAIL,VALID_PASSWORD);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }
    @AfterMethod
    public void clearCookies(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}