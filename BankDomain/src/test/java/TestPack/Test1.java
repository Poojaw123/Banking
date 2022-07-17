package TestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import Base.BaseClass;
import PomPack.Header;
import PomPack.LogIn;

public class Test1 
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
	public void createPomObj()
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
		head.clickOpen();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(url,"https://parabank.parasoft.com/parabank/openaccount.htm" );
		soft.assertEquals(title, "ParaBank | Open Account");
		
		
	}
	@Test
	public void clickAccount()
	{
		head.clickAccount();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(url,"https://parabank.parasoft.com/parabank/overview.htm" );
		soft.assertEquals(title, "ParaBank | Accounts Overview");
		
		
		
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
