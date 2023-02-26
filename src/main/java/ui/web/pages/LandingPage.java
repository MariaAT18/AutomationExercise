package ui.web.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import ui.BasePageObject;
import ui.web.components.TopBarMenu;
import utils.LoggerManager;

public class LandingPage extends BasePageObject {
    private static final LoggerManager log = LoggerManager.getInstance();

   private TopBarMenu topBarMenu;
    public LandingPage() {
        log.info("Entering to Landing Page");
        PageFactory.initElements(driver, this);
        topBarMenu = new TopBarMenu();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }

    public TopBarMenu getTopHeader() {
        return topBarMenu;
    }
}
