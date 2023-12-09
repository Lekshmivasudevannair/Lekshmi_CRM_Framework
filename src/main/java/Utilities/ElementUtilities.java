package Utilities;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtilities {
	
	
	
	    private WebDriver driver;
	    JavascriptExecutor js;
    	WaitUtilities wait;
	    // Constructor to initialize the WebDriver
	    public ElementUtilities(WebDriver driver) {
	    	js=(JavascriptExecutor) driver;
	    	 wait=new WaitUtilities(driver);
	        this.driver = driver;
	    }



	 

	    // Method to enter text into a text field
	    public  void enterText(WebElement element,String text){
	        element.sendKeys(text);
	    }

	   // Method to get the text of a WebElement
	       public String getElementText(WebElement element) {
		        String text = element.getText();
		       
		        return text;
		    }


	    // Method to check if a WebElement is displayed
	    public boolean isElementDisplayed(WebElement element) 
	    {
	        return element.isDisplayed();
	    }
	    //method to check element is enabled
	    public boolean isElementEnabled(WebElement element) {
	        return element.isEnabled();
	    }
	    
	    //click
	    public  void clickOnElement(WebElement element){
	        element.click();
	    }
	    
	    //dropdown with select tag
	    public String selectDrpdown(WebElement element,String value) {
	    	
	    	Select drpobject = new Select(element);
	    	drpobject.selectByVisibleText("value");
			return value;
	    }
	    //vertical scroll to a particular element
	    public Object scrollToElement(WebElement element) 
	    {
	    	
	    	return js.executeScript("arguments[0].scrollIntoView();", (element));
			
	    }
	    //scrollback to the top of the page
	    public Object scrollBack()
	    {
	    	return js.executeScript("window.scrollTo(0, 0)");
	    }
	    
	   //dropdown without select

	   
	    
	    //drop down with select tag
		public void selectDropdown(WebElement element,String towhom)
		{
		
        Select drpobject = new Select(element);
        drpobject.selectByVisibleText(towhom);
      		//drpobject.selectByValue("3");
        //drpobject.selectByIndex(3);
		}
	    public void dropDownWithoutSelect(List<WebElement> elements, String value) {
	        if (elements == null || value == null) {
	            throw new IllegalArgumentException("Input parameters cannot be null");
	        }

	        for (WebElement element : elements) {
	            
	            System.out.println("value is " + value);
	            Actions action=new Actions(driver);
		        action.moveToElement(element).click().build().perform();
		        System.out.println("element is"+element.getText());
	            if (element.getText().trim().equalsIgnoreCase(value.trim())) {
	            	 //js.executeScript("arguments[0].scrollIntoView();", (element));
	            	element.click();
	            	
	                //
	                break; // Assuming you want to exit the loop after finding a match
	            }
	        }
	    }
			//File upload using robot class

	    public void FileUploadUsingRobotClass(WebDriver driver, String path) throws AWTException, InterruptedException
		{
	    	System.out.println("fileupload start");
		   StringSelection s = new StringSelection(path);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		   Robot r = new Robot();
		   Thread.sleep(5000);
		   r.keyPress(KeyEvent.VK_ENTER);
		   r.keyRelease(KeyEvent.VK_ENTER);
		   Thread.sleep(5000);
		   r.keyPress(KeyEvent.VK_CONTROL);
		   r.keyPress(KeyEvent.VK_V);
		   Thread.sleep(5000);
		   r.keyRelease(KeyEvent.VK_CONTROL);
		   r.keyRelease(KeyEvent.VK_V);
		   Thread.sleep(5000);
		   r.keyPress(KeyEvent.VK_ENTER);
		   r.keyRelease(KeyEvent.VK_ENTER);
		}
             //gettitle
				public String getPageTitle(WebDriver driver){
			        String title=driver.getTitle();
			        return title;
			    }
			
			   //alert accept
			public void simpleAlert(WebDriver driver){
			        Alert alert = driver.switchTo().alert();
			        alert.accept();
			    }
			//allert dismiss
			    public void confirmationAlert(WebDriver driver){
			        Alert alert = driver.switchTo().alert();
			        alert.dismiss();
			    }
			    //prompt alert
			    public void promptAlert(WebDriver driver, String text) {
			        Alert alert = driver.switchTo().alert();
			        alert.sendKeys(text);
			        alert.accept();
			    }
			    //javascript executer
			    public void promptAlert(WebElement element) {

			    JavascriptExecutor js=(JavascriptExecutor) driver;
			    js.executeScript("arguments[0].click();",element );  
			    }
			    
		      
			    public void mouseHoverAndClickonElement(WebElement element){
			        Actions action=new Actions(driver);
			        action.moveToElement(element).click().build().perform();
			    }
			    
			    public void fileUpload(WebElement element,String path)
			    {
			    	element.sendKeys(path);
			    }
			    
			    public void sendKeysUsingJavaScript(WebElement element,String text)
			    
			    {
			    	
			    	js.executeScript("arguments[0].value = arguments[1];", element, text);
			    }
			    public void pressEnter(WebElement element)
			    {
			    	element.sendKeys(Keys.ENTER);
			    }
			    public void pressDownArrow(WebElement element)
			    {
			    	element.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
			    }
			    
			    
     public void checkBoxClick(List<WebElement> checkboxes, String checkboxText) 
     {
					for(int i=0;i<checkboxes.size();i++)
					{
						if(checkboxes.get(i).getText().equals(checkboxText))
							js.executeScript("arguments[0].click();",checkboxes.get(i));
						
					}
					
				}
     
     public void radioButtonClick(List<WebElement> radiobuttons, String radioText) 
     {
					for(int i=0;i<radiobuttons.size();i++)
					{
						if(radiobuttons.get(i).getText().equals(radioText))
							js.executeScript("arguments[0].click();",radiobuttons.get(i));
						
					}
					
				}
			    
     public void scrollToBottom()
     {
    	 
     }
	}


