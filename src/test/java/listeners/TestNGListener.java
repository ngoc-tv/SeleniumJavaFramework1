package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
	public void  onTestStart(ITestResult result) {
		System.out.println("********* Test Started "+ result.getName());
	}
	
	public void  onTestSuccess(ITestResult result) {
		System.out.println("********* Test Success "+ result.getName());
	}
	
	public void  onTestFailure(ITestResult result) {
		System.out.println("********* Test Failure "+ result.getName());
	}
	
	public void  onFinish(ITestContext context) {
		System.out.println("********* Test Finish "+ context.getName());
	}
}
