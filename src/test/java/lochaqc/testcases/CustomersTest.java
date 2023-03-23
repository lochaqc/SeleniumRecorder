package lochaqc.testcases;

import lochaqc.common.BaseTest;
import lochaqc.helpers.CaptureHelper;
import lochaqc.pages.customer.AddCustomerPage;
import lochaqc.pages.customer.CustomerDetailPage;
import lochaqc.pages.customer.CustomerPage;
import lochaqc.pages.DashboardPage;
import lochaqc.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CustomersTest extends BaseTest {

    LoginPage loginPage;

    DashboardPage dashboardPage;

    CustomerPage customerPage;

    AddCustomerPage addCustomerPage;
    CustomerDetailPage customerDetailPage;

    @BeforeClass
    public void setUpClass(){
        System.out.println("Before Class");
        CaptureHelper.startRecord("CustomersTest");
    }

    @AfterClass
    public void tearDownClass(){
        CaptureHelper.stopRecord();
        System.out.println("After Class");
    }

    @Test
    public void testAddNewCustomer(Method method){

        //CaptureHelper.startRecord(method.getName());
        //CaptureHelper.startRecord("NewCustomer");
        loginPage = new LoginPage();
        dashboardPage = loginPage.login("admin@example.com", "123456");
        customerPage = dashboardPage.openCustomerPage();
        //Check Customer Page is loaded and make sure it's right
        customerPage.verifyCustomersPage();
        //Click on new Customer button
        addCustomerPage = customerPage.clickNewCustomerButton();
        String CUSTOMER_NAME = "Ren";
        addCustomerPage.AddDataNewCustomer(CUSTOMER_NAME);
        //Reopen Customer page
        dashboardPage.openCustomerPage();
        //Search Customer just added
        customerPage.searchCustomer(CUSTOMER_NAME);
        //click the first row of search result
        customerDetailPage = customerPage.clickOnFirstRowCustomerName();
        customerDetailPage.checkCustomerDetail("Ren");

       //CaptureHelper.stopRecord();
    }



}
