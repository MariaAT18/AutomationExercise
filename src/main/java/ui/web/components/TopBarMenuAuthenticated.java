package ui.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.web.pages.LoginPage;

public class TopBarMenuAuthenticated extends TopBarMenu {
    private static final String USER_NAME = "//a[contains(.,'<username>')]";

    @FindBy(xpath = "//a[text()=' Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "//a[text()=' Logged in as ']")
    WebElement loggedInAs;

    @FindBy(xpath = "//a[text()=' Logged in as ']//b")
    WebElement userName;

    @Override
    public boolean isInTheRightPage() {
        return loggedInAs.isDisplayed();
    }

    public void clickLogoutLink() {
        logoutLink = wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }

    public boolean isTheLogoutLinkDisplayed() {
        return driver.findElement(By.xpath("//a[text()=' Logout']")).isDisplayed();
    }

    public String getUserName() {
        return userName.getText();
    }

    public LoginPage logout() {
        clickLogoutLink();
        return new LoginPage();
    }
}
