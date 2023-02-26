package ui.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.web.pages.CartPage;
import ui.web.pages.LoginPage;
import ui.web.pages.ProductPage;

public class TopBarMenu extends BasePageObject {
    @FindBy(xpath = "//a[text()=' Home']")
    WebElement homeLink;

    @FindBy(xpath = "//a[text()=' Products']")
    WebElement productsLink;

    @FindBy(xpath = "//a[text()=' Cart']")
    WebElement cartLink;

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement loginLink;

    @FindBy(xpath = "//a[text()=' Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "//a[text()=' Logged in as ']")
    WebElement loggedInAs;

    @FindBy(xpath = "//a[text()=' Logged in as ']//b")
    WebElement userName;

    public TopBarMenu() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }

    public void clickHomeLink() {
        homeLink = wait.until(ExpectedConditions.elementToBeClickable(homeLink));
        homeLink.click();
    }

    public ProductPage clickProductsLink() {
        productsLink = wait.until(ExpectedConditions.elementToBeClickable(productsLink));
        productsLink.click();
        return new ProductPage();
    }

    public CartPage clickCartLink() {
        cartLink = wait.until(ExpectedConditions.elementToBeClickable(cartLink));
        cartLink.click();
        return new CartPage();
    }

    public LoginPage clickLoginLink() {
        loginLink = wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
        return new LoginPage();
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
