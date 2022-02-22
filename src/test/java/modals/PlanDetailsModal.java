package modals;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestPlans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PlanDetailsModal extends BaseModal {
    private final static By TITLE_LOCATOR = By.xpath("//div[contains(@class,'plan')]/h1");
    private final static By DESCRIPTION_LOCATOR = By.xpath("//div[contains(@class,'markdown-area')]//div/p");

    public PlanDetailsModal(WebDriver driver) {
        super(driver);
    }

    @Step("Get test plan details info.")
    public TestPlans getPlanDetailsInfo() {
        TestPlans testPlans = new TestPlans();
        log.info("Get value from title");
        String title = driver.findElement(TITLE_LOCATOR).getText();
        if (title != null) {
            testPlans.setTitle(title);
        }

        log.info("Get value from description");
        String description = driver.findElement(DESCRIPTION_LOCATOR).getText();
        if (description != null) {
            testPlans.setDescription(description);
        }
        return testPlans;
    }
}