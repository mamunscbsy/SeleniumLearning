package extentReports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoTestMG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent ;
	ChromeDriver driver;

	@BeforeSuite
	public void setUp() {
		// start reporters
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	@BeforeTest
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mamun\\Selenium\\Selenium\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void test1() throws IOException {
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

		driver.get("https://www.google.com/");
		test.pass("Navigated to google.com");
		
		driver.findElementByName("q").sendKeys("Automation");
		test.pass("Entered text is searchbox");
		
		driver.findElementByName("btnK").sendKeys(Keys.RETURN);
		test.pass("Pressed Keyboard enter key");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
	}
	@Test
	public void test2() throws IOException {
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		
		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
	}
	@AfterTest
	public void tesrdownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
	@AfterSuite
	public void tesrDown() {
		// calling flush writes everything to the log file
		extent.flush();
	}
}
