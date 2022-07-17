package TestPack;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import PomPack.Header;
import PomPack.LogIn;

public class TestBank 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","D:\\automation\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		driver.get("https://parabank.parasoft.com/");
		
		LogIn log=new LogIn(driver);
		log.enterPass();
		log.enterUser();
		log.clickSubmit();
		
		Header head=new Header(driver);
		head.clickOpen();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		if(url.equals("https://parabank.parasoft.com/parabank/openaccount.htm")||title.equals("ParaBank | Open Account"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("fail");
		}
		head.clickOnLogout();
		
		log.enterPass();
		log.enterUser();
		log.clickSubmit();
		
		head.clickAccount();
		url=driver.getCurrentUrl();
		title=driver.getTitle();
		if(url.equals("https://parabank.parasoft.com/parabank/overview.htm") ||title.equals("ParaBank | Accounts Overview"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		head.clickOnLogout();
		
		log.enterPass();
		log.enterUser();
		log.clickSubmit();
		
		head.transferFunds();
		url=driver.getCurrentUrl();
		title=driver.getTitle();
		if(url.equals("https://parabank.parasoft.com/parabank/transfer.htm")||title.equals("ParaBank | Transfer Funds"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		head.clickOnLogout();
		
		log.enterPass();
		log.enterUser();
		log.clickSubmit();
		
		head.clickOnBillPay();
		url=driver.getCurrentUrl();
		title=driver.getTitle();
		if(url.equals("https://parabank.parasoft.com/parabank/billpay.htm")||title.equals("ParaBank | Bill Pay"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		head.clickOnLogout();
		
		
		
		
		
		
		
	}

}
