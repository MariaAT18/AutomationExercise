package ui.web.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.web.components.ProductCartPopUp;

public class ViewProductPage extends BasePageObject {
    @FindBy(css="div.product-information h2")
    WebElement title;
    @FindBy(xpath="//div[@class='product-information']/p[contains(., 'Category')]")
    WebElement category;
    @FindBy(xpath="//div[@class='product-information']/span/span[contains(., 'Rs.')]")
    WebElement price;
    @FindBy(xpath="//div[@class='product-information']/p[contains(., 'Availability')]")
    WebElement availability;
    @FindBy(xpath="//div[@class='product-information']/p[contains(., 'Condition')]")
    WebElement condition;
    @FindBy(xpath="//div[@class='product-information']/p[contains(., 'Brand')]")
    WebElement brand;

    @FindBy(css="input#quantity")
    WebElement quantity;

    @FindBy(css="button.cart")
    WebElement addToCart;

    public ViewProductPage() {
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public ProductCartPopUp addToCartWithQuantity(String quantityValue) {
        quantity.clear();
        quantity.sendKeys(quantityValue);
        addToCart.click();
        return new ProductCartPopUp();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getCategory() {
        return category.getText().replace("Category:", "").trim();
    }

    public String getPrice() {
        return price.getText().replace("Rs.", "").trim();
    }

    public String getAvailability() {
        return availability.getText().replace("Availability:", "").trim();
    }

    public String getCondition() {
        return condition.getText().replace("Condition:", "").trim();
    }

    public String getBrand() {
        return brand.getText().replace("Brand:", "").trim();
    }
}
