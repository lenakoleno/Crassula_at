package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(xpath = ".//div[contains(@class, 'row hidden-m-down')]//a[@routerlink='/payments']")
    private WebElement paymentsTransfersWebElement;

    @FindBy(xpath = ".//div[contains(@class, 'row hidden-m-down')]//a[@routerlink='/dashboard']")
    private WebElement dashboardWebElement;

    @FindBy(xpath = ".//a[@href='/payments/internal']")
    private WebElement toAnotherClientWebElement;

    @FindBy(xpath = ".//mat-row[contains(@class, 'mat-row cdk-row ng-star-inserted')][1]")
    private WebElement lastTransactionWebElement;

    @FindBy(xpath = ".//div[contains(@class,'summary__icon')]")
    private WebElement iconWebElement;

    DashboardPage(WebDriver driver) {
        super(driver);
        waitPageload(dashboardWebElement);
    }

    public ToAnotherClientPage toAnotherClientTransition() {
        paymentsTransfersWebElement.click();
        waitPageload(toAnotherClientWebElement);
        toAnotherClientWebElement.click();
        return new ToAnotherClientPage(driver);
    }

    public ToAnotherClientPage toHistoryTransition() {
        waitPageload(dashboardWebElement);
        paymentsTransfersWebElement.click();
        return new ToAnotherClientPage(driver);
    }

    public LastTransactionPage toLastTransactionTransition() {
        waitPageload(lastTransactionWebElement);
        lastTransactionWebElement.click();
        waitPageload(iconWebElement);
        return new LastTransactionPage(driver);
    }
}
