package testcrmproject;

import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import pages.DashBoardOfCrm;
import pages.LoginOfCrm;


public class TestDashboard extends TestBase {
	
	LoginOfCrm objLogin;
	DashBoardOfCrm crmDashboard;
	

	 @Test(dataProviderClass=ExcelUtility.class, dataProvider="logdata")
	 public void clockoutData(String username,String password,String noteText)
	 {
		 
	     objLogin = new LoginOfCrm(driver);
	     crmDashboard = new DashBoardOfCrm(driver);  // Pass the WebDriver instance to the constructor
	     objLogin.validLoginToCrmSite(username,password);
	   
	     crmDashboard.addClocNoteInDashBoard(noteText); 
	     Assert.assertTrue(crmDashboard.checkIfAfterClockoutNoteGivenButtonChangedToClockin());
	     
	    }

}
