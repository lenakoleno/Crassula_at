package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailWebElement;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordWebElement;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement clickEnterButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage login(String username, String password) {
        emailWebElement.sendKeys(username);
        passwordWebElement.sendKeys(password);
        clickEnterButton.click();
        return new DashboardPage(driver);
    }
}
