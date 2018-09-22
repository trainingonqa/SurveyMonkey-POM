package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage 
{
WebDriver driver;
	
	public LandingPage(WebDriver ldDriver)
	{
		this.driver = ldDriver;
	}
	
	@FindBy(xpath="//a[@class='log-in static-buttons']") WebElement loginlink;
	@FindBy(xpath="//a[@class='sign-up static-buttons']") WebElement signuplink;
		
	public void clickOnLogInLink()
	{
		loginlink.click();
	}
	
	public void clickOnSignUpLink()
	{
		signuplink.click();
	}
	
	public String getAppTitle() {
		return driver.getTitle();
		
	}
}
