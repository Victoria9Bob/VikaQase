package Pages;

import Modals.CaseDetailsModal;
import Modals.CaseModal;
import Modals.SuiteEditFormModal;
import Modals.SuiteModal;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RepositoryPage extends BasePage {
    protected final static String REPOSITORY_URL = "https://app.qase.io/project/DEMO?view=1&suite=2";
    private static final By CREATE_CASE = By.id("create-case-button");
    private static final By CREATE_SUITE = By.id("create-suite-button");
    private static final String EDIT_SUITE = "//span[contains(text(),'%s')]//following::button[2]";
    private static final String DELETE_SUITE = "//span[contains(text(),'%s')]//following::button[4]";
    private static final String CONFIRM_DELETE_SUITE = "button[type*='submit']";
    private static final String CANCEL_BUTTON = "Cancel";
    private static final String MAX_WINDOW_BUTTON = "//button[contains(@class,'style_modeBtn-2mioU')]";
    private static final String OPEN_CASE_BUTTON = "//span[contains(text(),'%s')]/ancestor::td";
    private static final String DELETE_CASE_BUTTON = "//div[contains(@class,'caseActions')]/button[2]";
    private static final String DELETE_CASE_CONFIRM = "//div[contains(@class,'modal-footer')]/button[2]";

    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return false;
    }

    @Step("Open repository page")
    @Override
    public RepositoryPage open() {
        log.info("Open page.");
        driver.get(REPOSITORY_URL);
        return this;
    }

    @Step("Click 'Create case'.")
    public CaseModal clickCreateCaseButton() {
        log.info("Click 'Create case'.");
        driver.findElement(CREATE_CASE).click();
        return new CaseModal(driver);
    }

    @Step("Click 'Create Suite'.")
    public SuiteModal clickCreateSuiteButton() {
        log.info("Click 'Create Suite'.");
        driver.findElement(CREATE_SUITE).click();
        return new SuiteModal(driver);
    }

    @Step("Click edit suite button.")
    public SuiteEditFormModal clickEditSuiteButton(String suiteName) {
        log.info("Click edit suite button.");
        driver.findElement(By.xpath(String.format(EDIT_SUITE, suiteName))).click();
        return new SuiteEditFormModal(driver);
    }

    @Step("Delete suite:{suiteName}.")
    public SuiteEditFormModal deleteTestSuite(String suiteName) {
        jsClick(driver.findElement(By.linkText(CANCEL_BUTTON)));
        log.info("Click delete suite button");
        driver.findElement(By.xpath(String.format(DELETE_SUITE, suiteName))).click();
        log.info("Test suite is deleted");
        jsClick(driver.findElement(By.cssSelector(CONFIRM_DELETE_SUITE)));
        return new SuiteEditFormModal(driver);
    }

    @Step("Delete case.")
    public CaseDetailsModal deleteTestCase() {
        log.info("Click delete case button");
        jsClick(driver.findElement(By.xpath(DELETE_CASE_BUTTON)));
        log.info("Test case is deleted");
        jsClick(driver.findElement(By.xpath(DELETE_CASE_CONFIRM)));
        return new CaseDetailsModal(driver);
    }

    @Step("Open case.")
    public CaseDetailsModal openCase(String caseName) {
        log.info("Open Case.");
        driver.findElement(By.xpath(String.format(OPEN_CASE_BUTTON, caseName))).click();
        log.info("Open big window.");
        jsClick(driver.findElement(By.xpath(MAX_WINDOW_BUTTON)));
        return new CaseDetailsModal(driver);
    }
}
