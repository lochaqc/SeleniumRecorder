package lochaqc.pages.customer;

import lochaqc.keywords.WebUI;
import static lochaqc.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage extends CustomerPage{

    private String PAGE_URL = "https://crm.anhtester.com/admin/clients/client";
    private String PAGE_TEXT = "Customer Details";

    public By tabCustomerDetail = By.xpath("//a[@aria-controls='contact_info']");
    public By company = By.xpath("//input[@id='company']");
    public By vat = By.xpath("//input[@id='vat']");
    public By phoneNumber = By.xpath("//input[@id='phonenumber']");
    public By website = By.xpath("//input[@id='website']");
    public By dropdownGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div");
    public By inputGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']");
    public By currency = By.xpath("//button[@data-id='default_currency']");
    public By language = By.xpath("//button[@data-id='default_language']");
    public By address = By.xpath("//textarea[@id='address']");
    public By city = By.xpath("//input[@id='city']");
    public By state = By.xpath("//input[@id='state']");
    public By zipcode = By.xpath("//input[@id='zip']");
    public By dropdownCountry = By.xpath("//label[@for='country']/following-sibling::div");
    public By inputCountry = By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']");
    public By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");


    public void selectGroups(String groupName){
        clickElement(dropdownGroups);
        getWebElement(inputGroups).sendKeys(groupName, Keys.ENTER );
        clickElement(dropdownGroups);

    }

    public void AddDataNewCustomer(String CUSTOMER_NAME){
        WebUI.waitForPageLoaded();
//        driver.findElement(By.id("company")).sendKeys(CUSTOMER_NAME);
//        driver.findElement(By.id("vat")).sendKeys("10");
//        driver.findElement(By.id("phonenumber")).sendKeys("0123456789");
//        driver.findElement(By.id("website")).sendKeys("https://anhtester.com");
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']")).sendKeys("Gold", Keys.ENTER);
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
//        WebUI.sleep(1);
//        driver.findElement(By.id("address")).sendKeys("Viet Nam");
//        driver.findElement(By.id("city")).sendKeys("Can Tho");
//        driver.findElement(By.id("state")).sendKeys("Can Tho");
//        driver.findElement(By.id("zip")).sendKeys("92000");
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div")).click();
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']")).sendKeys("Vietnam", Keys.ENTER);
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();

        setText(company, CUSTOMER_NAME);
        setText(vat, "10");
        setText(phoneNumber, "123456789");
        setText(website, "https://anhtester.com");
        selectGroups("Gold");
        setText(address, "Vietnam");
        setText(city, "Ho Chi Minh");
        setText(state, "Tan Binh");
        setText(zipcode, "028");
        clickElement(dropdownCountry);
        getWebElement(inputCountry).sendKeys("Vietnam", Keys.ENTER );
        clickElement(buttonSave);
        //WebUI.sleep(1);
        //driver.findElement(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();
        WebUI.waitForPageLoaded();
    }
}
