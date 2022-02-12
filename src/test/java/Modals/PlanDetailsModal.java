package Modals;

import Models.TestPlans;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PlanDetailsModal extends BaseModal {
    final By TITLE_LOC = By.xpath("//div[contains(@class,'plan')]/h1");
    final By DESCRIPTION_LOC = By.xpath("//div[contains(@class,'markdown-area')]//div/p");

    public PlanDetailsModal(WebDriver driver) {
        super(driver);
    }

    public TestPlans getPlanDetailsInfo() {
        TestPlans testPlans = new TestPlans();
        String title = driver.findElement(TITLE_LOC).getText();
        if (title != null) {
            log.info("Get value from title");
            testPlans.setTitle(title);
        }
        String description = driver.findElement(DESCRIPTION_LOC).getText();
        if (description != null) {
            log.info("Get value from description");
            testPlans.setDescription(description);
        }
        return testPlans;
    }
}