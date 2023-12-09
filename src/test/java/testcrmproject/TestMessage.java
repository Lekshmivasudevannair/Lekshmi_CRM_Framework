package testcrmproject;
import java.awt.AWTException;
import java.util.concurrent.TimeoutException;
import org.apache.hc.core5.http.Message;
import org.testng.Assert;
import org.testng.annotations.Test;
import GeneralTests.RetryAnalyzer;
import Utilities.ExcelUtility;
import pages.DashBoardOfCrm;
import pages.LoginOfCrm;
import pages.MessageTab;
public class TestMessage extends TestBase 
{

	 LoginOfCrm objLogin;
	 DashBoardOfCrm crmDashboard;
	 MessageTab  messagepageobject;


	 @Test(dataProviderClass=ExcelUtility.class, dataProvider="logdata")
	 public void messageData(String username,String password,String towhom,String subject,String messagewrite) throws TimeoutException 
	 {
		 
	     objLogin = new LoginOfCrm(driver);
	     crmDashboard = new DashBoardOfCrm(driver);  // Pass the WebDriver instance to the constructor
	     objLogin.validLoginToCrmSite(username,password);
	     messagepageobject = new MessageTab (driver);
	     messagepageobject.addMessagePageFields(towhom,subject,messagewrite); 
	     Assert.assertTrue(messagepageobject.checkIfMessageIsSent());
	     
	    }
	
	 
}

