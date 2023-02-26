package ui.web.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.web.components.BrandSection;
import ui.web.components.CategorySection;
import ui.web.components.SearchProductSection;

public class ProductPage extends BasePageObject {
    private CategorySection categorySection;
    private BrandSection brandSection;
    private SearchProductSection searchProductSection;

    @FindBy(css = "div.features_items h2.title")
    private WebElement titleAllProducts;

    public ProductPage() {
        waitUntilPageObjectIsLoaded();
        this.categorySection = new CategorySection();
        this.brandSection = new BrandSection();
        searchProductSection = new SearchProductSection();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        wait.until(ExpectedConditions.visibilityOf(titleAllProducts));
    }

    public CategorySection getCategorySection() {
        return categorySection;
    }

    public BrandSection getBrandSection() {
        return brandSection;
    }

    public SearchProductSection getSearchProductSection() {
        return searchProductSection;
    }

    public String getAllProductsTitle() {
        return titleAllProducts.getText();
    }
}
