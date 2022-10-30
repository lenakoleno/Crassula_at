package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferCompletedPage extends BasePage {

    @FindBy(xpath = ".//a[text()='To dashboard']")
    private WebElement toDashboardButton;

    TransferCompletedPage(WebDriver driver) {
        super(driver);
    }

    public TransferCompletedPage clickToDashboard() {
        waitPageload(toDashboardButton);
        toDashboardButton.click();
        return this;
    }
}
