package ui.web.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import ui.BasePageObject;
import ui.web.components.TopBarMenuAuthenticated;
import utils.LoggerManager;

public class HomePage extends BasePageObject {
    private static final LoggerManager log = LoggerManager.getInstance();
    private TopBarMenuAuthenticated topBarMenuAuthenticated;

    public HomePage() {
        log.info("Entering to HomePage");
        PageFactory.initElements(driver, this);
        topBarMenuAuthenticated = new TopBarMenuAuthenticated();
    }

    public TopBarMenuAuthenticated getTopBarMenuAuthenticated() {
        return topBarMenuAuthenticated;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }
}
