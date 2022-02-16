package Tests;

import Models.TestPlans;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.*;

@Log4j2
@Listeners(TestListener.class)
public class CreateTestPlanTest extends BaseTest {
    String title = "1plan";
    TestPlans testPlans = new TestPlans();

    @BeforeMethod
    public void setUp() {
        String description = "Testing";
        testPlans = TestPlans.builder().
                title(title).
                description(description).
                build();

        boolean isloggedIn = loginPage.openLoginPage().login(EMAIL, PASSWORD).isPageOpened();
        Assert.assertTrue(isloggedIn);
    }

    @Test
    public void createTestPlanPositive() throws InterruptedException {
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
    }

    @AfterMethod
    public void setOut() {
        testPlansPage.closeTestPlan().deleteTestPlan(title);
//        Assert
    }
}
