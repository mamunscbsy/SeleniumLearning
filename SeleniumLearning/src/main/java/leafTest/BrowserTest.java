package leafTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;



public class BrowserTest {

	public static void main(String[] args) {

		
		//Launch Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mamun\\Selenium\\Selenium\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//Load Url
		driver.get("http://leaftaps.com/opentaps");
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Close driver
		driver.close();
		
	}

}
