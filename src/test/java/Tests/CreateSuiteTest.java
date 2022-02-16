package Tests;

import Enums.SuiteParentSuite;
import Models.Suite;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.*;

@Log4j2
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
                .createSuite()
                .fillForm(testSuite)
                .saveSuite();
        Suite actualSuiteDetailsInfo = repositoryPage.editSuiteButton(suiteName).getSuiteDetailsInfo();
        Assert.assertEquals(actualSuiteDetailsInfo, testSuite, "Suite details are not correct");

    }

    @AfterMethod
    public void setOut() {
        repositoryPage.deleteTestSuite(suiteName);
//        Assert
    }
}
