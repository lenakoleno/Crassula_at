package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wait.WaitExt;

import static common.Constants.*;

public class ToAnotherClientPage extends BasePage {

    @FindBy(xpath = "//*[@id='amount']")
    private WebElement amountWebElement;

 //TODO: не автогенерируемый заголовок не находится автотестом, хотя в ручную в доме он ищется, поэтому убран выбор валюты
    @FindBy(xpath = ".//div[@class='item-sum-control']//span[text()='EUR']")
    public WebElement currencyWebElement;

    @FindBy(xpath = ".//span[text()='GBP']")
    public WebElement gbpWebElement;

    @FindBy(xpath = ".//a[contains(text(),'To another client')]")
    private WebElement toAnotherClient;

    @FindBy(xpath = "//*[@data-placeholder='Phone, @username or account number']")
    private WebElement toAccountWebElement;

    @FindBy(xpath = "//*[@id='transfer-details']")
    private WebElement descriptionWebElement;

    @FindBy(xpath = "//*[@data-placeholder='Set template name']")
    private WebElement setTemplateWebElement;

    @FindBy(xpath = ".//button[contains(text(),'Continue')]")
    private WebElement continueButton;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement confirmButton;


    ToAnotherClientPage(WebDriver driver) {
        super(driver);
        webDriverWait.until(
                ExpectedConditions.visibilityOf(toAnotherClient));
    }

    public ToAnotherClientPage transferToAnotherClient() {
        amountWebElement.sendKeys(AMOUNT);
        toAccountWebElement.sendKeys(ACCOUNT_NUMBER);
        descriptionWebElement.sendKeys(DESCRIPTION);
        setTemplateWebElement.sendKeys(TEMPLATE_NAME);
        WaitExt.sleep(2); //добавлен sleep из-за прогрузки кнопки
        continueButton.click();
        return this;
    }

    public TransferCompletedPage confirmClick() {
        webDriverWait.until(
                ExpectedConditions.visibilityOf(confirmButton));
        confirmButton.click();
        return new TransferCompletedPage(driver);
    }

}
