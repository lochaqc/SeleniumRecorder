package lochaqc.pages;

import lochaqc.helpers.PropertiesHelper;
import lochaqc.keywords.WebUI;
import static lochaqc.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";

    //Store Object Login page
    //Using By object of selenium to define object name of locator
    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By messageErrorEmail = By.xpath("//div[@class='text-center alert alert-danger']");

    //Instructor for driver


    //Functions for Login page
    public void verifyHeaderPage(){
        Assert.assertEquals(getTextElement(headerPage), "Login", "FAIL. Header page is mismatched");
    }

    public void verifyErrorMsgDisplay(){
        Assert.assertTrue(getWebElement(messageErrorEmail).isDisplayed(), "FAIL. No message error displayed");
        Assert.assertEquals(getTextElement(messageErrorEmail), "Invalid email or password", "FAIL. Message content is mismatched"  );
    }

    public void enterEmail(String email){
        //driver.findElement(inputEmail).sendKeys(email);
        setText(inputEmail, email);

    }

    public void enterPassword(String password){
        //driver.findElement(inputPassword).sendKeys(password);
        setText(inputPassword, password);

    }

    public void clickOnLoginButton(){

        //driver.findElement(buttonLogin).click();
        clickElement(buttonLogin);
    }

    public DashboardPage login(String email, String password){
        //driver.get(URL);
        openURL(PropertiesHelper.getValue("url"));

        verifyHeaderPage();

        enterEmail(email);
        //setText(inputEmail, email);

        enterPassword(password);
        //setText(inputPassword, password);

        clickOnLoginButton();
        Assert.assertTrue(verifyElementNotPresent(messageErrorEmail, 5), "Login Failed" );

        return new DashboardPage();
    }

    public void loginInvalidEmail(String email, String password){
        openURL(PropertiesHelper.getValue("url"));
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        //Check error message
        verifyErrorMsgDisplay();

    }

}
