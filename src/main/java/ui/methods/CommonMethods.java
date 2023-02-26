package ui.methods;

import ui.PageTransporter;
import ui.web.components.TopBarMenu;
import utils.LoggerManager;

public class CommonMethods {
    private static final LoggerManager log = LoggerManager.getInstance();
    private static final PageTransporter pageTransporter = PageTransporter.getInstance();
    private static TopBarMenu topBarMenu = new TopBarMenu();

    public static void logout() {
        log.info("Logout of the page");
            topBarMenu.logout();
    }
}
