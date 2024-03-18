package rahulShettyAcademyDataDriven.excelDataProvider;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.logging.Log;
import org.apache.hc.core5.util.Asserts;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageAdminVetting {
	
	WebDriver driver;

	public PageAdminVetting(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	///Page Factory
	@FindBy(xpath="//b[text()='Admin Vetting']")
	WebElement adminVettingTab;
	
	@FindBy(xpath="//span[text()='Clearance Request']")
	WebElement clearanceRequest;
	
	@FindBy(xpath="//button[text()='Add New Request']")
	WebElement addNewRequestBTN;
	
	public void gotoAdminVetting()
	{
		adminVettingTab.click();
		clearanceRequest.click();	
	
	 }
	
    public void implicitaddNewRequestBTN() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        addNewRequestBTN.click();
	}
    
	///Personal Particulars
	@FindBy(xpath="//div[text()='NRIC']//following-sibling::div//input")
	WebElement NRIC;
	@FindBy(xpath="//button[text()='Retrieve Info']")
	WebElement retrieveInfoBTN;
	@FindBy(xpath="//div[text()='Clearance Type']//following-sibling::div[1]//input")
	WebElement clearanceType;
	@FindBy(xpath="//div[text()='Division']//following-sibling::div[1]//input")
	WebElement division;
	@FindBy(xpath="//div[text()='Committee Type']//following-sibling::div[1]//input")
	WebElement committeeeType;
	@FindBy(xpath="//div[text()='Committee Name']//following-sibling::div[1]//input")
	WebElement committeename;
	@FindBy(xpath="//input[@placeholder='Enter Committee Name']")
	WebElement entercommitteename;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitnomineerequestBTN;
	@FindBy(xpath="//button[text()='Download Request File']")
	WebElement downloadrequestfileBTN;
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continueBTN;
	
	

	public void inputAddNewRequest(String nricValue, String clearanceTypeValue, String divisionValue, 
			String committeeeTypeValue, String committeenameValue, String entercommitteenameValue) throws InterruptedException
	{
		addNewRequestBTN.click();	
		System.out.println("Add Request Button Clicked");
		NRIC.sendKeys(nricValue);
		retrieveInfoBTN.click();
		clearanceType.sendKeys(clearanceTypeValue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);Thread.sleep(2500);
		division.sendKeys(divisionValue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);Thread.sleep(2500);
		committeeeType.sendKeys(committeeeTypeValue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);Thread.sleep(2500);
//		division.sendKeys(divisionValue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);Thread.sleep(5000);
		committeename.click();Thread.sleep(2500);
		committeename.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);Thread.sleep(2500);
		committeename.sendKeys(committeenameValue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);Thread.sleep(2500);
		entercommitteename.sendKeys(entercommitteenameValue);
		submitnomineerequestBTN.click();Thread.sleep(2500);
		System.out.println("Admin Vetting submitted!");
//		downloadrequestfileBTN.click();Thread.sleep(1000);
//		continueBTN.click();Thread.sleep(8000);
		
	}
	
	@FindBy(xpath="//input[@placeholder='Search Name / NRIC']")
	WebElement searchNameNRIC;
	@FindBy(xpath="//button[text()='View']//following-sibling::button")
	WebElement clickViewBTN;
	@FindBy(xpath="//p[text()='Update']")
	WebElement updatelink;
	@FindBy(xpath="//div[text()='Agency A']/./following-sibling::div/button")
	WebElement agencyA;
	@FindBy(xpath="//div[text()='Agency P']/./following-sibling::div/button")
	WebElement agencyP;
	@FindBy(xpath="//div[text()='Agency D']/./following-sibling::div/button")
	WebElement agencyD;
	@FindBy(xpath="//div[text()='Agency A']/./following-sibling::div/div/div/div/div/input")
	WebElement agencyAcalendar;
	@FindBy(xpath="//div[text()='Agency P']/./following-sibling::div/div/div/div/div/input")
	WebElement agencyPcalendar;
	@FindBy(xpath="//div[text()='Agency D']/./following-sibling::div/div/div/div/div/input")
	WebElement agencyDcalendar;
	@FindBy(xpath="//input[@name='vaRemarks']")
	WebElement vaRemarksTxt;
	@FindBy(xpath="//textarea[@placeholder='Enter additional remarks (Optional)']")
	WebElement vaRemarks2Txt;
	@FindBy(xpath="	//button[text()='Save']")
	WebElement saveBTN;


	public void clearrequest(String nricValue, String dateValue1, String dateValue2, String dateValue3, 
			String vaRemarksTxtvalue, String vaRemarks2Txtvalue) throws InterruptedException
	{
		
		searchNameNRIC.sendKeys(nricValue,Keys.ENTER);
		clickViewBTN.click();
		updatelink.click();Thread.sleep(5000);
		agencyA.click();
		agencyAcalendar.sendKeys(dateValue1);
		agencyP.click();
		agencyPcalendar.sendKeys(dateValue2);
		agencyD.click();
		agencyDcalendar.sendKeys(dateValue3);
		vaRemarksTxt.sendKeys(vaRemarksTxtvalue);
		vaRemarks2Txt.sendKeys(vaRemarks2Txtvalue);
		saveBTN.click();
	}
	
			
}
