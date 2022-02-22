package modals;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class SelectTestCasesModal extends BaseModal {
    private final static By SUITES_COLUMN_LOCATOR = By.className("suite");
    private final static By DONE_BUTTON_LOCATOR = By.id("select-cases-done-button");
    private final static String CHECKBOX_LOCATOR = "//input[contains(@name,'suite-%s')]/following-sibling::span";

    public SelectTestCasesModal(WebDriver driver) {
        super(driver);
    }

    @Step("Select suites.")
    public SelectTestCasesModal selectCases() {
        List<WebElement> suitesColomnList = driver.findElements(SUITES_COLUMN_LOCATOR);
        log.info("Find -" + suitesColomnList.size() + " suites.");
        for (int i = 0; i < suitesColomnList.size(); i++) {
            log.info("Select suite -" + i);
            driver.findElement(By.xpath(String.format(CHECKBOX_LOCATOR, i))).click();
        }
        return this;
    }

    public TestPlanModal clickDoneButton() {
        log.info("Click done button");
        jsClick(driver.findElement(DONE_BUTTON_LOCATOR));
        return new TestPlanModal(driver);
    }
}
