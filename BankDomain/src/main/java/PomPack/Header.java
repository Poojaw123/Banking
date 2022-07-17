package PomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header 
{
	//Pom classes for Banking domain
	@FindBy (xpath="//a[text()='Open New Account']")
	WebElement open;
	
	@FindBy (xpath="//a[text()='Accounts Overview']")
	WebElement account;
	
	@FindBy (xpath="//a[text()='Transfer Funds']")
	WebElement transfer;
	
	@FindBy (xpath="//a[text()='Bill Pay']")
	WebElement billPay;
	
	@FindBy (xpath="//a[text()='Log Out']")
	WebElement logOut;
	
	public Header(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void clickOpen()
	{
		open.click();
	}
	public void clickAccount()
	{
		account.click();
	}
	public void transferFunds()
	{
		transfer.click();
	}
	public void clickOnBillPay()
	{
		billPay.click();
	}
	public void clickOnLogout()
	{
		logOut.click();
	}
}
