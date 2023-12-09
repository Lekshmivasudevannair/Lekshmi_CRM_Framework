package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constants.Constant;
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
		WebElement ticket_icon;
		@FindBy(xpath="//a[@class='btn btn-default']")
		WebElement addticket_button;
		@FindBy(xpath="//input[@id='title']")
		WebElement tittle_field;
		@FindBy(xpath="(//span[@class='select2-arrow'])[4]")
		WebElement client_arrowbutton;
		@FindBy(xpath="//*[@id=\"s2id_autogen7_search\"]")
				
				
		WebElement client_textbox;
		@FindBy(xpath="//textarea[@id='description']")
		WebElement description_textarea;
		@FindBy(xpath="//i[@class='fa fa-camera']")
		WebElement uploadfile_icon;
		@FindBy(xpath="//button[@type=\"submit\"]")
		WebElement save_button;
		@FindBy(xpath="(//button[@class='btn btn-default dropdown-toggle  mt0 mb0']//following-sibling::ul/li//following-sibling::li[2])[1]")
		WebElement assigned_to_me;
		@FindBy(xpath="	//img[@class=\"upload-thumbnail-sm\"]")
		WebElement image;
		
		
		public void clickTicketIconFromDashBoard() 
		{
		wait.waitForElementToBeClickable(ticket_icon);
		elementutil.clickOnElement(ticket_icon);
		}
	    public void clickAddTickeButton() 
	    {
		wait.waitForElementToBeClickable(addticket_button);
		elementutil.clickOnElement(addticket_button);
	    }
		public void setTittle(String tittle)
		{
			elementutil.sendKeysUsingJavaScript(tittle_field,tittle);	
		}
		public void setClient(String client)
		
			{   
			
			System.out.println(client);
				  wait.waitForElementToBeClickable(client_arrowbutton);
				  wait.waitForElementToBeVisible(client_arrowbutton);
			      elementutil.mouseHoverAndClickonElement(client_arrowbutton);
				  wait.waitForElementToBeVisible(client_textbox);
				  elementutil.sendKeysUsingJavaScript(client_textbox,client);
				  elementutil.pressDownArrow(client_textbox);
				  elementutil.pressEnter(client_textbox);
		}
		public void setDescription(String description)
		{
			elementutil.sendKeysUsingJavaScript(description_textarea,description);	
		}
		
		public void uploadFile() throws AWTException, InterruptedException
		{
			
			elementutil.clickOnElement(uploadfile_icon);
			elementutil.FileUploadUsingRobotClass(driver,Constant.FILEUPLOAD_PATH);
			
		}
		public void clickSave()
		{
			elementutil.clickOnElement(save_button);
		}
		public boolean VerifyIfTheImageIsUploaded() 
		{
			if(elementutil.isElementDisplayed(image))
			{
				return true;
						
			}
		return false;
	}
	
		
		
		
		public void addingTicket(String tittle, String client, String description) throws AWTException, InterruptedException {
			this.clickTicketIconFromDashBoard();
			this.clickAddTickeButton();
			this.setTittle(tittle);
			this.setClient(client);
			this.setDescription(description);
			this.uploadFile();
			//this.clickSave();		
			
		}
		
		
		
		
		
		
}
