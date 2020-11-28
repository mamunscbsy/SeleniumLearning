package grcShopApplication;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyAdminLogin {

	public static void main(String[] args) throws InterruptedException {




		System.setProperty("webdriver.chrome.driver","C:\\Users\\mamun\\Selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://gcreddy.com/project/admin/login.php");

		driver.findElement(By.name("username")).sendKeys("gcreddy");
		driver.findElement(By.name("password")).sendKeys("Temp@2020");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(2000);

		try {
			boolean linkExists = driver.findElement(By.linkText("Logoff")).isDisplayed();

			if(linkExists == true) {
				System.out.println("Admin login is successful- Passed");
			}
		}
		catch(NoSuchElementException e) {
			System.out.println("Admin Login is Unsuccessful - Failed");
		}
		driver.close();
	}


}



