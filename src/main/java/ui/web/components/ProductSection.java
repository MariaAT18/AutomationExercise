package ui.web.components;

import entities.ProductItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

import java.util.ArrayList;
import java.util.List;

public class ProductSection extends BasePageObject {
    private static final String TITLE_PRODUCTS = "//h2[text() = '<category> - <subcategory> Products']";
    private List<ProductItem> productItems;

    @FindBy(css = "div.features_items h2.title")
    WebElement titleDisplaysSearchedProducts;

    public ProductSection() {
        waitUntilPageObjectIsLoaded();
        productItems = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector("div.product-image-wrapper"));
        for (WebElement element : elements) {
            productItems.add(new ProductItem(element));
        }
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        wait.until(ExpectedConditions.visibilityOf(titleDisplaysSearchedProducts));
    }

    public boolean existTitleProducts(String category, String subCategory) {
        String title = TITLE_PRODUCTS.replace("<category>", category).replace("<subcategory>", subCategory);
        return driver.findElement(By.cssSelector(title)).isDisplayed();
    }

    public int getProductCount() {
        return productItems.size();
    }

    public String getTitleDisplaysSearchedProducts() {
        return titleDisplaysSearchedProducts.getText();
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }
}
