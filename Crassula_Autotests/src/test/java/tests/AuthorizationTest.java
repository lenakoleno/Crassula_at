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

    @Description(value = "Отправка и проверка платежа - успешный сценарий")
    @Test
    public void paymentPositiveTest() {
        DashboardPage dashboardPage = loginPage
                .login(ExistingUserEnum.CLIENT.username, ExistingUserEnum.CLIENT.pass);
        ToAnotherClientPage toAnotherClientPage = dashboardPage
                .toAnotherClientTransition()
                .transferToAnotherClient();
        toAnotherClientPage
                .confirmClick()
                .clickToDashboard();
        dashboardPage.toHistoryTransition();
        LastTransactionPage lastTransactionPage = dashboardPage.toLastTransactionTransition();
        lastTransactionPage.assertMethod();
        lastTransactionPage.closeWindowClick();
        loginPage = lastTransactionPage.signOut();
    }
}
