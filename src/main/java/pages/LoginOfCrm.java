package pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;
import Utilities.WaitUtilities;

public class LoginOfCrm {
	
WebDriver driver;
WaitUtilities w;	

	public LoginOfCrm(WebDriver driver) {
		this.driver = driver;
		w=new WaitUtilities(driver);
		PageFactory.initElements(driver,this);
     }
	
	 @FindBy(name="email")
     WebElement userName;
     @FindBy(name="password")
     WebElement password;    
     @FindBy(xpath ="//button[@type='submit']")
	 WebElement submit_button;
	 @FindBy(id="password-error")
	 WebElement passwordrequired;
	 @FindBy(id="email-error")
	 WebElement invalidusername;
	 public void setUsername(String strusername)
	    {
	    	userName.click();
	    	userName.sendKeys(strusername);
	    }
	    public void setPassword(String strpassword)
	    {   
	    	
	    	password.sendKeys(strpassword);
	    }
	    public void login()
	    { 
	    	
	    	submit_button.click();
	    } 
	    public void validLoginToCrmSite(String strusername,String strpassword) 
	    
	    {
         this.setUsername(strusername);
	      w.waitForElementToBeVisible(password);
	      this.setPassword(strpassword);
	       w.waitForElementToBeVisible(password);
	        this.login();
	      }
	    public String passwordBlank() 
	    {
			
			return passwordrequired.getText();
		}
		public String invalidUsername() {
			
			return invalidusername.getText();
		}
	
	

}
