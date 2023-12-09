	package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ElementUtilities;
import Utilities.WaitUtilities;
public class EventsTab {
	
	    WebDriver driver;
		WaitUtilities wait;
		ElementUtilities elementutil;
		public EventsTab(WebDriver driver) 
			{
		        this.driver = driver;
		        wait=new WaitUtilities(driver);//initialising wait object
		        elementutil=new ElementUtilities(driver);
		        PageFactory.initElements(driver, this);
		        
		    }
		@FindBy(xpath="//i[@class='fa fa-calendar']")
		WebElement eventsicon;
		@FindBy(xpath="//a[@class='btn btn-default']")
		WebElement addevents_button;
		@FindBy(id="title")
		WebElement event_tittle;
		@FindBy(id="description")
		WebElement event_description;
		@FindBy(id="start_date")
		WebElement startdate;
		@FindBy(id="end_date")
		WebElement enddate;
	    @FindBy(xpath="//input[@type='radio']")
		List<WebElement> radiobuttons;
		@FindBy(xpath="//button[@type='submit']")
		WebElement save_button;
		@FindBy(xpath="//span[@id='title-error']")
		WebElement tittle_required_field;
		@FindBy(xpath="//span[@id='description-error']")
		WebElement description_required_field;
		@FindBy(xpath="//span[@id='start_date-error']")
		WebElement startdate_required_field;
		@FindBy(xpath="//span[@id='end_date-error']")
		WebElement enddate_required_field;
		public void clickEventIcon()
		{
			
			wait.waitForElementToBeVisible(eventsicon);
			wait.waitForElementToBeClickable(eventsicon);
			elementutil.clickOnElement(eventsicon);
		}
		public void clickAddEventsButton() 
		{
			wait.waitForElementToBeVisible(addevents_button);
			wait.waitForElementToBeClickable(addevents_button);
			elementutil.clickOnElement(addevents_button);
		}
		public void setTittle(String tittleText)
		{
			wait.waitForElementToBeVisible(event_tittle);
			wait.waitForElementToBeClickable(event_tittle);
			elementutil.mouseHoverAndClickonElement(event_tittle);
			elementutil.sendKeysUsingJavaScript(event_tittle,tittleText);
		}
		public void setDescription(String descriptionText)
		{
			wait.waitForElementToBeVisible(event_description);
			wait.waitForElementToBeClickable(event_description);
			elementutil.mouseHoverAndClickonElement(event_description);
			elementutil.sendKeysUsingJavaScript(event_description,descriptionText);
		
		}
		public void setStartDate(String startdateText)
		{
			wait.waitForElementToBeVisible(startdate);
			wait.waitForElementToBeClickable(startdate);
			if (!startdateText.equals(""))
			{
			elementutil.mouseHoverAndClickonElement(startdate);
			elementutil.sendKeysUsingJavaScript(startdate,startdateText);
			elementutil.pressEnter(startdate);
			}
			else
			{
				elementutil.scrollToElement(save_button);
				elementutil.clickOnElement(save_button);
			}
				
		}
		public void setEndDate(String enddateText)
		{
			wait.waitForElementToBeVisible(enddate);
			wait.waitForElementToBeClickable(enddate);
			
			if (!enddateText.equals(""))
			{
				
			elementutil.mouseHoverAndClickonElement(enddate);
			elementutil.sendKeysUsingJavaScript(enddate,enddateText);
			elementutil.pressEnter(enddate);
			}
			else
			{
				elementutil.scrollToElement(save_button);
				elementutil.clickOnElement(save_button);
			}
		}
		public void setRadioButton(String radioText)
		{
			elementutil.radioButtonClick(radiobuttons,radioText);
			elementutil.scrollToElement(save_button);
		}
		public void clickSave()
		{
			wait.waitForElementToBeVisible(save_button);
			wait.waitForElementToBeClickable(save_button);
			elementutil.clickOnElement(save_button);
		}
		
		public boolean checkinRequiredFieldForTittle() {
		    wait.waitForElementToBeVisible(tittle_required_field);
            return elementutil.isElementDisplayed(tittle_required_field);
		    
		}

		public boolean checkinRequiredFieldForDescription() {
		    wait.waitForElementToBeVisible(description_required_field);
            return elementutil.isElementDisplayed(description_required_field);
		    }


		public boolean checkinRequiredFieldForStartDate()
		{
			wait.waitForElementToBeVisible(startdate_required_field);
			 return elementutil.isElementDisplayed(startdate_required_field);
			
	    }
	
		public boolean checkinRequiredFieldForEndDate()
		{
			wait.waitForElementToBeVisible(enddate_required_field);
			return elementutil.isElementDisplayed(startdate_required_field);
			
	    }
	public void addEventsFromDashBoard(String tittle,String description,String startdateText,String enddateText,String radioText)
	{   
		
		this.clickEventIcon();
	    this.clickAddEventsButton();
		this.setTittle(tittle);
		this.setDescription(description);
		this.setStartDate(startdateText);
		this.setEndDate(enddateText);
		this.setRadioButton(radioText);
		this.clickSave();	
	}
}

