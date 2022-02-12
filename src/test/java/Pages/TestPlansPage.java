package Pages;

import Modals.PlanDetailsModal;
import Modals.TestPlanModal;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestPlansPage extends BasePage {
    String testPlansURL = "https://app.qase.io/plan/DEMO";
    final By TEST_PLANS_LABEL = By.xpath("//div[contains(@class,'container-fluid')]/h1");
    final By CREATE_PLAN = By.id("createButton");
    final By TEST_CASES_PAGE_LOC = By.id("tab-test-cases");
    final By SUITES_LIST_LOC = By.xpath("//div[contains(@class,'List')]/div/div");
    final By CLOSE_PLAN_LOC = By.cssSelector("i[class^='submenu-toggle'");
    String open_plan_loc = "//*[text()='%s']";
    String drobdown_plan_loc = "//a[contains(text(),'%s')]/ancestor::tr//a[contains(@class,'btn-dropdown')]";
    String delete_plan_loc = "//a[contains(text(),'%s')]/ancestor::tr//*[text() = 'Delete']";
    final By CONFIRM_DELETE = By.cssSelector("button[class$='btn-cancel']");
    public TestPlansPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(TEST_PLANS_LABEL);
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return false;
    }

    @Override
    public TestPlansPage open() {
        driver.get(testPlansURL);
        log.info("Open page.");
        return this;
    }

    public TestPlanModal createPlan() {
        driver.findElement(CREATE_PLAN).click();
        log.info("Click 'Create plan'.");
        return new TestPlanModal(driver);
    }

    public PlanDetailsModal openTestPlan(String title) {
        driver.findElement(By.xpath(String.format(open_plan_loc,title))).click();
        log.info("Open plan.");
        return new PlanDetailsModal(driver);
    }

    public boolean isTestCaseAdded() {
        driver.findElement(TEST_CASES_PAGE_LOC).click();
        log.info("Check, that suites are added");
        return driver.findElements(SUITES_LIST_LOC).size() != 0;
    }

    public TestPlansPage closeTestPlan() {
        driver.findElement(CLOSE_PLAN_LOC).click();
        log.info("Close test plan.");
        return this;
    }

    public TestPlansPage deleteTestPlan(String title) {
        driver.findElement(By.xpath(String.format(drobdown_plan_loc, title))).click();
        driver.findElement(By.xpath(String.format(delete_plan_loc, title))).click();
        log.info("Delete test plan.");
        jsClick(driver.findElement(CONFIRM_DELETE));
        log.info("Confirm delete test plan.");
        return this;
    }
}
