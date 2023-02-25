package ui.web.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.web.pages.LoginPage;

public class TopBarMenuLogin extends TopBarMenu {
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement loginLink;

    public TopBarMenuLogin() {
    }
    @Override
    public boolean isInTheRightPage() {
        return loginLink.isDisplayed();
    }

    public LoginPage clickLoginLink() {
        loginLink = wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
        return new LoginPage();
    }
}
