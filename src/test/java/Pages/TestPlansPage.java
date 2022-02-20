package Pages;

import Modals.PlanDetailsModal;
import Modals.TestPlanModal;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

@Log4j2
public class TestPlansPage extends BasePage {
    private final static String TEST_PLANS_URI = System.getenv().getOrDefault("TEST_PLANS_URI", PropertyReader.getProperty("qase.test_plans_uri"));
    private static final By TEST_PLANS_LABEL = By.xpath("//div[contains(@class,'container-fluid')]/h1");
    private static final By CREATE_PLAN = By.id("createButton");
    private static final By TEST_CASES_PAGE_LOCATOR = By.id("tab-test-cases");
    private static final By SUITES_LIST_LOCATOR = By.xpath("//div[contains(@class,'List')]/div/div");
    private static final By CLOSE_PLAN_LOCATOR = By.cssSelector("i[class^='submenu-toggle'");
    private static final String OPEN_PLAN_LOCATOR = "//*[text()='%s']";
    private static final String DROPDOWN_PLAN_LOCATOR = "//a[contains(text(),'%s')]/ancestor::tr//a[contains(@class,'btn-dropdown')]";
    private static final String DELETE_PLAN_LOCATOR = "//a[contains(text(),'%s')]/ancestor::tr//*[text() = 'Delete']";
    private static final By CONFIRM_DELETE = By.cssSelector("button[class$='btn-cancel']");

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
    @Step("Open Test Plans page.")
    public TestPlansPage open() {
        log.info("Open page.");
        driver.get(BASE_URL+TEST_PLANS_URI+PROJECT_ID);
        return this;
    }
    @Step("Click 'Create plan'.")
    public TestPlanModal clickCreatePlanButton() {
        log.info("Click 'Create plan'.");
        driver.findElement(CREATE_PLAN).click();
        return new TestPlanModal(driver);
    }
    @Step("Open plan.")
    public PlanDetailsModal openTestPlan(String title) {
        log.info("Open plan.");
        driver.findElement(By.xpath(String.format(OPEN_PLAN_LOCATOR,title))).click();
        return new PlanDetailsModal(driver);
    }
    @Step("Check, that suites are added.")
    public boolean isTestCaseAdded() {
        log.info("Check, that suites are added");
        driver.findElement(TEST_CASES_PAGE_LOCATOR).click();
        return driver.findElements(SUITES_LIST_LOCATOR).size() != 0;
    }
    @Step("Close test plan.")
    public TestPlansPage closeTestPlanButton() {
        log.info("Close test plan.");
        driver.findElement(CLOSE_PLAN_LOCATOR).click();
        return this;
    }
    @Step("Confirm to delete test plan.")
    public TestPlansPage deleteTestPlan(String title) {
        driver.findElement(By.xpath(String.format(DROPDOWN_PLAN_LOCATOR, title))).click();
        log.info("Delete test plan.");
        driver.findElement(By.xpath(String.format(DELETE_PLAN_LOCATOR, title))).click();
        log.info("Confirm to delete test plan.");
        jsClick(driver.findElement(CONFIRM_DELETE));
        return this;
    }
}
