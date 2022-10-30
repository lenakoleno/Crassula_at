package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = ".//button[contains(@class,'dialog-close')]")
    private WebElement closeWebElement;

    @FindBy(xpath = ".//div[contains(@class,'profile__name')]")
    private WebElement nameSurnameWebElement;

    @FindBy(xpath = ".//div[text()='Sign out']")
    private WebElement signOutWebElement;

    LastTransactionPage(WebDriver driver) {
        super(driver);
        waitPageload(iconWebElement);
    }

    public void assertMethod(){
        assertEquals(DESCRIPTION, descriptionWebElement.getText());
        assertEquals(ACCOUNT_NUMBER, accountNumberWebElement.getText());
    }

    public DashboardPage closeWindowClick() {
        closeWebElement.click();
        return new DashboardPage(driver);
    }

    public LoginPage signOut() {
        nameSurnameWebElement.click();
        signOutWebElement.click();
        return new LoginPage(driver);
    }
}
