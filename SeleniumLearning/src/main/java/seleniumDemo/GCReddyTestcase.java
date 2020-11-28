package seleniumDemo;


import org.openqa.selenium.chrome.ChromeDriver;

public class GCReddyTestcase {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mamun\\Selenium\\Selenium\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://gcreddy.com/project/admin/login.php");
		//click Online catalog	
		driver.findElementByLinkText("Online Catalog").click();
		Thread.sleep(2000);
		String url1 = driver.getCurrentUrl();
		System.out.println(url1);
		
		if(url1.equals("https://gcreddy.com/project/")) {
			System.out.println("Before Login – Page is redirecting from admin to user interface – Passed");
			
		}else {
			System.out.println("Before Login – Page is Not redirecting from admin to user interface – Failed");
		}
		
		driver.navigate().back();
		driver.findElementByName("username").sendKeys("gcreddy");
		driver.findElementByName("password").sendKeys("Temp@2020");
		driver.findElementById("tdb1").click();
		
		//driver.findElement(By.name(“username”)).sendKeys(“gcreddy”);
		//driver.findElement(By.name(“password”)).sendKeys(“Temp@2020”);
		//driver.findElement(By.id(“tdb1”)).click();
		
		Thread.sleep(2000);
		String url2 = driver.getCurrentUrl();
		if(url2.equals("https://gcreddy.com/project/admin/index.php")) {
			driver.findElementByLinkText("Online Catalog").click();
		}
		
		String url3 = driver.getCurrentUrl();
		System.out.println(url3);
		
		if(url3.equals("https://gcreddy.com/project/")) {
			System.out.println("After Login – Page is redirecting from admin to user interface – Passed");
		}else {
			System.out.println("After Login – Page is Not redirecting from admin to user interface – Failed");
		}
		//driver.close();

		/*if (url2.equals(“https://gcreddy.com/project/admin/index.php”)) {
		driver.findElement(By.linkText(“Online Catalog”)).click();
		}

		String url3 = driver.getCurrentUrl();
		//System.out.println(url3);

		if (url3.equals(“https://gcreddy.com/project/”)) {
		System.out.println(“After Login – Page is redirecting from admin to user interface – Passed”);
		}
		else {
		System.out.println(“After Login – Page is Not redirecting from admin to user interface – Failed”);
		}
		driver.close();
		}
		}*/

	}

}
