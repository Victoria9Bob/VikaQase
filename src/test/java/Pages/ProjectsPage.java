package Pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class ProjectsPage extends BasePage {
    protected final static String PROJECTS_URL = "https://app.qase.io/projects";;
    protected final static By ADD_FILTER_BUTTON = By.className("add-filter-button");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(ADD_FILTER_BUTTON);
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return false;
    }

    @Step("Open projects page.")
    @Override
    public BasePage open() {
        log.info("Open projects page.");
        driver.get(PROJECTS_URL);
        return this;
    }
}
