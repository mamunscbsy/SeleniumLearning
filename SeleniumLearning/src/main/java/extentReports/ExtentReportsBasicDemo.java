package extentReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {
	
	private static ChromeDriver driver = null;

	public static void main(String[] args) {

		// start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
    
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
     // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google search test one", "this is a test to validate google search functionality");
        
        System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mamun\\Selenium\\Selenium\\drivers\\chromedriver.exe");
			
		 driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		test1.log(Status.INFO, "starting test case");
		driver.get("https://www.google.com/");
		test1.pass("Navigated to google.com");
		
		driver.findElementByName("q").sendKeys("Automation");
		test1.pass("Entered text is searchbox");
		
		driver.findElementByName("btnK").sendKeys(Keys.RETURN);
		test1.pass("Pressed Keyboard enter key");
		
		driver.close();
		driver.quit();
		test1.pass("closed the browser");
		
		test1.pass("Test is completed");
		
		// calling flush writes everything to the log file
        extent.flush();
		
        
		

	}

}
