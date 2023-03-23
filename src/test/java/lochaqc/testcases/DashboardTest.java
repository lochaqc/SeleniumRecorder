package lochaqc.testcases;

import lochaqc.common.BaseTest;
import lochaqc.pages.customer.CustomerPage;
import lochaqc.pages.DashboardPage;
import lochaqc.pages.LoginPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    CustomerPage customerPage;


    @Test
    public void testOpenMenuOnDashboard(){

        loginPage = new LoginPage();

        //Lien ket trang duoc xay ra nho ham login tra ve la su khoi tao cua trang Dashboard
        dashboardPage = loginPage.login("admin@example.com", "123456");
        //By total = By.xpath("(//div[@id='widget-top_stats']//div[@class='top_stats_wrapper'])[2]");
        //System.out.println(driver.findElement(total));

        //Check Dashboard access

        dashboardPage.verifyDashboardPage();

        //Check Customer screen navigation
        customerPage = dashboardPage.openCustomerPage();

        customerPage.verifyCustomersPage();

    }

    @Test
    public void testFilterWidgetOnDashboard(){

        loginPage = new LoginPage();


        loginPage.login("admin@example.com", "123456");
        //By total = By.xpath("(//div[@id='widget-top_stats']//div[@class='top_stats_wrapper'])[2]");
        //System.out.println(driver.findElement(total));

        //Check Dashboard access
        dashboardPage = new DashboardPage();
        dashboardPage.verifyDashboardPage();

        //Check widget on Dashboard
        dashboardPage.verifyFilterStatistics();

    }

}
