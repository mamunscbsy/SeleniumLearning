package learnTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGPriority {

	public ChromeDriver driver;

	@BeforeMethod
	public void login() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mamun\\Selenium\\Selenium\\drivers\\chromedriver.exe");
		// WebDriverManager.firefoxdriver().setup();
		driver = new ChromeDriver();
		// maximize
		driver.manage().window().maximize();
		//implecitly wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// load URL
		driver.get("http://leaftaps.com/opentaps");
		// Enter Username - (Element level)
		driver.findElementById("username").sendKeys("DemoSalesManager");
		// driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		// Enter Password - (Element level)
		driver.findElementById("password").sendKeys("crmsfa");
		// Click Login Button - (Element level)
		driver.findElementByClassName("decorativeSubmit").click();
		// click crm/sfa link
		driver.findElementByLinkText("CRM/SFA").click();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void editLead() {
		// click leads link
		driver.findElementByLinkText("Leads").click();
		// click Find leads link
		driver.findElementByLinkText("Find Leads").click();
		// Enter first name
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Hema");
		// click Find lead button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
	}

	@Test(priority = 0)
	public void createLead() throws InterruptedException {
		// click leads
		driver.findElementByLinkText("Leads").click();
		// click create lead link
		driver.findElementByLinkText("Create Lead").click();
		// enter company name
		driver.findElementById("createLeadForm_companyName").sendKeys("TCS");
		// enter firstName
		driver.findElementByCssSelector("input#createLeadForm_firstName").sendKeys("Hema");
		// enter lastName
		driver.findElementByCssSelector("#createLeadForm_lastName").sendKeys("Ma");
		Thread.sleep(3000);
		// driver.findElementById("createLeadForm_lastName").sendKeys("J");
		// Choose source
		/*WebElement src = driver.findElementById("createLeadForm_dataSourceId");
		Select dd = new Select(src);
		dd.selectByVisibleText("Website");
		// enter phone number
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneNumber']").sendKeys("1234567");
		// enter department
		driver.findElementByXPath("//input[@id='createLeadForm_departmentName']").sendKeys("QA");
		// Enter phone number
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("1234567");
		// Enter email address
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("hema@gmail.com");*/
		
		// Click Create lead
		driver.findElementByXPath("//input[@name='submitButton']").click();
	}
	@Test(priority = 2)
	public void deleteLead() {
		// click Leads
		driver.findElementByLinkText("Leads").click();
		// click Find lead link
		driver.findElementByLinkText("Find Leads").click();
		// click on phone
		driver.findElementByXPath("//span[text()='Phone']").click();
		// click on email
		// driver.findElementByXPath("//span[text()='Email']").click();
		// enter phone number(areaCode)
		driver.findElementByXPath("//input[@name='phoneAreaCode']").sendKeys("201");
		// enter phone number
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("1234567");
		// enter email address
		// driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("abc@abc.com");
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
