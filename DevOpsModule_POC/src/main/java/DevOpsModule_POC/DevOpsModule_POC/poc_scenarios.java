package DevOpsModule_POC.DevOpsModule_POC;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class poc_scenarios {

	public boolean Logout_Function()
	{
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("The exception is"+e);
			return false;
		}
		return true;
		
	}


	public static void main(String args[]) throws InterruptedException
	//System.setProperty("","C:\\Selinium_javadrivers\\");
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selinium_javadrivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		 options.addArguments("--disable-notifications");
		//options.addArguments("disable-infobars");
        WebDriver driver = new ChromeDriver(options);
      options.addArguments("--disable-notifications");
      System.out.println("Going to lanuch browser");
      driver.manage().window().maximize();
      driver.get("https://ejtp.fa.em2.oraclecloud.com/fscmUI/faces/FuseWelcome");
		System.out.println("Browser Lanuched sucessfully");

		//Login Function
		String Title = driver.getTitle();
		System.out.println("The Page Title is"+Title);
		Thread.sleep(8000);
		
		String username1 = "ashwitha.1@wipro.com";
		WebElement username = driver.findElement(By.id("userid"));
		username.sendKeys(username1);
		Thread.sleep(8000);
		System.out.println("User Name entered sucessfully");
		
		String Password1 = "Ashwitha@123";
        WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(Password1);
		Thread.sleep(8000);
		System.out.println("Password entered Sucessfully");
		
		
		WebElement LoginButton = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
		LoginButton.click();
		Thread.sleep(8000);
		
		System.out.println("Logged in sucessfully");
		
		/*WebElement Salesbutton = driver.findElement(By.id("groupNode_sales"));
		System.out.println("Before clicking on the button");
		Salesbutton.click();
		System.out.println("Button got clicked sucessfully");
		Thread.sleep(3000);*/
		
		WebElement Navigator = driver.findElement(By.xpath("//a[@id = 'pt1:_UISmmLink']"));
		Navigator.click();
		Thread.sleep(3000);
		
		//Creating the Account
		 WebElement Accbutton = driver.findElement(By.xpath("//a[@id = 'pt1:nv_ZCM_CUSTOMERCTRINFRA360_CUSTOMERS_CRM_CARD']"));
		 Accbutton.click();
		 String PageTitle = driver.getTitle();
		 System.out.println("The Title is"+PageTitle);
		 
		if(PageTitle.contains("Accounts"))
		 {
			 System.out.println("Inside the Accounts Page");
			 
			 //Handled the popup window
			 
			 Thread.sleep(10000);
			 WebElement CreateAccbutton = driver.findElement(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:pt1:ls1:cb1']"));
			 CreateAccbutton.click();
			 System.out.println("Sucessfully clicked on the create acc button");
			 Thread.sleep(8000);
			 
			 WebElement Accname = driver.findElement(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:pt1:r22:0:pt1:it1::content']"));
			 Accname.sendKeys("POC_DEMO1");
			 System.out.println("Sucessfully Entered the Account Name");
			 Thread.sleep(8000);
			 WebElement Savebutton = driver.findElement(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:pt1:r22:0:pt1:AP1:cb3']"));
			 Savebutton.click();
			 System.out.println("Sucessfully Created the Account Name");
			 }
		 
		 //Logout
		Thread.sleep(10000);
		 WebElement arrowmark = driver.findElement(By.xpath("//a[@id='_FOpt1:_UIScmil1u']"));
		 arrowmark.click();
		 Thread.sleep(10000);
		 WebElement Signout = driver.findElement(By.xpath("//a[@id='_FOpt1:_UISlg1']"));
		 Signout.click();
		 System.out.println("Sucessfully Signed out from the application");
		 driver.close();
	}
}
