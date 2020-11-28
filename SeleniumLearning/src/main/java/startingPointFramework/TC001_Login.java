package startingPointFramework;

import org.testng.annotations.Test;

public class TC001_Login extends GenericWrapper {
	
	@Test
	public void login() throws InterruptedException {
		
		launchBrowser("http://leaftaps.com/opentaps");
				
		enterById("username", "DemoSalesManager");
			
		enterById("password", "crmsfa");
		clickByXpath("//input[@value='Login']");
		clickByLinkText("CRM/SFA");
		clickByLinkText("Leads");
		clickByLinkText("Create Lead");
		Thread.sleep(2000);
		enterById("createLeadForm_companyName", "TCS");
		enterById("createLeadForm_firstName", "Hema");
		enterById("createLeadForm_lastName", "M");
		enterById("createLeadForm_firstNameLocal", "Hema");
		enterByXpath("//input[@id='createLeadForm_lastNameLocal']", "Ma");
		enterByXpath("//input[@name='personalTitle']", "Ms.");
		selectVisibleTextById("createLeadForm_dataSourceId", "Website");
		
		enterByXpath("//input[@name='generalProfTitle']", "Ms");
		enterByXpath("//input[@name='annualRevenue']", "1000");
		selectVisibleTextById("createLeadForm_industryEnumId", "Insurance");
		selectVisibleTextByName("ownershipEnumId", "Sole Proprietorship");
		enterByXpath("//input[@name='sicCode']", "1010");
		enterByXpath("//textarea[@name='description']", "It is a Software Development company");
		enterById("createLeadForm_importantNote", "It's a trusted company");
		enterByXpath("//input[@id='createLeadForm_primaryPhoneCountryCode']", "0088");
		enterByXpath("//input[@id='createLeadForm_primaryPhoneAreaCode']", "123");
		enterByXpath("//input[@id='createLeadForm_primaryPhoneExtension']", "101");
		enterByXpath("//input[@id='createLeadForm_departmentName']", "QA");
		selectVisibleTextById("createLeadForm_currencyUomId", "BDT - Bangladesh Taka");
		enterByXpath("//input[@id='createLeadForm_numberEmployees']", "1002");
		enterByXpath("//input[@name='tickerSymbol']", "$");
		enterByXpath("//input[@name='primaryPhoneAskForName']", "Hema");
		enterByXpath("//input[@name='primaryWebUrl']", "www.google.com");
		enterByXpath("//input[@name='generalToName']", "Ma");
		enterByXpath("//input[@name='generalAddress1']", "8821 Saddlehorn Dr");
		enterByXpath("//input[@name='generalAddress2']", "APT 252");
		enterByXpath("//input[@id='createLeadForm_generalCity']", "DAL");
		selectVisibleTextById("createLeadForm_generalStateProvinceGeoId", "Texas");
		selectVisibleTextById("createLeadForm_generalCountryGeoId", "Bangladesh");
		enterByXpath("//input[@id='createLeadForm_generalPostalCode']", "75061");
		enterByXpath("//input[@id='createLeadForm_generalPostalCodeExt']", "111");
		selectVisibleTextById("createLeadForm_marketingCampaignId", "Car and Driver");
		enterById("createLeadForm_primaryPhoneNumber", "347-612-1535");
		enterById("createLeadForm_primaryEmail", "abc@gmail.com");
		Thread.sleep(2000);
		clickByXpath("//input[@name='submitButton']");
		Thread.sleep(2000);
		verifyTextById("viewLead_firstName_sp", "Hema");
		Thread.sleep(2000);
		closeBrowser();
	}


}
