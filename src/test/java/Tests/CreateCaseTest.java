package Tests;

import Enums.*;
import Models.Case;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
@Log4j2
public class CreateCaseTest extends BaseTest {
    String caseName = "case2";
    Case testCase = new Case();

    @BeforeMethod
    public void setUp() {
        testCase = Case.builder().
                title(caseName).
                status(CaseStatus.DEPRECATED).
                description("1des").
                suite(CaseSuite.TEST_CASES_WITHOUT_SUITE).
                severity(CaseSeverity.BLOCKER).
                priority(CasePriority.LOW).
                type(CaseType.OTHER).
                layer(CaseLayer.UNKNOWN).
                isFlaky(CaseIsFlaky.NO).
                milestone(CaseMilestone.RELEASE_1_0).
                behavior(CaseBehavior.NOT_SET).
                automationStatus(CaseAutomationStatus.NOT_AUTOMATED).
                pre_conditions("pre").
                post_conditions("post").
                action("Open").
                inputData("login").
                expectedResult("isOpened").
                build();
        boolean isloggedIn = loginPage.openLoginPage().login(EMAIL, PASSWORD).isPageOpened();
        Assert.assertTrue(isloggedIn);
    }

    @Test
    public void createCaseWithAllData() throws InterruptedException {
        repositoryPage.open().
                createCase().
                fillForm(testCase).
                saveCaseButton();
        Case actualCaseDetailsInfo = repositoryPage.openCase(caseName).getCaseDetailsInfo(caseName);
        Assert.assertEquals(actualCaseDetailsInfo, testCase, "Suite details are not correct");

    }

    @AfterMethod
    public void setOut() {
        repositoryPage.deleteTestCase();
//       Написать Assert
    }
}
