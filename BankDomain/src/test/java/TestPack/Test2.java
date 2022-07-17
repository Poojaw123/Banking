package TestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseClass;
import PomPack.Header;
import PomPack.LogIn;

public class Test2 
{
	WebDriver driver;
	LogIn log;
	Header head;
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver=BaseClass.openChrome();
		}
		if(browserName.equals("Firefox"))
		{
			driver=BaseClass.openFirefox();
		}
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
	}
	@BeforeClass
	public void launch()
	{
	 log=new LogIn(driver);
	 head=new Header(driver);
	}
	@BeforeMethod
	public void login() 
	{
		driver.get("https://parabank.parasoft.com/");
		
		log.enterPass();
		log.enterUser();
		log.clickSubmit();
		
	     
		
	}
	@Test
	public void clickOpen()
	{
		head.transferFunds();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(url, "https://parabank.parasoft.com/parabank/transfer.htm");
		soft.assertEquals(title,"ParaBank | Transfer Funds");
			
	}
	@Test
	public void clickAccount()
	{
		head.clickOnBillPay();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(url,"https://parabank.parasoft.com/parabank/billpay.htm");
		soft.assertEquals(title,"ParaBank | Bill Pay");
		
	}
	
	@AfterMethod
	public void logOut()
	{
		head.clickOnLogout();
	}
	@AfterClass
	public void clearObj()
	{
		log=null;
		head=null;
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}

}
