package Tests;

import Models.TestPlans;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Log4j2
@Listeners(TestListener.class)
public class CreateTestPlanTest extends BaseTest{
    @Test
    public void createTestPlanPositive() throws InterruptedException {
        String title = "1plan";
        String description = "Testing";
        TestPlans testPlans = TestPlans.builder().
                title(title).
                description(description).
                build();

        boolean isloggedIn = loginPage.openLoginPage().login(EMAIL, PASSWORD).isPageOpened();
        Assert.assertTrue(isloggedIn);
        log.info("Signed in.");
        testPlansPage.open().
                createPlan().
                fillForm(testPlans).
                addCases().
                selectCases().
                clickDoneButton().
                savePlan();

        TestPlans actualPlanDetailsInfo = testPlansPage.openTestPlan(title).getPlanDetailsInfo();
        Assert.assertEquals(actualPlanDetailsInfo, testPlans, "Plan details are not correct");
        testPlansPage.isTestCaseAdded();
        testPlansPage.closeTestPlan().deleteTestPlan(title);

    }
}
