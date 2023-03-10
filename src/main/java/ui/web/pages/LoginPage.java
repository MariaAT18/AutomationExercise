package ui.web.pages;

import gui.framework.EnvironmentManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.BasePageObject;
import ui.web.components.TopBarMenu;
import utils.LoggerManager;

public class LoginPage extends BasePageObject {
    private static final LoggerManager log = LoggerManager.getInstance();
    public TopBarMenu topBarMenu;

    @FindBy(name = "email")
    WebElement emailUserTextBox;

    @FindBy(name = "password")
    WebElement passwordUserTextBox;

    @FindBy(xpath = "//button[text() = 'Login']")
    WebElement loginSubmitButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!")
    WebElement errorMessage;

    public LoginPage() {
        log.info("Entering to Login Page");
        PageFactory.initElements(driver, this);
        topBarMenu = new TopBarMenu();
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }

    public void setEmailUserTextBox(String emailUser) {
        emailUserTextBox.click();
        emailUserTextBox.clear();
        emailUserTextBox.sendKeys(emailUser);
    }

    public void setPasswordUserTextBox(String passwordUser) {
        passwordUserTextBox.click();
        passwordUserTextBox.clear();
        passwordUserTextBox.sendKeys(passwordUser);
    }

    public void clickLoginButton() {
        loginSubmitButton.submit();
    }

    public HomePage loginWithProfileUser(String user) {
        String email = EnvironmentManager.getInstance().getEmail(user);
        String password = EnvironmentManager.getInstance().getPassword(user);
        setEmailUserTextBox(email);
        setPasswordUserTextBox(password);
        clickLoginButton();
        return new HomePage();
    }
}
