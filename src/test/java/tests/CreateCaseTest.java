package tests;

import com.github.javafaker.Faker;
import enums.*;
import models.Case;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CreateCaseTest extends BaseTest {
    Faker faker = new Faker();
    private final String caseName = faker.name().title();
    Case testCase = new Case();

    @BeforeMethod(groups = "Smoke")
    public void setUp() {
        testCase = Case.builder().
                title(caseName).
                status(CaseStatus.DEPRECATED).
                description(faker.chuckNorris().fact()).
                suite(CaseSuite.TEST_CASES_WITHOUT_SUITE).
                severity(CaseSeverity.BLOCKER).
                priority(CasePriority.LOW).
                type(CaseType.OTHER).
                layer(CaseLayer.UNKNOWN).
                isFlaky(CaseIsFlaky.NO).
                milestone(CaseMilestone.RELEASE_1_0).
                behavior(CaseBehavior.NOT_SET).
                automationStatus(CaseAutomationStatus.NOT_AUTOMATED).
                pre_conditions(faker.color().name()).
                post_conditions(faker.color().name()).
                action(faker.harryPotter().book()).
                inputData(faker.harryPotter().spell()).
                expectedResult(faker.harryPotter().character()).
                build();
    }

    @Test(groups = "Smoke")
    public void createCaseWithAllData() throws InterruptedException {
        boolean isloggedIn = loginPage.open().login(EMAIL, PASSWORD).isPageOpened();
        Assert.assertTrue(isloggedIn);
        repositoryPage.open(PROJECT_ID).
                clickCreateCaseButton().
                fillForm(testCase).
                clickSaveCaseButton();
        Case actualCaseDetailsInfo = repositoryPage.openCase(caseName).getCaseDetailsInfo(caseName);
        Assert.assertEquals(actualCaseDetailsInfo, testCase, "Suite details are not correct");

    }

    @AfterMethod(groups = "Smoke")
    public void setOut() {
        repositoryPage.deleteTestCase();
    }
}
