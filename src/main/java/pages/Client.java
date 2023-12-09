package pages;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Utilities.ElementUtilities;
import Utilities.WaitUtilities;

public class Client {
	
		WebDriver driver;
		WaitUtilities wait;
		ElementUtilities elementutil;
		JavascriptExecutor js;
		public Client(WebDriver driver) 
		{

	        this.driver = driver;
	        wait=new WaitUtilities(driver);//initialising wait object
	        elementutil=new ElementUtilities(driver);
	        js = (JavascriptExecutor) driver;
	        PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//i[@class='fa fa-briefcase']")
		WebElement clienticon;
		@FindBy(xpath="//a[@class='btn btn-default']")
		WebElement addclient;
		@FindBy(id="company_name")
		WebElement companyname;
		@FindBy(id="address")
		WebElement address;
		@FindBy(id="city")
		WebElement city;
		@FindBy(xpath="//button[@class='btn btn-primary']")
		WebElement save;
		@FindBy(xpath="//a[@class='paginate_button current']")
		WebElement lastpageoftable;
		@FindBy(xpath="//select[@name='client-table_length']")
		WebElement tablelength;
		@FindBy(xpath="//input[@type='search']")
	    WebElement search;
		@FindBy(xpath="//button[@class='close']")
		WebElement close;
		@FindBy(xpath="//table[@id='client-table']//tr[1]//td[2]")
		WebElement company_name_in_table;
		
		
		
		
		public void clickClientIconInDashboard()
		{
			wait.waitForElementToBeClickable(clienticon);
			wait.waitForElementToBeVisible(clienticon);
			elementutil.clickOnElement(clienticon);
		}
		public void clickAddClientButton()
		{
			wait.waitForElementToBeClickable(addclient);
			wait.waitForElementToBeVisible(addclient);
			elementutil.clickOnElement(addclient);
		}
		public void setCompanyName(String nameofcompany)
		{
			
			wait.waitForElementToBeVisible(companyname);
			elementutil.enterText(companyname,nameofcompany);
			
		}
		public void setAddress(String companyaddress)
		{
			
			wait.waitForElementToBeVisible(address);
			elementutil.enterText(address,companyaddress);
		}	
		public void setCity(String cityname)
		{
			
			wait.waitForElementToBeVisible(city);
			elementutil.enterText(city,cityname);
			
		}
		public void clickSave()
		{
			wait.waitForElementToBeClickable(save);
			wait.waitForElementToBeVisible(save);
			elementutil.clickOnElement(save);
			
		}
			
	
				

public void searchClient(String nameofcompany) 
{
	String companyname=nameofcompany;
	
try {
	
		wait.waitForElementToBeClickable(search);
		elementutil.mouseHoverAndClickonElement(search);
		//js.executeScript("arguments[0].value = arguments[1];", search, nameofcompany);
		elementutil.sendKeysUsingJavaScript(search, nameofcompany);
        close.click();
		search.sendKeys(Keys.ENTER);

	} catch (Exception e) {
	    e.printStackTrace();
	}

	try {
		wait.waitForElementToBeVisible(search);
		
		}   catch (Exception e) {
	    e.printStackTrace();
	}
	
	
}
public boolean checkIfClientIsPresentInTable(String nameofcompany) {
	
		String company=elementutil.getElementText(company_name_in_table);
		if(company.equalsIgnoreCase(nameofcompany))
		{
			
			return true;
		}
		return false;
}



		public void addingClientDetails(String nameofcompany,String companyaddress,String cityname) 
		{   
			
		    this.clickClientIconInDashboard();
		    this.clickAddClientButton();
			this.setCompanyName(nameofcompany);
			this.setAddress(companyaddress);
			this.setCity(cityname);
			this.clickSave();
			this.searchClient(nameofcompany);
		}
		
}

