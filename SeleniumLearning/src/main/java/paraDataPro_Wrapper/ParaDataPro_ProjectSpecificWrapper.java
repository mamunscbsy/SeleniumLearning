package paraDataPro_Wrapper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;



public class ParaDataPro_ProjectSpecificWrapper {

	
		public ChromeDriver driver;
			
		@Parameters({"url","uname","pwd"})
		
		@BeforeMethod
		//public void login() {
		public void login(String url,String uname,String pwd) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\mamun\\Selenium\\Selenium\\drivers\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver","./drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
			
			//Maximize
			driver.manage().window().maximize();
			
			//Load URL
			//driver.get("http://leaftaps.com/opentaps");
			driver.get(url);
			
			//Implicit wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Enter Username 
			//driver.findElementById("username").sendKeys("DemoSalesManager");
			driver.findElementById("username").sendKeys(uname);
			
			//Enter Password 
			//driver.findElementById("password").sendKeys("crmsfa");
			driver.findElementById("password").sendKeys(pwd);
			
			// Click Login Button 
			driver.findElementByClassName("decorativeSubmit").click();
			
			// click crm.sfa link
			driver.findElementByLinkText("CRM/SFA").click();
			
			}
		
		@AfterMethod
		public void closeBrowser() {
			driver.close();
		}
		
		@DataProvider
		//public void getData() {
		public String[][] getData() {
			
		
			String[][] data = new String[2][3];
			
			data[0][0] = "TCS";
			data[0][1] = "Rumman";
			data[0][2] = "Chowdhury";
			
			data [1][0] = "ABC";
			data [1][1] = "Nasir";
			data [1][2] = "Uddin";
						
			return data;
		}

	}


