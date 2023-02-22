package ui.web.components;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.web.pages.CartPage;
import ui.web.pages.ProductPage;

public abstract class TopBarMenu extends BasePageObject {
    @FindBy(xpath = "//a[text()=' Home']")
    WebElement homeLink;

    @FindBy(xpath = "//a[text()=' Products']")
    WebElement productsLink;

    @FindBy(xpath = "//a[text()=' Cart']")
    WebElement cartLink;

    public TopBarMenu() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }

    public abstract boolean isInTheRightPage();

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
}
