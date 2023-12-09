package testcrmproject;

import org.openqa.selenium.devtools.idealized.Events;
import org.testng.Assert;
import org.testng.annotations.Test;

import GeneralTests.RetryAnalyzer;
import Utilities.ExcelUtility;
import pages.Client;
import pages.DashBoardOfCrm;
import pages.EventsTab;
import pages.LoginOfCrm;

public class TestEvents extends TestBase 
{
	
		LoginOfCrm objLogin;
		 DashBoardOfCrm crmDashboard;
		 EventsTab event;


		 @Test(dataProviderClass=ExcelUtility.class, dataProvider="logdata")
		 public void eventData(String username,String password,String tittleText,String description,String startdateText,String enddateText,String radiobuttonText) throws InterruptedException  
		 {
		     objLogin = new LoginOfCrm(driver);
		     crmDashboard = new DashBoardOfCrm(driver);  // Pass the WebDriver instance to the constructor
		     objLogin.validLoginToCrmSite(username,password);
		     event=new EventsTab(driver);
		     event.addEventsFromDashBoard(tittleText, description, startdateText, enddateText, radiobuttonText);
		     
		     
		     if (tittleText.isEmpty()) {
		         System.out.println("Is title field required? " + event.checkinRequiredFieldForTittle());
		         Assert.assertTrue(event.checkinRequiredFieldForTittle());
		     }

		     if (description.isEmpty()) {
		         System.out.println("Is description field required? " + event.checkinRequiredFieldForDescription());
		         Assert.assertTrue(event.checkinRequiredFieldForDescription());
		     }

		     if (startdateText.isEmpty()) {
		         System.out.println("Is start date field required? " + event.checkinRequiredFieldForStartDate());
		         Assert.assertTrue(event.checkinRequiredFieldForStartDate());
		     }

		     if (enddateText.isEmpty()) {
		         System.out.println("Is end date field required? " + event.checkinRequiredFieldForEndDate());
		         Assert.assertTrue(event.checkinRequiredFieldForEndDate());
		     }
		 }
		
				 
         }

