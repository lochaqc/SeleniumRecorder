package lochaqc.testcases;

import lochaqc.common.BaseTest;
import lochaqc.dataproviders.DataLogin;
import lochaqc.drivers.DriverManager;
import lochaqc.helpers.CaptureHelper;
import lochaqc.helpers.ExcelHelper;
import lochaqc.helpers.PropertiesHelper;
import lochaqc.keywords.WebUI;
import lochaqc.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.IDynamicGraph;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

//    @BeforeClass
//    public void setUpClass(){
//        CaptureHelper.startRecord("LoginTest");
//    }
//
//    @AfterClass
//    public void tearDownClass(){
//        CaptureHelper.stopRecord();
//    }



    @AfterMethod
    public void getStatusTestCases(ITestResult result) {
        System.out.println(result.getStatus() == ITestResult.FAILURE);
    }
    @Test
    public void loginTestSuccess(){
        //
        //CaptureHelper.startRecord("loginTestSuccess");
        //Init LoginPage object
        //Send driver from BaseTest
        loginPage = new LoginPage();
        //Call login function from LoginPage
        loginPage.login("admin@example.com", "123456");
        //
        // CaptureHelper.stopRecord();
    }

    @Test
    public void loginTestSuccess1(){
        //Init LoginPage object
        //Send driver from BaseTest
        loginPage = new LoginPage();
        //Call login function from LoginPage
        loginPage.login("admin@example.com", "123456");
    }
    @Test
    public void loginTestSuccess2(){
        //Init LoginPage object
        //Send driver from BaseTest
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Login");

        //Call login function from LoginPage
        loginPage.login(excelHelper.getCellData("EMAIL", 1 ), excelHelper.getCellData("PASSWORD", 1));
        excelHelper.setCellData("Passed", 1, "RESULT");
    }

    @Test
    public void loginTestSuccess3(){
        //Init LoginPage object
        //Send driver from BaseTest
        loginPage = new LoginPage();
        //Call login function from LoginPage
        loginPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        PropertiesHelper.setFile("src/test/resources/configs/data.properties");
        PropertiesHelper.setValue("label", WebUI.getTextElement(By.xpath("(//span[normalize-space()='Invoice overview'])[1]")));
    }

    @Test(dataProvider = "dataProviderLoginCRM", dataProviderClass = DataLogin.class)
    public void loginTestSuccess4(String email, String password){
        //Init LoginPage object
        //Send driver from BaseTest
        loginPage = new LoginPage();
        //Call login function from LoginPage
        loginPage.login(email, password);
    }
    @Test
    public void loginTestSuccess5(){
        //Init LoginPage object
        //Send driver from BaseTest
        loginPage = new LoginPage();
        //Call login function from LoginPage
        loginPage.login("admin@example.com", "123456");
    }

    @Test
    public void loginTestInvalidEmail(){
        //Init LoginPage object
        //Send driver from BaseTest
        loginPage = new LoginPage();
        //Call login function from LoginPage
        loginPage.loginInvalidEmail("admin@example.com123", "123456");


    }

    @Test(dataProvider = "data_provider_login_excel", dataProviderClass = DataLogin.class)
    public void loginTestFromDataProviderReadExcel(String email, String password, String result){
        //Init LoginPage object
        //Send driver from BaseTest
        loginPage = new LoginPage();
        //Call login function from LoginPage
        loginPage.login(email, password);

    }

    @Test(dataProvider = "data_provider_login_excel_custom_row", dataProviderClass = DataLogin.class)
    public void loginTestFromDataProviderReadExcelCustomRow(Hashtable<String, String> data){
        //Init LoginPage object
        //Send driver from BaseTest
        loginPage = new LoginPage();
        //Call login function from LoginPage
        loginPage.login(data.get("EMAIL"), data.get("PASSWORD"));

    }


}
