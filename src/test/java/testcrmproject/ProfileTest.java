package testcrmproject;


import org.testng.Assert;
import org.testng.annotations.Test;

import GeneralTests.RetryAnalyzer;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import Utilities.ExcelUtility;
import pages.DashBoardOfCrm;
import pages.LoginOfCrm;
import pages.NotesTab;
import pages.Profile;

public class ProfileTest extends TestBase {
	 LoginOfCrm objLogin;
	 DashBoardOfCrm crmDashboard;
	 Profile profileobj;


	 @Test(dataProviderClass=ExcelUtility.class, dataProvider="logdata",retryAnalyzer = RetryAnalyzer.class)
	 public void profileData(String username,String password,String firstname,String lastname,String email,String gender)  {
	     objLogin = new LoginOfCrm(driver);
	     crmDashboard = new DashBoardOfCrm(driver);  // Pass the WebDriver instance to the constructor
	     objLogin.validLoginToCrmSite(username,password);
	     profileobj = new  Profile(driver);
	     profileobj.editProfile(firstname,lastname,email,gender);
	   
	     Assert.assertTrue(profileobj.checkIfFirstnameUpdated(firstname));
	     Assert.assertTrue(profileobj.checkIfLastnameUpdated(lastname));
	     Assert.assertTrue(profileobj.checkIfEmailUpdated(email));
	     Assert.assertTrue(profileobj.checkIfGenderUpdated(gender));
	    }


}
