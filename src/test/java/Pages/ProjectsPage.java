package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProjectsPage extends BasePage {
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

    @Override
    public BasePage open(){
        return this;
    }
}
