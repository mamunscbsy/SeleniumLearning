package startingPointFramework;

public interface WrapperMethods {
			
	public void launchBrowser(String url);
		
	public void enterById(String locatorValue, String data);
	
	public void enterByName(String locatorValue, String data);
			
	public void enterByPartialLinkText(String locatorValue, String data);
	
	public void enterByXpath(String locatorValue, String data);
	
	public void enterByCssSelactor(String locatorValue, String data);
			
	public void clickByName(String locatorValue);
	
	public void clickByClassName(String locatorValue);
	
	public void clickByLinkText(String locatorValue);
			
	public void clickByXpath(String locatorValue);
		
	public void selectVisibleTextById(String Id, String Value);
		
	public void selectIndexByName(String Name, int Value);
		
	public void getTextById(String Id);
	
	public void closeBrowser();

}
