package tests;

import enums.ExistingUserEnum;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LastTransactionPage;
import pages.ToAnotherClientPage;

public class AuthorizationTest extends SeleniumBaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @Description(value = "test")
    @Test
    public void test() {
        DashboardPage dashboardPage = loginPage
                .login(ExistingUserEnum.CLIENT.username, ExistingUserEnum.CLIENT.pass);
        ToAnotherClientPage toAnotherClientPage = dashboardPage
                .toAnotherClientClick()
                .transferToAnotherClient();
        toAnotherClientPage
                .confirmClick()
                .clickToDashboard();
        dashboardPage.toHistoryClick();
        LastTransactionPage lastTransactionPage = dashboardPage.toLastTransactionClick();
        lastTransactionPage.assertMethod();
    }

}
