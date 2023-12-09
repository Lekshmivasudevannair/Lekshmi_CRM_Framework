package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentUtilities 
{

public static synchronized ExtentReports createExtentReprt() 
{
	 
		String path=System.getProperty("user.dir")+"\\extent-report\\extent-report.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web automation result");
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
	 
		return extent;
		
	}
	
	

}
