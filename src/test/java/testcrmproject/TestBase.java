
package testcrmproject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.github.dockerjava.api.model.Driver;

import Constants.Constant;

public class TestBase {

	WebDriver driver;
    public static Properties prop = new Properties();

    @BeforeMethod
    @Parameters({"Browser"})
    public void setUpDriverOpenUrl(String browser) throws IOException {
    	if (driver == null) {
        	System.out.println("The Path is "+System.getProperty("user.dir"));
            FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
            prop.load(fr);
        
        }

        // Rest of your browser setup remains the same
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Enter correct browser");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Retrieve the URL from the properties file
        String url = prop.getProperty("url");
        if (url != null && !url.isEmpty()) {
            driver.get(url);
            driver.manage().window().maximize();
        } else {
            System.out.println("URL not found in properties file");
        }
        
        }
    
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
           takeScreenShotOnFailure(iTestResult.getName());

        }
		
		/*
		 * //Quit the WebDriver instance if (driver != null) { driver.quit();
		 * 
		 * }
		 */
				 
     }
	public String takeScreenShotOnFailure(String name) throws IOException {
		   String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());


		   File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//takes screenshot

		   String destination =Constant.SCREENSHOT_PATH + name + dateName + ".png";


		   File finalDestination = new File(destination);

		   FileUtils.copyFile(source, finalDestination);
		   return destination;
}
	 
}
		

	