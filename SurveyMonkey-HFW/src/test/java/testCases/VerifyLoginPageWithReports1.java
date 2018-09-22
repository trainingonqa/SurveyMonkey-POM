package testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.LandingPage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPageWithReports1 
{

	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	
	
	@BeforeMethod
	public void setUp() 
	{
		reports = new ExtentReports("./Results/LoginPageReport.html",true);
		
		logger = reports.startTest("Verify Test Login");
		
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	@Test
	public void checkLandingPage() 
	{
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		
		String title = lp.getAppTitle();
		
		Assert.assertTrue(title.contains("SurveyMonkey"));
		
		logger.log(LogStatus.PASS, "Landing Page is opened and verified");
		
		lp.clickOnLogInLink();
		
		logger.log(LogStatus.INFO, "Clicked on LOG IN link");
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.login(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		
		logger.log(LogStatus.INFO, "Logged into the application");
		
		loginpage.verifyCreateSurvey();
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.CaptureScreenShot(driver, "Validation2")));
		
		logger.log(LogStatus.PASS, "CREATE SURVEY link is displayed");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = Helper.CaptureScreenShot(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser(driver);
		reports.endTest(logger);
		reports.flush();
	}
}
