package takeSnapshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakesSnapshot {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "c:./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// enter username
		driver.findElementById("username").sendKeys("DemoSalesManager");

		// enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");

		// click login button
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		// click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();// click CRM/SFA link
		

		// click create lead link
		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABC");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hema");
				
		
		try {
		driver.findElementByXPath("//input[@id='createLeadForm_lastName']").sendKeys("Ma");
		System.out.println("Enter lastName successfully");
		
		}catch(Exception e) {
			System.err.println("LastName not enter successfully");
		
		}finally {
		
			// Take snapshot
			File src = driver.getScreenshotAs(OutputType.FILE);
		//File src = driver.getScreenshotAs(OutputType.FILE); // take snapshot and store in Temp File
		//File dest = new File("C:\\Users\\mamun\\Desktop\\snaps\\img.png"); //define
				
		
		// the path where it store after move
			File dest = new File("./snap/image.png");
		//File dest = new File("./snap/image.png");
		FileUtils.copyFile(src, dest);
			//FileUtils.copyFile(src, dest);
		
		//FileUtils.copyFile(src, dest); // moving file source to dest
		
		}
		// click create lead
		driver.findElementByXPath("//input[@value='Create Lead']").click();

		//driver.close();

	}

}
