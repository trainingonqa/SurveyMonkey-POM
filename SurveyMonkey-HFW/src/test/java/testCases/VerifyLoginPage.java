package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.LandingPage;
import pages.LoginPage;

public class VerifyLoginPage 
{
WebDriver driver;
	
	@BeforeMethod
	public void setUp() 
	{
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	@Test
	public void checkLandingPage() 
	{
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		
		String title = lp.getAppTitle();
		
		Assert.assertTrue(title.contains("SurveyMonkey"));

				
		lp.clickOnLogInLink();
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.login(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		
		loginpage.verifyCreateSurvey();
	}
	
	@AfterMethod
	public void tearDown() 
	{
		BrowserFactory.closeBrowser(driver);
	}

}
