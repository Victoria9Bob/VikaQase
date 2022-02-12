package Pages;

import Modals.CaseDetailsModal;
import Modals.CaseModal;
import Modals.SuiteEditFormModal;
import Modals.SuiteModal;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RepositoryPage extends BasePage {
    private String repositoryURL = "https://app.qase.io/project/DEMO?view=1&suite=2";
    final By CREATE_CASE = By.id("create-case-button");
    final By CREATE_SUITE = By.id("create-suite-button");
    private String EDIT_SUITE = "//span[contains(text(),'%s')]//following::button[2]";
    private String DELETE_SUITE = "//span[contains(text(),'%s')]//following::button[4]";
    private String CONFIRM_DELETE_SUITE = "button[type*='submit']";
    private String CANCEL_BUTTON = "Cancel";
    private String MAX_WINDOW_BUTTON = "//button[contains(@class,'style_modeBtn-2mioU')]";
    private String OPEN_CASE_BUTTON = "//span[contains(text(),'%s')]/ancestor::td";
    private String DELETE_CASE_BUTTON = "//div[contains(@class,'caseActions')]/button[2]";
    private String DELETE_CASE_CONFIRM = "//div[contains(@class,'modal-footer')]/button[2]";

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

    @Override
    public RepositoryPage open() {
        driver.get(repositoryURL);
        log.info("Open page.");
        return this;
    }

    public CaseModal createCase() {
        driver.findElement(CREATE_CASE).click();
        log.info("Click 'Create case'.");
        return new CaseModal(driver);
    }

    public SuiteModal createSuite() {
        driver.findElement(CREATE_SUITE).click();
        log.info("Click 'Create Suite'.");
        return new SuiteModal(driver);
    }


    public SuiteEditFormModal editSuiteButton(String suiteName) {
        driver.findElement(By.xpath(String.format(EDIT_SUITE, suiteName))).click();
        log.info("Click edit suite button");
        return new SuiteEditFormModal(driver);
    }

    public SuiteEditFormModal deleteTestSuite(String suiteName) {
        jsClick(driver.findElement(By.linkText(CANCEL_BUTTON)));
        driver.findElement(By.xpath(String.format(DELETE_SUITE, suiteName))).click();
        log.info("Click delete suite button");
        jsClick(driver.findElement(By.cssSelector(CONFIRM_DELETE_SUITE)));
        log.info("Test suite is deleted");
        return new SuiteEditFormModal(driver);
    }

    public CaseDetailsModal deleteTestCase() {
        jsClick(driver.findElement(By.xpath(DELETE_CASE_BUTTON)));
        log.info("Click delete case button");
        jsClick(driver.findElement(By.xpath(DELETE_CASE_CONFIRM)));
        log.info("Test case is deleted");
        return new CaseDetailsModal(driver);
    }


    public CaseDetailsModal openCase(String caseName) {
        driver.findElement(By.xpath(String.format(OPEN_CASE_BUTTON, caseName))).click();
        log.info("Open Case.");
        jsClick(driver.findElement(By.xpath(MAX_WINDOW_BUTTON)));
        log.info("Open big window.");
        return new CaseDetailsModal(driver);
    }
}
