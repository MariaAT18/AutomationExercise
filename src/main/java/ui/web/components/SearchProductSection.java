package ui.web.components;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePageObject;

public class SearchProductSection extends BasePageObject {
    @FindBy(css = "#search_product")
    private WebElement criteriaProductSearch;

    @FindBy(css = "#submit_search")
    private WebElement submitSearchButton;

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }

    public void writeCriteriaToSearch(String criteria) {
        criteriaProductSearch.clear();
        criteriaProductSearch.sendKeys(criteria);
    }

    public ProductSection clickOnSubmitSearchButton() {
        submitSearchButton.click();
        return new ProductSection();
    }
}
