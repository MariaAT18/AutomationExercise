package ui.web.components;

import entities.CartItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import ui.BasePageObject;

import java.util.ArrayList;
import java.util.List;

public class TableShoppingSection extends BasePageObject {
    private List<CartItem> cartItems;

    public TableShoppingSection() {
        cartItems = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector("div.cart_info tr"));
        boolean skipHeader = true;
        for (WebElement element : elements) {
            if(skipHeader) {
                skipHeader = false;
                continue;
            }
            cartItems.add(new CartItem(element));
        }
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public CartItem findItem(String productName) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getDescription().equals(productName)) {
                return cartItem;
            }
        }
        return null;
    }
}
