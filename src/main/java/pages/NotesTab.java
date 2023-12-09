package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ElementUtilities;
import Utilities.WaitUtilities;

public class NotesTab {
	WebDriver driver;
	WaitUtilities wait;
	ElementUtilities elementutil;
	JavascriptExecutor js;
	public NotesTab(WebDriver driver) 
		{
		
	        this.driver = driver;
	        wait=new WaitUtilities(driver);//initialising wait object
	        elementutil=new ElementUtilities(driver);
	        js = (JavascriptExecutor) driver;
	        PageFactory.initElements(driver, this);
	     }
	@FindBy(xpath="//a[contains(@href,'notes')]")
	WebElement notesbutton;
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement addnotes;
	@FindBy(id="title")
	WebElement title_notes;
	@FindBy(id="description")
	WebElement description_notes;
	@FindBy(xpath="//ul[@class='select2-choices']")
	WebElement labels;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save_notes;
	@FindBy(xpath="//input[@type='search']")
	WebElement notes_search;
	@FindBy(xpath="//ul[@class='select2-results']")
	List<WebElement> label_options;
	@FindBy(xpath="//a[@class='paginate_button current']")
	WebElement firstpageoftable;
	@FindBy(xpath="//table[@id='note-table']//tr[1]//td[2]")
	WebElement tabletittle;
	@FindBy(xpath="//a[@class='delete'][1]")
	WebElement deletenote;
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement deletebutton;
	@FindBy(xpath="//div[@class='app-alert-message']")
	WebElement deletedmessagealert;
public void clickNotes()
{
	wait.waitForElementToBeClickable(notesbutton);
	notesbutton.click();	
}	

public void clickAddNotes()
{
	addnotes.click(); 
}
public void setTittle(String tittle)
{
	title_notes.sendKeys(tittle);
}
public void setDescription(String description)
{
	description_notes.sendKeys(description);
}
/*public void setLabel(String labeltext)
{
	wait.waitForElementToBeVisible(labels);
	labels.click();
	elementutil.dropDownWithoutSelect(label_options,labeltext);
 }
*/
public void verifyIfNoteIsAdded(String tittletext)
{
	
try {
		wait.waitForElementToBeClickable(notes_search);
	    // notes_search.click();
	} catch (Exception e) {
	    e.printStackTrace();
	}

	try {
		wait.waitForElementToBeVisible(notes_search);
		js.executeScript("arguments[0].value = arguments[1];",  notes_search, tittletext);
	    //notes_search.sendKeys(tittletext);
	}   catch (Exception e) {
	    e.printStackTrace();
	}
	
}
public void saveNotes()
{
	save_notes.click();
}
public void clickFirstPageOfTable() throws InterruptedException
{   
   
	elementutil.scrollToElement(firstpageoftable);
	wait.waitForElementToBeClickable(firstpageoftable);
    firstpageoftable.click();
    Thread.sleep(1000);
    elementutil.scrollBack();
    System.out.println("Scrolled back to the top");
}
public boolean checkTableTittle(String tittlepassed)
{
	//System.out.println(tabletittle.getText());
	String tittleofnotes=elementutil.getElementText(tabletittle);
	if(tittleofnotes.equalsIgnoreCase(tittlepassed))
	{
		
		return true;
	}
	return false;
}
public void verifyDeleteNoteIsWorking()
{
	deletenote.click();
	deletebutton.click();
	 
}
public void addNotes(String tittle,String description) throws InterruptedException
{   
	System.out.println("notes");
    this.clickNotes();
    this.clickAddNotes();
	this.setTittle(tittle);
	this.setDescription(description);
	//this.setLabel(labeltext);
	this.saveNotes();
	System.out.println("before");
	this.verifyIfNoteIsAdded(tittle);
	this.clickFirstPageOfTable();
	this.checkTableTittle(tittle);
	this.verifyDeleteNoteIsWorking();
	
}
}