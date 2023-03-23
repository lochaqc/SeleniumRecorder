package lochaqc.pages.customer;

import lochaqc.keywords.WebUI;
import static lochaqc.keywords.WebUI.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerDetailPage extends AddCustomerPage {


    //Object CustomerDetailPage


    public void checkCustomerDetail(String customerName){
        System.out.println(getAttributeElement(company, "value" ));
        System.out.println(getAttributeElement(vat, "value"));
        System.out.println(getAttributeElement(phoneNumber,"value" ));
        //driver.findElement(company).getAttribute("value");
        //driver.findElement(vat).getAttribute("value");
        //driver.findElement(phoneNumber).getAttribute("value");

        //Must use "Assert" for checking
        //Must use "Equals" instead of "Contains"
        Assert.assertEquals(getAttributeElement(company, "value" ), customerName, "Company name is mismatched" );
        Assert.assertEquals(getAttributeElement(vat, "value"), "10", "Vat is mismatched");
        Assert.assertEquals(getAttributeElement(phoneNumber,"value" ), "123456789", "phone number is mismatched");

    }

}
