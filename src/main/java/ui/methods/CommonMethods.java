package ui.methods;

import ui.PageTransporter;
import ui.web.components.TopBarMenuAuthenticated;
import utils.LoggerManager;

public class CommonMethods {
    private static final LoggerManager log = LoggerManager.getInstance();
    private static final PageTransporter pageTransporter = PageTransporter.getInstance();
    private static TopBarMenuAuthenticated topBarMenuAuthenticated = new TopBarMenuAuthenticated();

    public static void logout() {
        log.info("Logout of the page");
        if (topBarMenuAuthenticated.isInTheRightPage()) {
            topBarMenuAuthenticated.logout();
        }
    }
}
