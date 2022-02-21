package tests;

import com.github.javafaker.Faker;
import enums.SuiteParentSuite;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CreateSuiteTest extends BaseTest {
    Faker faker = new Faker();
    private final String suiteName = faker.name().title();
    Suite testSuite = new Suite();

    @BeforeMethod(groups = "Regression")
    public void setUp() {
        testSuite = Suite.builder().
                suiteName(suiteName).
                parentSuite(SuiteParentSuite.PROJECTS).
                description(faker.chuckNorris().fact()).
                preconditions(faker.funnyName().name()).
                build();
    }

    @Test(groups = "Regression")
    public void createSuiteWithAllData() throws InterruptedException {
        boolean isloggedIn = loginPage.open().login(EMAIL, PASSWORD).isPageOpened();
        Assert.assertTrue(isloggedIn);
        repositoryPage.open()
                .clickCreateSuiteButton()
                .fillForm(testSuite)
                .clickSaveSuite();
        Suite actualSuiteDetailsInfo = repositoryPage.clickEditSuiteButton(suiteName).getSuiteDetailsInfo();
        Assert.assertEquals(actualSuiteDetailsInfo, testSuite, "Suite details are not correct");

    }

    @AfterMethod(groups = "Regression")
    public void setOut() {
        repositoryPage.deleteTestSuite(suiteName);
//        Assert
    }
}
