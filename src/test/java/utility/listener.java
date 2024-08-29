package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import basemethod.basemethod;

public class listener extends basemethod implements ITestListener {
  
	ExtentReports extent=extentreport.getreport();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName())
				.assignAuthor("Harini")
				.assignDevice("chrome");
		
		test.log(Status.PASS, "test Started : "+result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String filepath=null;
		
		try {
			filepath=takeScreenshot(result.getMethod().getMethodName());
			System.out.println(filepath);
		}catch(Exception e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skipped"+result.getMethod().getMethodName());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		test.log(Status.FAIL,"on Test Failed But Within Success Percentage :"+result.getMethod().getMethodName());
	}
	
//	@Override
//	public void onStart(ITestContext context) {
//		test.log(Status.INFO, "test Started : "+context.getName());
//	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
