package Tests;

import Enums.SuiteParentSuite;
import Models.Suite;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Log4j2
@Listeners(TestListener.class)
public class CreateSuiteTest extends BaseTest {
    @Test
    public void createSuiteWithAllData() throws InterruptedException {
        String suiteName = "1suite";
        String description = "ghkgkig";
        String preconditions = "eljfdw";
        Suite testSuite = Suite.builder().
                suiteName(suiteName).
                parentSuite(SuiteParentSuite.PROJECTS).
                description(description).
                preconditions(preconditions).
                build();

        boolean isloggedIn = loginPage.openLoginPage().login(EMAIL, PASSWORD).isPageOpened();
        Assert.assertTrue(isloggedIn);
        repositoryPage.open()
                .createSuite()
                .fillForm(testSuite)
                .saveSuite();
        Suite actualSuiteDetailsInfo = repositoryPage.editSuiteButton(suiteName).getSuiteDetailsInfo();
        Assert.assertEquals(actualSuiteDetailsInfo, testSuite, "Suite details are not correct");
        repositoryPage.deleteTestSuite(suiteName);
    }
}
