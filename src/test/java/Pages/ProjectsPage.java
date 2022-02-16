package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.get(PROJECTS_URL);
        return this;
    }
}
