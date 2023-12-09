package pages;
import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ElementUtilities;
import Utilities.WaitUtilities;
public class MessageTab {
	private static final String String = null;
	WebDriver driver;
	WaitUtilities wait;
	ElementUtilities elementutil;
    JavascriptExecutor js;
	public MessageTab(WebDriver driver) 
	{

		this.driver = driver;
		wait = new WaitUtilities(driver);// initialising wait object
		elementutil = new ElementUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-envelope']")
	WebElement dashboardmessageicon;
	@FindBy(xpath = "//*[@id=\"page-content\"]/div/div/div[1]/ul/a[1]")
	WebElement compose;
	@FindBy(xpath ="(//div[contains(@class, 'select2')])[4]")
	WebElement todropdownicon;
	@FindBy(xpath = "//input[@id='subject']")
	WebElement subject;
	@FindBy(id = "message")
	WebElement messagetypearea;
	@FindBy(xpath = "//button[@id='mbryvfoyupcuhxt']")
	WebElement uploadfile;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement send;
    @FindBy(xpath = "//ul[@id='select2-results-3']")
	List<WebElement> dropdownto;
	@FindBy(id = "to_user_id-error")
	WebElement requited_field_error;
	@FindBy(xpath = "//input[@id='s2id_autogen3_search']")
	WebElement dropdowntext;
	@FindBy(xpath = "//div[@class='app-alert-message']")
	WebElement messagesentalert;
	public void clickMessageDashboard() 
	{
	wait.waitForElementToBeClickable(dashboardmessageicon);
	dashboardmessageicon.click();
	}
    public void clickCompose() {
	wait.waitForElementToBeClickable(compose);
	elementutil.clickOnElement(compose);
    //compose.click();
	}
   public void setToDropdown(String towhom) 
	  {
	  wait.waitForElementToBeClickable(todropdownicon);
	  wait.waitForElementToBeVisible(todropdownicon);
	  elementutil.mouseHoverAndClickonElement(todropdownicon);
	  elementutil.sendKeysUsingJavaScript(dropdowntext,towhom);
	  elementutil.pressDownArrow(dropdowntext);
	  elementutil.pressEnter(dropdowntext);
	  }
	 
	public void setSubject(String subjectText) 
	{
		subject.sendKeys(subjectText);
	}

	public void setTypedMessage(String messageText) 
	{
		messagetypearea.sendKeys(messageText);
	}

	public void setSend() 
	{
		wait.waitForElementToBeClickable(send);
		send.click();
	}

public boolean checkIfMessageIsSent() throws TimeoutException 
	{
	    wait.waitForElementToBeVisible(messagesentalert);
		
		if(elementutil.isElementDisplayed(messagesentalert))
		{
		return true;
		}
		else return false;
	}

	public void addMessagePageFields(String toWhom, String subjectText, String messageText) {
		
        this.clickMessageDashboard();
        this.clickCompose();
		this.setToDropdown(toWhom);
		this.setSubject(subjectText);
		this.setTypedMessage(messageText);
		this.setSend();

	}

	

}