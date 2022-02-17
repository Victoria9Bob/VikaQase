package Tests;

import Enums.*;
import Models.Case;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class CreateCaseTest extends BaseTest {
    Faker faker = new Faker();
    Case testCase = new Case();
    String caseName = faker.name().title();



    @BeforeMethod
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
        boolean isloggedIn = loginPage.openLoginPage().login(EMAIL, PASSWORD).isPageOpened();
        Assert.assertTrue(isloggedIn);
    }

    @Test
    public void createCaseWithAllData() throws InterruptedException {
        repositoryPage.open().
                clickCreateCaseButton().
                fillForm(testCase).
                clickSaveCaseButton();
        Case actualCaseDetailsInfo = repositoryPage.openCase(caseName).getCaseDetailsInfo(caseName);
        Assert.assertEquals(actualCaseDetailsInfo, testCase, "Suite details are not correct");

    }

    @AfterMethod
    public void setOut() {
        repositoryPage.deleteTestCase();
//       Написать Assert
    }
}
