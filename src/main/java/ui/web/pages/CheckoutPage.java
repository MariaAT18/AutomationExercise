package ui.web.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.web.components.CheckoutTableSection;

public class CheckoutPage extends BasePageObject {
    private CheckoutTableSection checkoutTableSection;

    @FindBy(css="div.breadcrumbs li.active")
    WebElement checkoutLabel;

    @FindBy(css="a.check_out")
    WebElement checkoutLink;

    public CheckoutPage() {
        waitUntilPageObjectIsLoaded();
        this.checkoutTableSection = new CheckoutTableSection();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        wait.until(ExpectedConditions.visibilityOf(checkoutLabel));
    }

    public CheckoutTableSection getCheckoutTableSection() {
        return checkoutTableSection;
    }
}
