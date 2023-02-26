package ui.web.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.web.components.TableShoppingSection;

public class CartPage extends BasePageObject {
    private TableShoppingSection tableShoppingSection;

    @FindBy(css = "div.breadcrumbs li.active")
    WebElement shoppingCartLabel;

    @FindBy(css = "a.check_out")
    WebElement checkoutLink;

    @FindBy(css = "span#empty_cart p b")
    WebElement textCartEmptyMessage;

    @FindBy(css = "span#empty_cart p a")
    WebElement hereLink;

    public CartPage() {
        waitUntilPageObjectIsLoaded();
        this.tableShoppingSection = new TableShoppingSection();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        wait.until(ExpectedConditions.visibilityOf(shoppingCartLabel));
    }

    public TableShoppingSection getTableShoppingSection() {
        return tableShoppingSection;
    }

    public CheckoutPage clickProceedToCheckoutButton() {
        checkoutLink.click();
        return new CheckoutPage();
    }

    public String getCartIsEmptyTextMessage() {
        return textCartEmptyMessage.getText();
    }

    public ProductPage getHereLink() {
        hereLink.click();
        return new ProductPage();
    }
}
