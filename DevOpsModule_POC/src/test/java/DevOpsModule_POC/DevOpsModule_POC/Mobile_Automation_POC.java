package DevOpsModule_POC.DevOpsModule_POC;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Mobile_Automation_POC {
	AndroidDriver driver;

	@Test(priority = 1)
	public boolean Mobile_Automation()
	{
		try
		{
			
			//Desired cappalities
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName","MIA2");
	        capabilities.setCapability("platformVersion", "8.1.0");
	        capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("appium-version", "1.0");
	        
	        //App to be testted
	        capabilities.setCapability("app", "C:\\Users\\vkuruvan\\Downloads\\Wikipedia.apk");
	        
	        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
	        
	        driver.quit();
	        
	        }
		catch(Exception e)
		{
			System.out.println("Exception");
			return false;
		}
		return true;
	}
}
