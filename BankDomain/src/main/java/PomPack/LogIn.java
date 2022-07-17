package PomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn
{
	@FindBy (xpath="//input[@type='text']")
	WebElement user;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy (xpath="//input[@type='submit']")
	WebElement submit;
	
	public LogIn(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void enterUser()
	{
		user.sendKeys("pooja");
	}
	public void enterPass()
	{
		password.sendKeys("pooja123");
	}
	public void clickSubmit()
	{
		submit.click();
	}
}
