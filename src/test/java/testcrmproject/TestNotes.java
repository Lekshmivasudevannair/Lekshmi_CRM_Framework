package testcrmproject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import GeneralTests.RetryAnalyzer;
import Utilities.ExcelUtility;
import pages.DashBoardOfCrm;
import pages.LoginOfCrm;
import pages.NotesTab;

public class TestNotes extends TestBase{
	
	
	 LoginOfCrm objLogin;
	 DashBoardOfCrm crmDashboard;
	 NotesTab notes;


	 @Test(dataProviderClass=ExcelUtility.class, dataProvider="logdata", retryAnalyzer = RetryAnalyzer.class)
	 public void notesData(String username,String password,String tittle,String description) throws InterruptedException  {
	     objLogin = new LoginOfCrm(driver);
	     crmDashboard = new DashBoardOfCrm(driver);  // Pass the WebDriver instance to the constructor
	     objLogin.validLoginToCrmSite(username,password);
	     notes = new NotesTab(driver);
	     notes.addNotes(tittle,description);
	     Assert.assertTrue(notes.checkTableTittle(tittle));
	     
	    }
	
	 
}
