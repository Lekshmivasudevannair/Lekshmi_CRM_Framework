package testcrmproject;

import java.awt.AWTException;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import pages.DashBoardOfCrm;
import pages.LoginOfCrm;
import pages.MessageTab;
import pages.Tickets;

public class TestTickets extends TestBase {
	
	LoginOfCrm objLogin;
	 DashBoardOfCrm crmDashboard;
	 Tickets  ticket;


	 @Test(dataProviderClass=ExcelUtility.class, dataProvider="logdata")
	 public void ticketData(String username,String password,String tittle,String client,String description) throws TimeoutException, AWTException, InterruptedException 
	 {
		 
	     objLogin = new LoginOfCrm(driver);
	     crmDashboard = new DashBoardOfCrm(driver);  // Pass the WebDriver instance to the constructor
	     objLogin.validLoginToCrmSite(username,password);
	    ticket = new  Tickets (driver);
	    ticket.addingTicket(tittle, client, description);
	    Assert.assertTrue(ticket.VerifyIfTheImageIsUploaded());
	  
	    }

}
