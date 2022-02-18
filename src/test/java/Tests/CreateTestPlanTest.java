package Tests;

import Models.TestPlans;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.*;

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

        boolean isloggedIn = loginPage.openLoginPage().login(EMAIL, PASSWORD).isPageOpened();
        Assert.assertTrue(isloggedIn);
    }

    @Test(groups = "Regression")
    public void createTestPlanPositive() throws InterruptedException {
        testPlansPage.open().
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
//        Assert
    }
}
