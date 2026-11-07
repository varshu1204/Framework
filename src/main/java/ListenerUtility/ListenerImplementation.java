package ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import BaseTest.BaseClass;

public class ListenerImplementation implements ITestListener,ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		
		Reporter.log("report config",true);
	}

	@Override
	public void onFinish(ISuite suite) {
		
		Reporter.log("report backup",true);

	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		Reporter.log("==="+testName+"Execution STARTED===",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		Reporter.log("==="+testName+"Execution SUCCESS===",true);
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Date date=new Date();
		String NewDate = date.toString().replace(" ","_").replace(":","_");


		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Screenshots/SS_"+NewDate+".png");
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String testName = result.getMethod().getMethodName();
		Reporter.log("==="+testName+"Execution FAILED===",true);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		Reporter.log("==="+testName+"Execution SKIPPED===",true);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
