package ui.web.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import ui.BasePageObject;
import ui.web.components.TopBarMenuLogin;
import utils.LoggerManager;

public class LandingPage extends BasePageObject {
    private static final LoggerManager log = LoggerManager.getInstance();
    public TopBarMenuLogin topHeader;

    public LandingPage() {
        log.info("Entering to Landing Page");
        PageFactory.initElements(driver, this);
        topHeader = new TopBarMenuLogin();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }

    public TopBarMenuLogin getTopHeader() {
        return topHeader;
    }
}
