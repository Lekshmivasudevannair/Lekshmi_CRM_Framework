package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ElementUtilities;
import Utilities.WaitUtilities;
public class DashBoardOfCrm {
 WebDriver driver;
 WaitUtilities wait;
 ElementUtilities elementutil;

public DashBoardOfCrm(WebDriver driver) 
{
this.driver = driver;
wait = new WaitUtilities(driver);// initialising wait object
elementutil = new ElementUtilities(driver);
PageFactory.initElements(driver, this);
}
		
@FindBy(xpath="//img[@class='dashboard-image']")
WebElement loginchecktodashboard;
@FindBy(xpath="//a[@id='timecard-clock-out']")
WebElement clockout;
@FindBy(id="note")
WebElement notearea;
@FindBy(xpath="//button[@class='btn btn-primary']")
WebElement savenote;
@FindBy(xpath="//a[@title='Clock In']")
WebElement clockIn;



public boolean loginCheckToDashboard()
	        {
			 
			 if (elementutil.isElementDisplayed(loginchecktodashboard)==true)
			 {
				 return true;
			 
			 }
			 else
			return false;
			 
	       }

public void clickClockoutButton()
{
wait.waitForElementToBeVisible(clockout);
wait.waitForElementToBeClickable(clockout);
elementutil.clickOnElement(clockout);
}
public void clickClockInButton()
{
wait.waitForElementToBeVisible(clockIn);
wait.waitForElementToBeClickable(clockIn);
elementutil.clickOnElement(clockIn);
}
public void setNote(String noteText)
{
	wait.waitForElementToBeVisible(notearea);
	wait.waitForElementToBeClickable(notearea);
	elementutil.mouseHoverAndClickonElement(notearea);
	elementutil.sendKeysUsingJavaScript(notearea,noteText);
}
public void saveNote()
{
	wait.waitForElementToBeVisible(savenote);
	wait.waitForElementToBeClickable(savenote);
	elementutil.clickOnElement(savenote);
}
public boolean checkIfAfterClockoutNoteGivenButtonChangedToClockin()
{
	wait.waitForElementToBeVisible(clockIn);
	wait.waitForElementToBeClickable(clockIn);
	if(elementutil.isElementDisplayed(clockIn))
	{ System.out.println(elementutil.isElementDisplayed(clockIn));
		return true;
	}
	System.out.println("false");
	return false;
	
}
public void addClocNoteInDashBoard(String noteText)
{
	this.clickClockoutButton();
	this.setNote(noteText);
	this.saveNote();
	this.clickClockInButton();
}

}




