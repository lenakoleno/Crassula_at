package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "/html/body/cl-app/div/cl-main-layout/header/div[2]/div[1]/cl-main-menu/cl-panel/cl-main-menu-links/a[2]")
    private WebElement paymentsTransfersWebElement;

    @FindBy(xpath = "/html/body/cl-app/div/cl-main-layout/header/div[2]/div[1]/cl-main-menu/cl-panel/cl-main-menu-links/a[1]")
    private WebElement dashboardWebElement;

    @FindBy(xpath = "/html/body/cl-app/div/cl-main-layout/cl-payments-layout/div/cl-secondary-menu/cl-panel/cl-tab-nav-bar/a[4]")
    private WebElement toAnotherClientWebElement;

    @FindBy(xpath = "/html/body/cl-app/div/cl-main-layout/cl-payments-layout/cl-payment-history/cl-panel/cl-panel-body/div/mat-table/mat-row[1]")
    private WebElement lastTransactionWebElement;

    @FindBy(xpath = ".//div[contains(@class,'summary__icon')]")
    private WebElement iconWebElement;

    DashboardPage(WebDriver driver) {
        super(driver);
        webDriverWait.until(
                ExpectedConditions.visibilityOf(dashboardWebElement));
    }

    public ToAnotherClientPage toAnotherClientClick() {
        paymentsTransfersWebElement.click();
        webDriverWait.until(
                ExpectedConditions.visibilityOf(toAnotherClientWebElement));
        toAnotherClientWebElement.click();
        return new ToAnotherClientPage(driver);
    }

    public ToAnotherClientPage toHistoryClick() {
        webDriverWait.until(
                ExpectedConditions.visibilityOf(dashboardWebElement));
        paymentsTransfersWebElement.click();
        return new ToAnotherClientPage(driver);
    }

    public LastTransactionPage toLastTransactionClick()
    {
        webDriverWait.until(
                ExpectedConditions.visibilityOf(lastTransactionWebElement));
        lastTransactionWebElement.click();
        webDriverWait.until(
                ExpectedConditions.visibilityOf(iconWebElement));
        return new LastTransactionPage(driver);
    }

}
