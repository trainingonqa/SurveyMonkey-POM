package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver ldriver) 
	{
		this.driver = ldriver;
	}
	
	@FindBy(id="username") WebElement UserName;
	@FindBy(id="password") WebElement Password;
	@FindBy(xpath = "//button[@type='submit']") WebElement LoginBtn;
	@FindBy(xpath = "//a[contains(@class,'create-survey alt btn SL_split')]") WebElement CreateSurvey;
	
	By createsurvey = By.xpath("//a[contains(@class,'create-survey alt btn SL_split')]");
	
	public void login(String userName,String passWord) 
	{
		UserName.sendKeys(userName);
		Password.sendKeys(passWord);
		LoginBtn.click();
	}
	
	public void verifyCreateSurvey()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(createsurvey));
		
		String text = ele.getText();
		
		Assert.assertEquals(text, "CREATE SURVEY","CREATE SURVEY link is not displayed");
		
	}
}
