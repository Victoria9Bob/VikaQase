package Pages;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {
    protected final static String ProjectsURL = "https://app.qase.io/projects";
    public static final By CREATE_NEW_PROJECT = By.id("createButton");
    public static final By SAVE_PROJECT = By.linkText("Create project");
    final By ADD_FILTER_BUTTON = By.className("add-filter-button");

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

    @Step("Open page.")
    @Link(ProjectsURL)
    @Override
    public BasePage open() {
        driver.get(ProjectsURL);
        return this;
    }
}
