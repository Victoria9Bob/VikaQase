package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {
    private String ProjectsURL = "https://app.qase.io/projects";
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

    @Override
    public BasePage open() {
        driver.get(ProjectsURL);
        return this;
    }

    public void createNewProjectButton() {
        driver.findElement(CREATE_NEW_PROJECT).click();
    }

    public void createProject() {
        driver.findElement(SAVE_PROJECT).click();
    }
}
