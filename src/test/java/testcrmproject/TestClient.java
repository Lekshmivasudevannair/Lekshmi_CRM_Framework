package testcrmproject;



import org.testng.Assert;
import org.testng.annotations.Test;

import GeneralTests.RetryAnalyzer;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import pages.Client;
import pages.DashBoardOfCrm;
import pages.LoginOfCrm;


public class TestClient extends TestBase{
	LoginOfCrm objLogin;
	 DashBoardOfCrm crmDashboard;
	 Client clnt;

	

	 
	 @Test(dataProviderClass=ExcelUtility.class, dataProvider="logdata", retryAnalyzer = RetryAnalyzer.class)
	 public void clientData(String username,String password,String nameofcompany,String companyaddress,String cityname) throws InterruptedException  {
	     objLogin = new LoginOfCrm(driver);
	     crmDashboard = new DashBoardOfCrm(driver);  // Pass the WebDriver instance to the constructor
	     objLogin.validLoginToCrmSite(username,password);
	     clnt=new Client(driver);
	     clnt.addingClientDetails( nameofcompany,companyaddress,cityname);
	     Assert.assertTrue(clnt.checkIfClientIsPresentInTable(nameofcompany));
	     
	    }
	
	

}
