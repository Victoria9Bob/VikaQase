package Tests;

import Enums.SuiteParentSuite;
import Models.Suite;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class CreateSuiteTest extends BaseTest {
    String suiteName = "1suite";
    Suite testSuite = new Suite();

    @BeforeMethod
    public void setUp() {
        String description = "ghkgkig";
        String preconditions = "eljfdw";
        testSuite = Suite.builder().
                suiteName(suiteName).
                parentSuite(SuiteParentSuite.PROJECTS).
                description(description).
                preconditions(preconditions).
                build();

        boolean isloggedIn = loginPage.openLoginPage().login(EMAIL, PASSWORD).isPageOpened();
        Assert.assertTrue(isloggedIn);
    }

    @Test
    public void createSuiteWithAllData() throws InterruptedException {
        repositoryPage.open()
                .clickCreateSuiteButton()
                .fillForm(testSuite)
                .clickSaveSuite();
        Suite actualSuiteDetailsInfo = repositoryPage.clickEditSuiteButton(suiteName).getSuiteDetailsInfo();
        Assert.assertEquals(actualSuiteDetailsInfo, testSuite, "Suite details are not correct");

    }

    @AfterMethod
    public void setOut() {
        repositoryPage.deleteTestSuite(suiteName);
//        Assert
    }
}
