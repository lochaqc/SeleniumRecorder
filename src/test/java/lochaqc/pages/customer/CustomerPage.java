package lochaqc.pages.customer;

import lochaqc.keywords.WebUI;
import static lochaqc.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage {
    //Attributes of Customer Page
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers Summary";

    //Objects of Customers Page
    //private By headerPageCustomer = By.xpath("//div[@class='panel-body']//h4[contains(.,'"+PAGE_TEXT+"')]");
    private By headerPageCustomer = By.xpath("(//div[@class='panel-body']//h4)[1]");
    private By buttonAddCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomers = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//div[@class = '_buttons']//a[normalize-space()='Contacts']");
    private By inputSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input");
    private By tdCustomerName = By.xpath("//table[@id='DataTables_Table_0']//tbody/tr[1]/td[3]/a");



    //Constructor

    //Feature processing functions of Customers Page
    public void verifyCustomersPage(){
        //check url
        Assert.assertEquals(getCurrentUrl(), PAGE_URL, "URL is not matched");

        //check text and object which is the only one for this page
        Assert.assertTrue(checkElementExist(headerPageCustomer ),  "Header Page of Customers  is not found");

        Assert.assertEquals(getTextElement(headerPageCustomer), PAGE_TEXT, "Header page of customer page not match" );

    }

    public AddCustomerPage clickNewCustomerButton(){
        //waitForElementVisible(buttonAddCustomer, 10);
        //driver.findElement(buttonAddCustomer).click();
        clickElement(buttonAddCustomer);
        return new AddCustomerPage();

    }

    public void searchCustomer(String companyName){
        waitForPageLoaded();
        //waitForElementVisible(inputSearch, 10);
        //driver.findElement(inputSearch).sendKeys(companyName);
        setText(inputSearch, companyName);
        sleep(2);

    }

    public CustomerDetailPage clickOnFirstRowCustomerName(){
        waitForPageLoaded();
        //waitForElementVisible(tdCustomerName, 10);
        //driver.findElement(tdCustomerName).click();
        clickElement(tdCustomerName);
        return new CustomerDetailPage();
    }

}
