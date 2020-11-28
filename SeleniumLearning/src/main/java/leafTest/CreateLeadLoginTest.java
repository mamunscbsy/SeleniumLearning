package leafTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLeadLoginTest {

	public static void main(String[] args) throws InterruptedException {


		//Launch Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mamun\\Selenium\\Selenium\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		//Load Url
		driver.get("http://leaftaps.com/opentaps");

		//Maximize window
		driver.manage().window().maximize();

		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//enter username
		//driver.findElementById("username").sendKeys("DemoSalesManager");
		//driver.findElementByXPath("//input[@id='username']").sendKeys("DemoSalesManager");
		driver.findElementByXPath("//input[@name='USERNAME']").sendKeys("DemoSalesManager");

		//enter password
		//driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@type='password']").sendKeys("crmsfa");

		//click login btn
		//driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByXPath("//input[@value='Login']").click();

		//click CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();

		//click leads link
		//driver.findElementByLinkText("Leads").click();
		driver.findElementByXPath("//a[text()='Leads']").click();

		//click Create lead link
		//driver.findElementByLinkText("Create Lead").click();
		//driver.findElementByPartialLinkText("Create").click();
		//driver.findElementByXPath("//a[text()='Create Lead']").click();



		//enter company name
		driver.findElementById("createLeadForm_companyName").sendKeys("ABC");

		//enter first name
		driver.findElementById("createLeadForm_firstName").sendKeys("Hema");

		//enter last name
		driver.findElementById("createLeadForm_lastName").sendKeys("Ma");

		//enter annual revenue
		driver.findElementById("createLeadForm_annualRevenue").sendKeys("100");

		//enter description
		driver.findElementById("createLeadForm_description").sendKeys("Software Testing");

		driver.findElementByPartialLinkText("Request").click();
		//click Create Lead button
		//driver.findElementByName("submitButton").click();

		Thread.sleep(4000);
		//Close driver
		driver.close();

	}

}
