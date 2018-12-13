package DevOpsModule_POC.DevOpsModule_POC;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Mobile_Automation_POC {
	AndroidDriver driver;

	@Test
	public void Mobile_Automation()
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
	        
	        System.out.println("Starting inputting the data in to mobile app");
	        
	       // String MobileTitel = driver.getTitle();
	      //  System.out.println("The Title is"+MobileTitel);
	        driver.findElement(By.id("org.wikipedia:id/search_container")).clear();
	        Thread.sleep(5000);
	        driver.findElement(By.id("org.wikipedia:id/search_container")).sendKeys("Wipro Technologies");
	        System.out.println("Input data  entred sucessfully");
	        
	        Thread.sleep(10000);
	        driver.quit();
	        
	        }
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception");
		}
	}
}
