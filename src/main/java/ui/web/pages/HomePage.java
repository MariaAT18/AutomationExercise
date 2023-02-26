package ui.web.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import ui.BasePageObject;
import ui.web.components.TopBarMenu;
import utils.LoggerManager;

public class HomePage extends BasePageObject {
    private static final LoggerManager log = LoggerManager.getInstance();
    private TopBarMenu topBarMenu;
    public HomePage() {
        log.info("Entering to HomePage");
        PageFactory.initElements(driver, this);
        topBarMenu = new TopBarMenu();
    }

    public TopBarMenu getTopBarMenu() {
        return topBarMenu;
    }
    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }
}
