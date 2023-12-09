package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ElementUtilities;
import Utilities.WaitUtilities;

public class Tickets {

	 WebDriver driver;
		WaitUtilities wait;
		ElementUtilities elementutil;
		public Tickets(WebDriver driver) 
			{
		        this.driver = driver;
		        wait=new WaitUtilities(driver);//initialising wait object
		        elementutil=new ElementUtilities(driver);
		        PageFactory.initElements(driver, this);
		        
		    }
		@FindBy(xpath="//i[@class='fa fa-life-ring']")
		WebElement eventsicon;
		
}
