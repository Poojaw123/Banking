package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass 
{
	public static WebDriver openChrome()
	{
		System.setProperty("webdriver.chrome.driver","D:\\automation\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
		
	}
	public static WebDriver openFirefox()
	{
		System.setProperty("webdriver.gecko.driver","D:\\automation\\geckodriver-v0.31.0-win64 (1)\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}

}
