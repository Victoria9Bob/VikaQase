package tests;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import models.TestPlans;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Log4j2
@Listeners(TestListener.class)
public class CreateTestPlanTest extends BaseTest {
    Faker faker = new Faker();
    private final String title = faker.name().title();
    TestPlans testPlans = new TestPlans();

    @BeforeMethod(groups = "Regression")
    public void setUp() {
        testPlans = TestPlans.builder().
                title(title).
                description(faker.chuckNorris().fact()).
                build();
    }

    @Test(groups = "Regression")
    public void createTestPlanPositive() throws InterruptedException {
        boolean isloggedIn = loginPage.open().login(EMAIL, PASSWORD).isPageOpened();
        Assert.assertTrue(isloggedIn);
        testPlansPage.open(PROJECT_ID).
                clickCreatePlanButton().
                fillForm(testPlans).
                clickAddCases().
                selectCases().
                clickDoneButton().
                clickSavePlan();

        TestPlans actualPlanDetailsInfo = testPlansPage.openTestPlan(title).getPlanDetailsInfo();
        Assert.assertEquals(actualPlanDetailsInfo, testPlans, "Plan details are not correct");
        testPlansPage.isTestCaseAdded();
    }

    @AfterMethod(groups = "Regression")
    public void setOut() {
        testPlansPage.closeTestPlanButton().deleteTestPlan(title);
    }
}
