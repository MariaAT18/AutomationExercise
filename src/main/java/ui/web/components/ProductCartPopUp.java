package ui.web.components;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.web.pages.CartPage;

public class ProductCartPopUp extends BasePageObject {
    @FindBy(css = "div#cartModal")
    private WebElement modal;

    @FindBy(css = "#cartModal h4")
    private WebElement titlePopup;

    @FindBy(css = "#cartModal div.modal-body p")
    private WebElement message;

    @FindBy(css = "#cartModal div.modal-body a")
    private WebElement viewCart;

    @FindBy(css = "#cartModal div.modal-footer button")
    private WebElement continueShopping;

    public ProductCartPopUp() {
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        modal = wait.until(ExpectedConditions.elementToBeClickable(modal));
    }

    public String getTitlePopup() {
        return titlePopup.getText();
    }

    public String getMessage() {
        return message.getText();
    }

    public CartPage clickOnViewCart() {
        viewCart.click();
        return new CartPage();
    }

    public void clickOnContinueShopping() {
        continueShopping.click();
    }
}
