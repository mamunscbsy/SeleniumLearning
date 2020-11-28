package fiveTestCasesTestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DuplicateLead {

	@Test

	public void duplicateLead() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// maximize
		driver.manage().window().maximize();

		// load URL
		driver.get("http://leaftaps.com/opentaps");

		// Enter Username - (Element level)
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//driver.findElementById("password").sendKeys("DemoSalesManager");
		
		// Enter Password - (Element level)
		driver.findElementById("password").sendKeys("crmsfa");

		// Click Login Button - (Element level)
		driver.findElementByClassName("decorativeSubmit").click();

		// click crm.sfa link
		driver.findElementByLinkText("CRM/SFA").click();

		// click Leads
		driver.findElementByLinkText("Leads").click();

		// click Find lead link
		driver.findElementByLinkText("Find Leads").click();

		// click on email
		driver.findElementByXPath("//span[text()='Email']").click();

		// enter email number
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("hema@gmail.com");
		

		// click Find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		

		Thread.sleep(3000);
		// Capture name of First Resulting lead
		String FirstResultingLead = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").getText();
		// String FirstResultingLead =	driver.findElementByXPath("(//a[@href='/crmsfa/control/viewLead?partyId=11447'])[1]").getText();
		System.out.println(FirstResultingLead);

		// Click First Resulting lead
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();

		// Click Duplicate Lead
		driver.findElementByPartialLinkText("Duplicate Lead").click();

		// Verify the Title as 'Duplicate Lead'
		String Title = driver.getTitle();
		System.out.println(Title);

		if (Title.contains("Duplicate Lead")) {
			System.out.println("Title Matched");

		} else {
			System.out.println("Title not matched");
		}

		// click create Lead button
		driver.findElementByXPath("//input[@value='Create Lead']").click();

		// Confirm the duplicate lead name is same as captured name
		String DuplicateLeadName = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		System.out.println(DuplicateLeadName);

		if (DuplicateLeadName.contains("Mark")) {
			System.out.println("Duplicate Lead name matched");
		} else {
			System.out.println(" Not matched");
		}

		Thread.sleep(3000);
		// Close the browser do not log out
		driver.close();
	}

}