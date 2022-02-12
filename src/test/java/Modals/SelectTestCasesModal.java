package Modals;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class SelectTestCasesModal extends BaseModal {
    final By SUITES_COLOMN_LOC = By.className("suite");
    final By DONE_BUTTON_LOC = By.id("select-cases-done-button");
    String checkbox_LOC = "//input[contains(@name,'suite-%s')]/following-sibling::span";

    public SelectTestCasesModal(WebDriver driver) {
        super(driver);
    }

    public SelectTestCasesModal selectCases() {
        List<WebElement> suitesColomnList = driver.findElements(SUITES_COLOMN_LOC);
        log.info("Find -"+suitesColomnList.size()+" suites.");
        for (int i = 0; i < suitesColomnList.size(); i++) {
                driver.findElement(By.xpath(String.format(checkbox_LOC,i))).click();
                log.info("Select suite -" + i);
            }
        return this;
    }

    public TestPlanModal clickDoneButton(){
        jsClick(driver.findElement(DONE_BUTTON_LOC));
        return new TestPlanModal(driver);
    }
}
