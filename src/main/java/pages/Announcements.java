package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ElementUtilities;
import Utilities.WaitUtilities;

public class Announcements {
	WebDriver driver;
	WaitUtilities wait;
	ElementUtilities elementutil;
	JavascriptExecutor js;
	public Announcements(WebDriver driver)
	{
        this.driver = driver;
        wait=new WaitUtilities(driver);//initialising wait object
        elementutil=new ElementUtilities(driver);
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-bullhorn']")
	WebElement Announcement_icon;
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement addannouncement;
	@FindBy(id="title")
	WebElement tittle;
	@FindBy(xpath="//textarea[@class='note-codable']")
	WebElement textarea;
	@FindBy(id="start_date")
	WebElement startdate;
	@FindBy(id="end_date")
	WebElement enddate;
	@FindBy(id="share_with_members")
	WebElement chkbox_sharewithmembers;
	@FindBy(id="cmmupuvznimphuz")
	WebElement uploadfile_button;
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	WebElement save_button;
	@FindBy(xpath="//input[@type='checkbox']")
	List<WebElement> checkboxes;
	@FindBy(xpath="//input[@type='search']")
	WebElement search_announcement;
	@FindBy(xpath="//table[@id='announcement-table']//tr[1]//td[1]")
	WebElement table_anouncement_tittle;
	@FindBy(xpath="//table[@id='announcement-table']//tr[1]//td[5]//a[2]")
	WebElement delete_announcement;
	@FindBy(xpath="//div[@class='app-alert-message']")
	WebElement delete_announcement_alert;
public void clickAnnouncementIcon()
{
	
	wait.waitForElementToBeVisible(Announcement_icon);
	wait.waitForElementToBeClickable(Announcement_icon);
	elementutil.clickOnElement(Announcement_icon);
}
public void clickAddAnnouncementbutton() 
{
	wait.waitForElementToBeVisible(addannouncement);
	wait.waitForElementToBeClickable(addannouncement);
	elementutil.clickOnElement(addannouncement);
}
public void setTittle(String tittleText)
{
	wait.waitForElementToBeVisible(tittle);
	wait.waitForElementToBeClickable(tittle);
	elementutil.mouseHoverAndClickonElement(tittle);
	elementutil.sendKeysUsingJavaScript(tittle,tittleText);
}
public void setStartDate(String startdateText)
{
	wait.waitForElementToBeVisible(startdate);
	wait.waitForElementToBeClickable(startdate);
	elementutil.mouseHoverAndClickonElement(startdate);
	elementutil.sendKeysUsingJavaScript(startdate,startdateText);
	elementutil.pressEnter(startdate);
}
public void setEndDate(String enddateText)
{
	wait.waitForElementToBeVisible(enddate);
	wait.waitForElementToBeClickable(enddate);
	elementutil.mouseHoverAndClickonElement(enddate);
	elementutil.sendKeysUsingJavaScript(enddate,enddateText);
	elementutil.pressEnter(enddate);
}
public void setCheckBox(String checkboxText)
{
	elementutil.checkBoxClick(checkboxes,checkboxText);
	elementutil.scrollToElement(save_button);
}
public void clickSave()
{
	wait.waitForElementToBeVisible(save_button);
	wait.waitForElementToBeClickable(save_button);
	elementutil.clickOnElement(save_button);
}
public void searchIfannouncementIsadded(String tittleText)
{
String search_announcement_by_tittle=tittleText;

try {
	
		wait.waitForElementToBeClickable(search_announcement);
		elementutil.mouseHoverAndClickonElement(search_announcement);
		elementutil.sendKeysUsingJavaScript(search_announcement, search_announcement_by_tittle);
        search_announcement.sendKeys(Keys.ENTER);

	} catch (Exception e) {
	    e.printStackTrace();
	}

	try {
		wait.waitForElementToBeVisible(search_announcement);
		
		}   catch (Exception e) {
	    e.printStackTrace();
	}
}	
public boolean checkIfAnnouncementGetSearched(String tittleText) {
	
		
		String tittle=elementutil.getElementText(table_anouncement_tittle);
		if(tittle.equalsIgnoreCase(tittleText))
		{
			
			return true;
		}
		return false;
}

public boolean checkIfLastAddedAnnouncementIsDeleted()

{
	wait.waitForElementToBeVisible(delete_announcement);
	wait.waitForElementToBeClickable(delete_announcement);
	elementutil.clickOnElement(delete_announcement);
	wait.waitForElementToBeVisible(delete_announcement_alert);
	if(elementutil.isElementDisplayed(delete_announcement_alert))
	{
		return true;
	}
	
	return false;
	
}
public void addAnnouncements(String tittleText,String startdateText,String enddateText,String checkboxText) 
 {
	this.clickAnnouncementIcon();
	this.clickAddAnnouncementbutton();
	this.setTittle(tittleText);
	this.setStartDate(startdateText);
	this.setEndDate(enddateText);
	this.setCheckBox(checkboxText);
	this.clickSave();
	this.clickAnnouncementIcon();
	this.searchIfannouncementIsadded(tittleText);
 }

}
