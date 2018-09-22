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

public class VerifyLandingPage 
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
	}
	
	@AfterMethod
	public void tearDown() 
	{
		BrowserFactory.closeBrowser(driver);
	}

}
