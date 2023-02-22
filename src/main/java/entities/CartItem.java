package entities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartItem {
    private final String description;
    private final String price;
    private final String quantity;
    private final String total;
    private final WebElement deleteItem;

    public CartItem(WebElement elementRow) {
        description = elementRow.findElement(By.cssSelector("td.cart_description h4")).getText();
        price = elementRow.findElement(By.cssSelector("td.cart_price")).getText();
        quantity = elementRow.findElement(By.cssSelector("td.cart_quantity")).getText();
        total = elementRow.findElement(By.cssSelector("td.cart_total")).getText();
        deleteItem = elementRow.findElement(By.cssSelector("td.cart_delete a"));
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTotal() {
        return total;
    }

    public WebElement getDeleteItem() {
        return deleteItem;
    }
}
