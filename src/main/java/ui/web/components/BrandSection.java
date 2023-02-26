package ui.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import ui.BasePageObject;

public class BrandSection extends BasePageObject {
    private String brandLinkSelector = "//a[contains(.,'<brand>')]";
    private String brandLinkQuantitySelector = "//a[contains(.,'<brand>')]/span";

    private int productQuantity;

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }

    public ProductSection clickOnBrand(String brand) {
        String brandSelector = brandLinkSelector.replace("<brand>", brand);
        driver.findElement(By.xpath(brandSelector)).click();
        String productQuantitySelector = brandLinkQuantitySelector.replace("<brand>", brand);
        String productQuantityLabel = driver.findElement(By.xpath(productQuantitySelector)).getText().replace("(", "").replace(")", "");
        productQuantity = Integer.parseInt(productQuantityLabel);

        return new ProductSection();
    }
}