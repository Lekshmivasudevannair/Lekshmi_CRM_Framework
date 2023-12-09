package testcrmproject;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import GeneralTests.RetryAnalyzer;
import Utilities.ExcelUtility;
import pages.Announcements;
import pages.DashBoardOfCrm;
import pages.LoginOfCrm;


public class TestAnnouncements extends TestBase
{

	 LoginOfCrm objLogin;
	 DashBoardOfCrm crmDashboard;
	 Announcements announcement;


	 @Test(dataProviderClass=ExcelUtility.class, dataProvider="logdata")
	 public void announcementData(String username,String password,String tittle,String startdate,String enddate,String checkboxText) throws AWTException, InterruptedException  
		 {    
		 objLogin = new LoginOfCrm(driver);
	     crmDashboard = new DashBoardOfCrm(driver);  // Pass the WebDriver instance to the constructor
	     objLogin.validLoginToCrmSite(username,password);
	     announcement = new  Announcements(driver);
	     announcement.addAnnouncements(tittle,startdate,enddate,checkboxText);
	     Assert.assertTrue(announcement.checkIfAnnouncementGetSearched(tittle),"Passed");
	     Assert.assertTrue(announcement.checkIfLastAddedAnnouncementIsDeleted(),"pass");
	     } 
			
}
