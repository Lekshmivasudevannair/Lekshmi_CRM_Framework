package testcrmproject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import GeneralTests.RetryAnalyzer;
import Utilities.ExcelUtility;
import pages.DashBoardOfCrm;
import pages.LoginOfCrm;


//... (imports)

public class LoginOfCrmTest extends TestBase {
 

 LoginOfCrm objLogin;
 DashBoardOfCrm crmDashboard;

@Test(dataProviderClass=ExcelUtility.class,dataProvider="logdata", retryAnalyzer = RetryAnalyzer.class)



 public void loginsuccess(String username,String password) throws InterruptedException   {
     objLogin = new LoginOfCrm(driver);
     crmDashboard = new DashBoardOfCrm(driver);  // Pass the WebDriver instance to the constructor
     objLogin.validLoginToCrmSite(username,password);
     Assert.assertTrue(crmDashboard.loginCheckToDashboard(),"User is not logged in to the CRM dashboard.");
 }
/*@Test(priority = 2)
public void invalidUserNameTest() {
    objLogin = new LoginOfCrm(driver);
    objLogin.validLoginToCrmSite("abc", "12345678");
    Assert.assertTrue(objLogin.invalidUsername().contains("Please enter a valid email address."));
}

@Test(priority = 4)
public void passwordBlankTest() {
    objLogin = new LoginOfCrm(driver);
    objLogin.validLoginToCrmSite("admin@admin.com", "");
    Assert.assertTrue(objLogin.passwordBlank().contains("This field is required."));
}

@Test(priority = 3)
public void requiredUsenamePasswordTest() {
    objLogin = new LoginOfCrm(driver);
    objLogin.validLoginToCrmSite("", "");
    Assert.assertTrue(objLogin.passwordBlank().contains("This field is required"));
}

/*@AfterMethod
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}*/
 
}