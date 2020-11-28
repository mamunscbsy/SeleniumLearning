package fiveTestCasesTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EditLead {
	
	@Test
	public void editLead() throws InterruptedException {
		
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mamun\\Selenium\\Selenium\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//maximize
		driver.manage().window().maximize();
		
		//load URL
		driver.get("http://leaftaps.com/opentaps");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Enter Username - (Element level)
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		//Enter Password - (Element level)
		driver.findElementById("password").sendKeys("crmsfa");
		
		// Click Login Button - (Element level)
		driver.findElementByClassName("decorativeSubmit").click();
		
		// click crm.sfa link
		driver.findElementByLinkText("CRM/SFA").click();
		
		//click leads link
		driver.findElementByLinkText("Leads").click();
		
		Thread.sleep(2000);
		//click Find leads link
		driver.findElementByLinkText("Find Leads").click();
		
		//Enter first name
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Hema");
		
		//click Find lead button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
	//	ExplicitlyWait-WebDriverWait
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")));
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")));
			
		Thread.sleep(2000);
		//click on first resulting lead
		
		String LeadId = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").getText();
		System.out.println(LeadId);
		
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		
		Thread.sleep(3000);
		//Verify title of the page
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("View")) {
			System.out.println("Title matched");
		} else {
			System.out.println("Not Matches");
		}
		
		//Click Edit
		driver.findElementByXPath("//a[text()='Edit']").click();
		
		//Change the company name
		driver.findElementById("updateLeadForm_companyName").sendKeys("S");
		
		//Click Update
		driver.findElementByXPath("//input[@value='Update']").click();
		
		//Confirm the changed name appears
		 String changedName = driver.findElementById("viewLead_companyName_sp").getText();
		  System.out.println(changedName);
	 
		  if(changedName.contains("tcs")) {
		  System.out.println("Name is matched"); 
		  
		  } else {
		 System.out.println("Not matched");
		 }
						
		//Close the browser (Do not log out)
		driver.close();
		
	}

}
