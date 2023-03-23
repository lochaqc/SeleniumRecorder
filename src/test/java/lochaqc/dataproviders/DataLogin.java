package lochaqc.dataproviders;

import lochaqc.helpers.ExcelHelper;
import lochaqc.helpers.SystemsHelper;
import org.testng.annotations.DataProvider;

public class DataLogin {

    @DataProvider(name = "dataProviderLoginCRM", parallel = true)
    public Object[][] dataLoginCRM(){

        return new Object[][] {
                {"admin@example.com", "123456"},
                {"admin2@example.com", "123456"},
                {"admin3@example.com", "123456"}
        };
    }

    @DataProvider(name = "dataProviderLoginCMS")
    public Object[][] dataLoginCMS(){

        return new Object[][] {
                {"admin1@example.com", "123456", 123},
                {"admin2@example.com", "123456", 1234}

        };
    }

    @DataProvider(name = "data_provider_login_excel")
    public Object[][] dataLoginHRMFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData(SystemsHelper.getCurrentDir() + "src/test/resources/datatest/CRM.xlsx", "Login");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_custom_row")
    public Object[][] dataLoginHRMFromExcelHashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable(SystemsHelper.getCurrentDir() + "src/test/resources/datatest/CRM.xlsx", "Login", 4, 5);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }
}
