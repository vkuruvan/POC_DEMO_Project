package DevOpsModule_POC.DevOpsModule_POC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class VSTS_INTIGRATION {
	WebDriver driver;
	
	public void login()
	{
	try
	{
		//driver = new ChromeDriver();  
	  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  System.out.println("Going to lanuch browser");
	  driver.manage().window().maximize();
	  driver.navigate().to("https://dev.azure.com/vinayks222/New_Project");
	  System.out.println("Browser Lanuched sucessfully");

		
	}
	catch(Exception e)
	{
		System.out.println("The exception is"+e);
	}
	}
	
}
