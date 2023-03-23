package lochaqc.pages;

import lochaqc.keywords.WebUI;
import static lochaqc.keywords.WebUI.*;
import lochaqc.pages.customer.CustomerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    //Internal data of Dashboard
    private String PAGE_URL = "https://crm.anhtester.com/admin/";
    private String PAGE_TEXT = "Dashboard Options";


    //Objects
    By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    By btnOptionDashboard = By.xpath("//div[@class='screen-options-btn']");
    //By btnOptionDashboard = By.xpath("//div[normalize-space()='Dashboard Options']");
    By widgetStatistics = By.xpath("//div[@id='widget-top_stats']");
    By checkboxQuickStatistics = By.xpath("//label[normalize-space()='Quick Statistics']");

    //Constructor


    public void verifyDashboardPage(){
        //check url
        Assert.assertEquals(getCurrentUrl(), PAGE_URL, "URL is not matched with DashBoard");

        //check text and object which is the only one for this page
        Assert.assertTrue(checkElementExist(btnOptionDashboard ),  "Button Option is not found");
    }



    //Function
    public CustomerPage openCustomerPage(){
        waitForPageLoaded();
        //driver.findElement(menuCustomer).click();
        clickElement(menuCustomer);

        return new CustomerPage();
    }

    public void clickCheckboxQuickStatistics(){
        //driver.findElement(btnOptionDashboard).click();
        clickElement(btnOptionDashboard);
        //waitForElementVisible(checkboxQuickStatistics, 10);
        //driver.findElement(checkboxQuickStatistics).click();
        clickElement(checkboxQuickStatistics);

    }

    public void verifyFilterStatistics(){
        //check whether this widget is displayed
        Assert.assertTrue(verifyElementVisible(widgetStatistics, 5), "Widget statistics default is no visible in current");
        //Uncheck widget
        clickCheckboxQuickStatistics();
        //Check widget is hidden
        Assert.assertTrue(verifyElementNotVisible(widgetStatistics, 5), "Widget statistics default is visible in current");
    }

}
