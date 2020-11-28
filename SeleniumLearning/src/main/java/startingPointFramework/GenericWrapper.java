package startingPointFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrapper implements WrapperMethods{
	
 public ChromeDriver driver;

	public void launchBrowser(String Url) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mamun\\Selenium\\Selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//System.out.println("Chrome browser launch usccessfully");

	}
	public void enterById(String locatorValue, String data) {
		driver.findElementById(locatorValue).sendKeys(data);
	}
	public void enterByName(String locatorValue, String data) {
		driver.findElementByName(locatorValue).sendKeys(locatorValue);
	}

	public void enterByXpath(String locatorValue, String data) {
		driver.findElementByXPath(locatorValue).sendKeys(data);
	}

	public void enterByCssSelactor(String locator, String locatorValue) {
		driver.findElementByCssSelector(locator).sendKeys(locatorValue);
	}

	public void clickByName(String locator) {
		driver.findElementByName(locator).click();
	}

	public void clickByLinkText(String locator) {
		driver.findElementByLinkText(locator).click();
	}
	public void clickByXpath(String locator) {
		driver.findElementByXPath(locator).click();
	}

	public void selectVisibleTextById(String Id, String Value) {
		WebElement ele = driver.findElementById(Id);
		Select dd = new Select(ele);
		dd.selectByVisibleText(Value);
	}

	public void selectVisibleTextByName(String Name, String Value) {
		WebElement ele = driver.findElementByName(Name);
		Select dd = new Select(ele);
		dd.selectByVisibleText(Value);
	}

	public void selectIndexById(String Id, int Value) {
		WebElement ele = driver.findElementById(Id);
		Select dd = new Select(ele);
		dd.selectByIndex(Value);
	}

	public void selectIndexByName(String Name, int Value) {
		WebElement ele = driver.findElementByName(Name);
		Select dd = new Select(ele);
		dd.selectByIndex(Value);
	}

	public void selectValueById(String Id, String Value) {
		WebElement ele = driver.findElementById(Id);
		Select dd = new Select(ele);
		dd.selectByValue(Value);
	}

	public void selectValueByName(String Name, String Value) {
		WebElement ele = driver.findElementByName(Name);
		Select dd = new Select(ele);
		dd.selectByValue(Value);

	}

	public void getTextById(String Id) {
		WebElement Text = driver.findElementById(Id);
		System.out.println(Text);
	}

	public void clickByClassName(String locator) {
		driver.findElementByClassName(locator).click();

	}
	public void verifyTextById(String id, String text) {
		String txt = driver.findElementById(id).getText();
		if (txt.equals(text)) {
			System.out.println("Text is matched");
		} else {
			System.out.println("Text is not matched");
		}
	}
	public void enterByPartialLinkText(String locatorValue, String data) {
		//driver.findElementByPartialLinkText(locatorValue).sendKeys(data);

	}
	public void closeBrowser() {
		driver.close();
	}
}
