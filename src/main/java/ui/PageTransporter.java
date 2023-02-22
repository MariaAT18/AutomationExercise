package ui;

import gui.framework.EnvironmentManager;
import gui.framework.selenium.DriverManager;
import org.openqa.selenium.WebDriver;
import ui.web.pages.LandingPage;
import utils.LoggerManager;

public class PageTransporter {
    private static final LoggerManager log = LoggerManager.getInstance();
    private static final EnvironmentManager environmentManager = EnvironmentManager.getInstance();

    private WebDriver driver;
    private String websiteURL;
    private static PageTransporter instance;

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {
        log.info("Initializing Page Transporter");
        websiteURL = environmentManager.getBaseURL();
        driver = DriverManager.getInstance().getWebDriver();
    }

    private void goToURL(String url) {
        driver.navigate().to(url);
    }

    public boolean isOnLandingPage() {
        return driver.getCurrentUrl().contains(websiteURL);
    }

    public LandingPage navigateToLandingPage() {
        if (!isOnLandingPage()) {
            goToURL(websiteURL);
        }
        return new LandingPage();
    }
}
