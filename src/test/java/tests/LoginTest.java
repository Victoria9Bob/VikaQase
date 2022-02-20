package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    Faker faker = new Faker();
    protected final String valid_email = faker.internet().emailAddress();
    protected final String valid_password = faker.internet().password(8,10);
    protected static final String INVALID_EMAIL = "1235vika-5egd@mailinator";

    @Test(groups = "Smoke")
    public void positiveLoginTest(){
        loginPage.open();
        loginPage.signUp(valid_email,valid_password);
        Assert.assertTrue(loginPage.isConfirmMessageDisplayed());
    }
    @Test(retryAnalyzer = Retry.class,groups = "Regression")
    public void negativeLoginTest(){
        loginPage.open();
        loginPage.signUp(INVALID_EMAIL,valid_password);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }
    @AfterMethod(groups = "Regression")
    public void clearCookies(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}
