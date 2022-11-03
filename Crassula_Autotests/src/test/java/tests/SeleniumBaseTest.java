package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;

public class SeleniumBaseTest {

    private WebDriver driver;
    LoginPage loginPage;

    @BeforeSuite
    protected void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://client-avlasov.stage.crassu.la/sign-in");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        driver.close();
        driver.quit();
    }
}
