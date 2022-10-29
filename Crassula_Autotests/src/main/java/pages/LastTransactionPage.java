package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static common.Constants.ACCOUNT_NUMBER;
import static common.Constants.DESCRIPTION;
import static org.testng.AssertJUnit.assertEquals;

public class LastTransactionPage extends BasePage {

    @FindBy(xpath = ".//div[contains(@class,'summary__icon')]")
    private WebElement iconWebElement;

    @FindBy(xpath = ".//div[contains(text(),'13413119267')]")
    private WebElement accountNumberWebElement;

    @FindBy(xpath = ".//div[contains(text(),'payment in gbp to friend')]")
    private WebElement descriptionWebElement;

    LastTransactionPage(WebDriver driver) {
        super(driver);
        webDriverWait.until(
                ExpectedConditions.visibilityOf(iconWebElement));
    }

    public void assertMethod(){
        assertEquals(DESCRIPTION, descriptionWebElement.getText());
        assertEquals(ACCOUNT_NUMBER, accountNumberWebElement.getText());
    }
}
