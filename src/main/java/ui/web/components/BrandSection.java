package ui.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import ui.BasePageObject;

public class BrandSection extends BasePageObject {
    private static final String BRAND_LINK_SELECTOR = "//a[contains(.,'<brand>')]";
    private static final String PRODUCT_QUANTITY_SELECTOR = "//a[contains(.,'<brand>')]/span";
    private int productQuantity;

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }
    public ProductSection clickOnBrand(String brand) {
        String brandSelector = BRAND_LINK_SELECTOR.replace("<brand>", brand);
        driver.findElement(By.xpath(brandSelector)).click();
        String productQuantitySelector = PRODUCT_QUANTITY_SELECTOR.replace("<brand>", brand);
        String productQuantityLabel = driver.findElement(By.xpath(productQuantitySelector)).getText().replace("(", "").replace(")", "");
        productQuantity = Integer.parseInt(productQuantityLabel);

        return new ProductSection();
    }

    public int getProductQuantity() {
        return productQuantity;
    }
}