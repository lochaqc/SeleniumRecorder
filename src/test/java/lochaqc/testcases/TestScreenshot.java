package lochaqc.testcases;

import lochaqc.common.BaseTest;
import lochaqc.drivers.DriverManager;
import lochaqc.helpers.CaptureHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestScreenshot extends BaseTest {
    @Test
    public void testHomePage1() {
        DriverManager.getDriver().get("https://anhtester.com/login");
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Login | Anh Tester Blog");

        // Chụp màn hình step này lại
        // Tạo tham chiếu của TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        // Gọi hàm capture screenshot - getScreenshotAs
        File source = ts.getScreenshotAs(OutputType.FILE);
        // Kiểm tra folder tồn tại. Nếu không thì tạo mới folder
        File theDir = new File("screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
        try {
            FileHandler.copy(source, new File("screenshots/testHomePage1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot success !!");
    }

    @Test
    public void testHomePage2(Method method) {
        DriverManager.getDriver().get("https://anhtester.com/login");
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Login");


    }

//    @AfterMethod
//    public void tearDown(ITestResult iTestResult){
//        if (iTestResult.getStatus() == ITestResult.FAILURE) {
//            //Chụp màn hình
//            CaptureHelper.captureScreenshot(iTestResult.getName());
//        }
//    }

}
