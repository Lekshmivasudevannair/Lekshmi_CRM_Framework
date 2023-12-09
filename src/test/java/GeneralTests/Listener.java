package GeneralTests;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentUtilities;
import testcrmproject.TestBase;

public class Listener extends TestBase implements ITestListener
{
 //ExtentUtilities ext;
 ExtentTest test;
 ExtentReports extent=ExtentUtilities.createExtentReprt();
 ThreadLocal<ExtentTest>extentTest=new ThreadLocal<ExtentTest>();
 
 public void onTestStart(ITestResult result) {
    
     test = extent.createTest(result.getMethod().getMethodName());
     extentTest.set(test);
 }
 public void onTestSuccess(ITestResult result) {
    
     extentTest.get().log(Status.PASS, "Test Passed"); 
 }
 public void onTestFailure(ITestResult result) {
     extentTest.get().log(Status.FAIL, "Test Failed"); 
 }

 public void onTestSkipped(ITestResult result) {
     extentTest.get().log(Status.SKIP, "Test Skipped"); 
 }
 
}
