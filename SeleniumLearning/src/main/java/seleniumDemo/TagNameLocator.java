package seleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TagNameLocator {

	@Test
	public void tagName() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mamun\\Selenium\\Selenium\\drivers\\chromedriver.exe");
		// WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new ChromeDriver();
		// load URL
		driver.get("http://leaftaps.com/opentaps");
		
		//driver.get("http://www.indeed.com");
		// maximize
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		List  elements = driver.findElements(By.tagName("h2"));
		
		int total = elements.size();
		
		System.out.println("Total webelements starting with TagName 'h2' :" + total);
		
		Thread.sleep(2000);
		driver.close();
	}

}
