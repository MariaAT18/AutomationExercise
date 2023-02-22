package ui.web.components;

import entities.CheckoutItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import ui.BasePageObject;

import java.util.ArrayList;
import java.util.List;

public class CheckoutTableSection extends BasePageObject {
    WebElement totalAmount;
    private List<CheckoutItem> checkoutItems;

    public CheckoutTableSection() {
        checkoutItems = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector("div.cart_info tr"));
        elements.remove(0);
        elements.remove(elements.size() - 1);
        for (WebElement element : elements) {
            checkoutItems.add(new CheckoutItem(element));
        }

        List<WebElement> priceElements = driver.findElements(By.cssSelector("p.cart_total_price"));
        totalAmount = priceElements.get(priceElements.size() - 1);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {

    }

    public CheckoutItem findItem(String productName) {
        for (CheckoutItem checkoutItem : checkoutItems) {
            if (checkoutItem.getDescription().equals(productName)) {
                return checkoutItem;
            }
        }
        return null;
    }

    public String getTotalAmount() {
        return totalAmount.getText();
    }

    public List<CheckoutItem> getCheckoutItems() {
        return checkoutItems;
    }

}
