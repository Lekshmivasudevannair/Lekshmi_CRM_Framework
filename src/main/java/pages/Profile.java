package pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ElementUtilities;
import Utilities.WaitUtilities;

public class Profile {

	

		
	    WebDriver driver;
		WaitUtilities wait;
		ElementUtilities elementutil;
		JavascriptExecutor js;
		public Profile(WebDriver driver) 
			{
		        this.driver = driver;
		        wait=new WaitUtilities(driver);//initialising wait object
		        elementutil=new ElementUtilities(driver);
		       // js=new(JavascriptExecutor)driver;
		        PageFactory.initElements(driver, this);
		        
		        
		    }
		@FindBy(id="user-dropdown-icon")
		WebElement profileicon;
		@FindBy(xpath="//i[@class='fa fa-user mr10']")
		WebElement myprofileicon;
		@FindBy(id="first_name") 
		WebElement first_name;
		@FindBy(id="last_name")
		WebElement last_name;
		@FindBy(id="address")
		WebElement emal_address;
		@FindBy(id="gender_male")
		
		WebElement male;
		@FindBy(id="gender_female")
		WebElement female;
		@FindBy(xpath="//button[@type=\"submit\"]")
		WebElement save;
		@FindBy(id="dob")
		WebElement datefield;
		@FindBy(xpath="//th[@class='datepicker-switch'][1]")
		WebElement datemonth;
		@FindBy(id="profile_image_file")
		WebElement profileimageicon;

public void clickProfileIcon()
{
	//wait.waitForElementToBeClickable(profileicon);
	System.out.println("before click");
	profileicon.click();	
	System.out.println("after click");
}	
public void clickMyProfileIcon()
{

	wait.waitForElementToBeClickable(myprofileicon);
	myprofileicon.click();	
}	


public void setFirstName(String firstname)
{
	wait.waitForElementToBeClickable(first_name);
	 first_name.clear();
	first_name.sendKeys(firstname);
	System.out.println("firstname came");
}	
public void setLastName(String lastname)
{
	wait.waitForElementToBeClickable(last_name);
	last_name.clear();
	last_name.sendKeys(lastname);
	System.out.println("lastname came");
}	
public void setEmail(String email)
{
	wait.waitForElementToBeClickable(emal_address);
	emal_address.clear();
	emal_address.sendKeys(email);
	System.out.println("email came");
	elementutil.scrollToElement(save);
}	
public void setGender(String gender)
{
	
	if (gender=="female")
	{
	wait.waitForElementToBeClickable(female);
	female.click();
	System.out.println("gender came");
	}
	else
	{
		wait.waitForElementToBeClickable(male);
		male.click();
	}
}
public void saveProfileData()
{
	wait.waitForElementToBeClickable(save);
	save.click();
	System.out.println("save clicked");
}
public boolean checkIfFirstnameUpdated(String firstname) {
    wait.waitForElementToBeVisible(first_name);
    String actualText = first_name.getAttribute("value").trim();
    String expectedText = firstname.trim();

    System.out.println("Actual Text: " + actualText);
    System.out.println("Expected Text: " + expectedText);

    return actualText.equalsIgnoreCase(expectedText);
}
public boolean checkIfGenderUpdated(String gender) {
	wait.waitForElementToBeVisible(female);
	 String actualText = female.getAttribute("value").trim();
	    String expectedText = gender.trim();

	    System.out.println("Actual Text: " + actualText);
	    System.out.println("Expected Text: " + expectedText);

	    return actualText.equalsIgnoreCase(expectedText);
}
public boolean checkIfEmailUpdated(String email) {
	 wait.waitForElementToBeVisible(emal_address);
	 String actualText = emal_address.getAttribute("value").trim();
	    String expectedText = email.trim();

	    System.out.println("Actual Text: " + actualText);
	    System.out.println("Expected Text: " + expectedText);
	    elementutil.scrollToElement(save);
	    return actualText.equalsIgnoreCase(expectedText);
	}
public boolean checkIfLastnameUpdated(String lastname) {
	 wait.waitForElementToBeVisible(last_name);
	 String actualText = last_name.getAttribute("value").trim();
	    String expectedText = lastname.trim();

	    System.out.println("Actual Text: " + actualText);
	    System.out.println("Expected Text: " + expectedText);

	    return actualText.equalsIgnoreCase(expectedText);
	}


public void editProfile(String firstname,String lastname,String email,String gender) 
{
	System.out.println("profile class loaded");
	
	System.out.println(firstname);
	System.out.println(lastname);
	System.out.println(email);
	System.out.println(gender);
	
	this.clickProfileIcon();
	this.clickMyProfileIcon();
	
	this.setFirstName(firstname);
	this.setLastName(lastname);
	this.setEmail(email);
	this.setGender(gender);
	this.saveProfileData();
	/*
	 * this.checkIfFirstnameUpdated(firstname);
	 * System.out.println("assert value passed");
	 * this.checkIfLastnameUpdated(lastname);
	 * System.out.println("assert value passed"); this.checkIfEmailUpdated(email);
	 * System.out.println("assert value passed"); this.checkIfGenderUpdated(gender);
	 * System.out.println("assert value passed");
	 */
}


}