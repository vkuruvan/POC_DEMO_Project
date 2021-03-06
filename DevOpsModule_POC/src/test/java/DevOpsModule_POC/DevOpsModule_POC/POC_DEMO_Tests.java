package DevOpsModule_POC.DevOpsModule_POC;

import java.sql.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class POC_DEMO_Tests {
	
	WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	boolean rc;
	


public boolean  db_connect()
{
	try
	{
		//System.out.println("test");
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//System.out.println("after connecting");
		//System.out.println("Driver connected sucessfully");
		//DriverManager.setLoginTimeout(10);
		
		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=lnxdb-stg-vm-347-vip.cisco.com)(PORT=1525))(ADDRESS=(PROTOCOL=TCP)(HOST=lnxdb-stg-vm-346-vip.cisco.com)(PORT=1525)))(CONNECT_DATA=(SERVICE_NAME=ALMSTG.cisco.com)(SERVER=DEDICATED)))","QACAUTOUSR","1b37W96e");
		//System.out.println("DB Connected sucessfully");
		
		//Statement stmt = con.createStatement();	
		
		//System.out.println("Started feteching the quries");
		
		//Table Resultdata = (Table) stmt.executeQuery("select * from  cits_asr12_testdata  where SCENARIO_NAME='CRM_Acc_Opp_Creation'");
		
		Class.forName("oracle.jdbc.OracleDriver");
		//Class.forName("oracle.jdbc.driver.OracleDriver");  
		//DriverManager.setLoginTimeout(10);
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=lnxdb-stg-vm-347-vip.cisco.com)(PORT=1525))(ADDRESS=(PROTOCOL=TCP)(HOST=lnxdb-stg-vm-346-vip.cisco.com)(PORT=1525)))(CONNECT_DATA=(SERVICE_NAME=ALMSTG.cisco.com)(SERVER=DEDICATED)))","QACAUTOUSR","1b37W96e");
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=64.101.41.144)(PORT=1541))(ADDRESS=(PROTOCOL=TCP)(HOST=64.101.41.145)(PORT=1541)))(CONNECT_DATA=(SERVICE_NAME=OPSRSTG.cisco.com)(SERVER=DEDICATED)))","ATOMOCUSR","atOM18db");
		if(conn!=null){
		System.out.print("Connection Successful");
		}else{
		System.out.print("Connection Unsuccessful");
		}
		Statement stmt= conn.createStatement();
		String Sname ="CRM_Acc_Opp_Creation";
		String strQuery="select * from  cits_asr12_testdata  where SCENARIO_NAME='"+Sname+"'";
		ResultSet sr = stmt.executeQuery(strQuery);
		while(sr.next())
		{
		String test = sr.getString("TEST_CASE_NAME");
		System.out.println(test);
		}
		return true;
		}
		
	catch(Exception e)
	{
		
		System.out.println("The exception is"+e);
		return false;
	}
}
public boolean create_AccDetails(){
		try
		{
			Thread.sleep(20000);
			WebElement Pcontact = driver.findElement(By.xpath("//input[@id ='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:0:pt1:preferredContactNameId::content']"));
			Pcontact.sendKeys("Shruthi B K");
			
			
			
			Thread.sleep(20000);
			Select type = new Select(driver.findElement(By.xpath("//select[@id ='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:0:pt1:sor1::content']")));
			type.selectByVisibleText("Customer");
			
			//Selecting the address
			Thread.sleep(20000);
			Select Country = new Select(driver.findElement(By.xpath("//select[@id ='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:0:pt1:r4:0:r1:0:s2:LocationCountry::content']")));
			Country.selectByValue("39");
			
			Thread.sleep(20000);
			WebElement Address = driver.findElement(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:0:pt1:r4:0:r1:0:s2:i1:5:inputText2::content']"));
			Address.sendKeys("Postmaster, Post Office CARMELRAM (SUB OFFICE), BANGALORE, KARNATAKA (KA), India (IN), Pin Code:- 560035");
			
			WebElement City = driver.findElement(By.xpath("//input[@id = '_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:0:pt1:r4:0:r1:0:s2:i1:8:inputText6::content']"));
			City.sendKeys("Bangalore");
			
			WebElement State = driver.findElement(By.xpath("//input[@id ='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:0:pt1:r4:0:r1:0:s2:i1:9:inputText9::content']"));
			State.sendKeys("Karnataka");
			
			WebElement postlcode = driver.findElement(By.xpath("//input[@id = '_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:0:pt1:r4:0:r1:0:s2:i1:10:inputText7::content']"));
			postlcode.sendKeys("560035");
			Thread.sleep(20000);
			test.log(LogStatus.PASS, "Enter the Valid Address", "Valid address Entered Sucessfully");
			
			
			 
			Thread.sleep(20000);
			//Clicking on the Save and COntinue
			WebElement button = driver.findElement(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:0:pt1:AP1:cb2']"));
			button.click();
			Thread.sleep(20000);
			test.log(LogStatus.PASS, "Click on the Save and Continue Button", "User Entered the Save and Continue button Sucessfully");
			
			//Getting the Opportunity name and validating the condition
			WebElement AccountName = driver.findElement(By.xpath("//input[@id = '_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:1:pt1:r1:0:r1:0:it4::content']"));
			String AccName = AccountName.getAttribute("value");
			System.out.println("The Account Name is"+AccName);
			
			if(AccName.contains("POC_DEMO_SalesCloud"))
			{
				
			//Creating the opportunity
			System.out.println("Going to click on the Opportunity");
			WebElement opportunity = driver.findElement(By.xpath("//div[@id = '_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:1:pt1:Opportunities::text']"));
			opportunity.click();
			Thread.sleep(15000);
			test.log(LogStatus.PASS, "Click on the Opportunity Button", "Opprtunity button Entered Sucessfully");
			
			WebElement createopp = driver.findElement(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:1:pt1:r4:1:stsSrch:create-opportunity-commandButton']"));
			createopp.click();
			Thread.sleep(10000);
			
		System.out.println("Entered the Opportunity Page");
			
		        Thread.sleep(20000);
				WebElement OppName = driver.findElement(By.xpath("//input[@id ='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:1:pt1:r4:1:r3:0:pt1:it1::content']"));
			    OppName.sendKeys("POC_Demo_Opportunity");
			    test.log(LogStatus.PASS, "Verify the Opportunity Name", "Opprtunity Name entered Sucessfully");
			    
			    
				Thread.sleep(20000);
			    WebElement PrimaryContact = driver.findElement(By.xpath("//input[@id ='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:1:pt1:r4:1:r3:0:pt1:primaryContact::content']"));
			    PrimaryContact.sendKeys("Shruthi B K");
			    
			    Thread.sleep(20000);
			    WebElement Savebutt = driver.findElement(By.xpath("//button[@id = '_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:1:pt1:r4:1:r3:0:pt1:AP1:cb3']"));
			    Savebutt.click();
			    Thread.sleep(20000);
			    
			    WebElement SummrySavebutt = driver.findElement(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:1:pt1:r4:1:r3:1:pt1:object-subtitle:cb11']"));
			    SummrySavebutt.click();
			    Thread.sleep(20000);
			    
			    //Validating the Opportunity name
			    
			    WebElement Oppname = driver.findElement(By.xpath("//input[@id ='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:1:pt1:r4:1:r3:1:pt1:r1:0:name::content']"));
			    String Oppname1 = Oppname.getAttribute("value");
			    System.out.println("The Oppaname is"+Oppname1);
			    
			    //Opoortunity Summary Page
			    Thread.sleep(20000);
			    WebElement OppSave =  driver.findElement(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:1:pt1:r4:1:r3:1:pt1:object-subtitle:cb1']"));
			    OppSave.click();
			    test.log(LogStatus.PASS, "Verify the Opportunity Summay Page Deatails", "Oportunity Summay Page details verified sucessfully");
			    
			    //Opportunities
			    Thread.sleep(20000);
			    WebElement Oppsave1 = driver.findElement(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:1:pt1:object-subtitle:cb8']"));
			    Oppsave1.click();
			    
			}}
		catch(Exception e)
		{
			System.out.println("The excecption is"+e);
			return false;
		}
		return true;
		}

//@BeforeTest
//public void beforeTest() {	
    //}		

@Test
	public void Login () {
		System.out.println("Test1");
		try 
		{
			
			//DB Connection
			
			rc = db_connect();
			Thread.sleep(50000);
			if(rc==true)
			{
				System.out.println("Sucessfully able to get the test data from DB");
			//String Username = (String) Tableresultdata.get(1, "R12_USER_NAME");
			//System.out.println("User name is"+Username);
				
   //Report Generation
				
				extent = new ExtentReports("C:\\Selinium_javadrivers\\Reports\\TestResult.html", true);
				//C:\Selinium_javadrivers\Reports
				
				test = extent.startTest("Launching the browser");
				test.log(LogStatus.INFO, "Browser intiated sucessfully");
			
			//driver = new ChromeDriver();  
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\geckodriver.exe");
			//WebDriver driver = new ChromeDriver();
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--disable-extensions");
			 //options.addArguments("--disable-notifications");
			//options.addArguments("disable-infobars");
		    //driver = new ChromeDriver(options);
		 // options.addArguments("--disable-notifications");
		  //driver.get("https://ejtp.fa.em2.oraclecloud.com/fscmUI/faces/FuseWelcome");
			//Logger.log(LogStatus.INFO, "Browser Started");
		  driver = new FirefoxDriver();
		  System.out.println("Going to lanuch browser");
			 driver.manage().window().maximize();
		  driver.navigate().to("https://ejtp.fa.em2.oraclecloud.com/fscmUI/faces/FuseWelcome");
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
			test.log(LogStatus.PASS, "Enter the User Name", "User Name Entered Sucessfully"+username1);
			
			
			String Password1 = "Ashwitha@123";
	        WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(Password1);
			Thread.sleep(8000);
			System.out.println("Password entered Sucessfully");
			test.log(LogStatus.PASS, "Enter the User Name", "User Name Entered Sucessfully"+Password1);
			
			
			WebElement LoginButton = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
			LoginButton.click();
			Thread.sleep(8000);
			
			System.out.println("Logged in sucessfully");
			test.log(LogStatus.PASS, "Verify user logged in Sucessfully", "User Sucessfully logged in to the Engagement Cloud");
			
			/*WebElement Salesbutton = driver.findElement(By.id("groupNode_sales"));
			System.out.println("Before clicking on the button");
			Salesbutton.click();
			System.out.println("Button got clicked sucessfully");
			Thread.sleep(3000);*/
			
			Thread.sleep(8000);
			WebElement Navigator = driver.findElement(By.xpath("//a[@id = 'pt1:_UISmmLink']"));
			Navigator.click();
			Thread.sleep(30000);
			
			//Creating the Account
			 WebElement Accbutton = driver.findElement(By.xpath("//a[@id = 'pt1:nv_itemNode_service_accounts']"));
			 Accbutton.click();
			 String PageTitle = driver.getTitle();
			 System.out.println("The Title is"+PageTitle);
			 
			if(PageTitle.contains("Accounts"))
			 {
				 System.out.println("Inside the Accounts Page");
				 
				 //Handled the popup window
				 
				 Thread.sleep(20000);
				 WebElement CreateAccbutton = driver.findElement(By.xpath("//button[@id ='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:ls1:cb1']"));
				 CreateAccbutton.click();
				 System.out.println("Sucessfully clicked on the create acc button");
				 Thread.sleep(15000);
				 
				 WebElement Accname = driver.findElement(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_service_accounts:0:_FOTsr1:0:pt1:r22:0:pt1:it1::content']"));
				 Accname.sendKeys("POC_DEMO_SalesCloud");
				 String Acname = "POC_DEMO_SalesCloud";
				 System.out.println("Sucessfully Entered the Account Name");
				 Thread.sleep(20000);
				 test.log(LogStatus.PASS, "Enter the Account Name", "Account Name Entered Sucessfully"+Acname);
				/* WebElement Savebutton = driver.findElement(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:pt1:r22:0:pt1:AP1:cb3']"));
				 Savebutton.click();
				 System.out.println("Sucessfully Created the Account Name");*/
				 
				 System.out.println("started the steps adding address and contact");
				 
				 rc = create_AccDetails();
				 if (rc == true)
				 {
					 System.out.println("Sucessfully added the Opportunity to Account");
				 }
				 
				 }
			 
			 //Logout
			Thread.sleep(10000);
			 WebElement arrowmark = driver.findElement(By.xpath("//a[@id='_FOpt1:_UIScmil1u']"));
			 arrowmark.click();
			 Thread.sleep(10000);
			 WebElement Signout = driver.findElement(By.xpath("//a[@id='_FOpt1:_UISlg1']"));
			 test.log(LogStatus.PASS, "Click on the Signput Button", "User Sucessfully Signed out from the Application");
			 Signout.click();
			 System.out.println("Sucessfully Signed out from the applications");
			 
			 extent.endTest(test);
			 extent.flush();
			 
			 driver.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		}
	//@AfterTest
	//public void afterTest() {
		//driver.quit();			
	//}	
	
}


//https://github.com/deadnight7/OpenWeatherMaps_Webdriver