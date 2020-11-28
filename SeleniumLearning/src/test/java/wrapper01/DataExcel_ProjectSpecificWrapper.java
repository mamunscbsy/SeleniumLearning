package wrapper01;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.ReadExcel;



public class DataExcel_ProjectSpecificWrapper {
	

	public ChromeDriver driver;
	
	
	@Parameters({"url","uname","pwd"})
	@BeforeMethod
	
	//public void login() {
	
	public void login(String url,String uname,String pwd) {
		
		
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\mamun\\Selenium\\Selenium\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "c:./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		
		//maximize
		driver.manage().window().maximize();
		
		//load URL
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
	public String[][] getData() throws IOException {
			
		ReadExcel r1 = new ReadExcel();
		    return r1.readExcel();
		
	}

}
