package entities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.web.components.ProductCartPopUp;
import ui.web.pages.ViewProductPage;

public class ProductItem {
    private final WebElement viewProductLink;
    private final WebElement addToCartBUtton;
    private String price;
    private String name;

    public ProductItem(WebElement element) {
        price = element.findElement(By.cssSelector("div.single-products div.productinfo h2")).getText();
        name = element.findElement(By.cssSelector("div.single-products div.productinfo p")).getText();
        viewProductLink = element.findElement(By.cssSelector("div.choose ul li a"));
        addToCartBUtton = element.findElement(By.cssSelector("a.add-to-cart"));
    }

    public ViewProductPage clickOnViewProductLink() {
        viewProductLink.click();
        return new ViewProductPage();
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public ProductCartPopUp clickOnAddToCartButton() {
        addToCartBUtton.click();
        return new ProductCartPopUp();
    }
}
