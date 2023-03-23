package lochaqc.common;



import io.github.bonigarcia.wdm.WebDriverManager;
import lochaqc.drivers.DriverManager;
import lochaqc.helpers.CaptureHelper;
import lochaqc.helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {



    @BeforeMethod
    @Parameters({"browser"})
    public static void createDriver(@Optional("chrome") String browser) {
        WebDriver driver = setupDriver(browser);
        PropertiesHelper.loadAllFiles();
        //set giá trị driver da duoc khoi tao vao ThreadLocal
        DriverManager.setDriver(driver);
    }

    public static WebDriver setupDriver(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private static WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver(ITestResult iTestResult) {

        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            //Chụp màn hình
            CaptureHelper.captureScreenshot(iTestResult.getName());
        }
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); //Reset timeout

    //    CaptureHelper.stopRecord();
        if(DriverManager.getDriver() != null) {
           // driver.quit();
            DriverManager.quit();
        }
    }

}

