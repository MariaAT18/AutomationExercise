package ui.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePageObject;

public class CategorySection extends BasePageObject {
    private String categoryLinkSelector = "//a[contains(.,'<category>')]";
    private String subcategoryLinkSelector = "//a[contains(.,'<subcategory>')]";

    @FindBy(xpath = "//h2[text() = 'Category']")
    WebElement titleCategory;

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }

    public void clickOnCategory(String category) {
        String categorySearch = categoryLinkSelector.replace("<category>", category);
        driver.findElement(By.xpath(categorySearch)).click();
    }

    public ProductSection clickOnSubCategory(String category, String subCategory) {
        String subCategorySearch = subcategoryLinkSelector.replace("<subcategory>", subCategory).replace("<category>", category);
        driver.findElement(By.xpath(subCategorySearch)).click();
        return new ProductSection();
    }
}
