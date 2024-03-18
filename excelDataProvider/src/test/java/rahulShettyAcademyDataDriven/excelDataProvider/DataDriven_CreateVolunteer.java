package rahulShettyAcademyDataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import grlpaProject.AdminVettingPage;
import grlpaProject.LoginPage;
import grlpaProject.VolunteersPage;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.DataFormatter;

//import org.apache.commons.io.build.AbstractOrigin;
//import org.apache.commons.io.build.AbstractStreamBuilder;
//import org.apache.commons.io.function.Uncheck;
//import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;

public class DataDriven_CreateVolunteer {
	WebDriver driver;
	
	//personal particulars
//			static String nric = "S7434642A";
//			static String dob = "01 May 1974";
//			static String fullName = "Johnny Shong";
//			static String surName = "Shong";
//			static String preferredName = "Automated";		

	static String salutation = "Ms";
	static String alias = "Auto";
	static String sex = "Female";
	static String nationality = "Singaporean";
	static String country = "Andorra";
	static String maritalStatus = "Single";
	static String race = "Others";
	static String religion = "Christianity";
	///Contact Information
	static String email = "grl@grl.com";
	static String mobNum = "88888888";
	static String homeTelnum = "99998888";
	static String officeTelnum = "77779999";
	///Home Address
	static String postalcode = "530516";
	static String typeDwelling = "Bungalow";
	static String floorNo = "F01";
	static String unitNo = "U03";				
	///Education Information
	static String eduLevel = "Doctorate";
	static String highestInstitution = "Automation - Institution";	
	///Occupation Information
	static String economicStatus = "Unemployed";
	static String emplSector = "Civil Defence";	
	static String occupationCat = "Armed Forces Personnel";
	static String occupation = "Automation Tester";	
	static String company = "Automation Company";	
	///PDPA
	static String pdpa1 = "I hereby declare that the information provided in this Volunteer Registration form is accurate, true and there is no undisclosed detail(s) that would affect the approval of this registration. I will duly inform the PA of any information change(s).";
	static String pdpa2 = "I consent that the personal information provided may be used by the PA to contact me in connection with my participation as a volunteer with the PA and/or its affiliated grassroots organisations. The PA may make my personal data available to external individuals or organisations (if necessary) to fulfil the registration approval as well as for all matters relating to my participation as a volunteer with the PA and/or its affiliated grassroots organisations. Where appropriate, the PA may share your personal information with other Government agencies so as to improve the discharge of public functions, and to serve you in the most efficient and effective way unless such sharing is prohibited by law.";	

	
	
	@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException {
		
//		Object[][] data= {{"hello","text","1"},{"bye","message","143"},{"World","Go","155"}};
		FileInputStream fis = new FileInputStream("/Users/chino/Documents/excelDrivenTD.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int colCount=row.getLastCellNum();
		Object data[][]=new Object[rowCount-1][colCount];
		for(int i=0;i<rowCount-1;i++) 
		{
//			System.out.println("outer loop started");
			row=sheet.getRow(i+1);
			for(int j=0;j<colCount;j++) 
			{
				XSSFCell cell=row.getCell(j);
				data[i][j]=formatter.formatCellValue(cell);
//				data[i][j]=row.getCell(j);
//				System.out.println(row.getCell(j));
			}
//			System.out.println("outer loop ended");
		}
		return data;
	}
	
	
	DataFormatter formatter=new DataFormatter();
	@Test(dataProvider="driveTest")
	public void testCaseData(String eSOEid, String eNRIC, String eFirstName, String eSurName, String ePreferredName,String eDOB) throws InterruptedException{
//		System.out.println(eSOEid+ " "+ eNRIC+ " "+ eFullName + " "+ eSurName);
		
		System.setProperty("webdriver.chrome.driver","/Users/chino/Downloads/chromedriver-mac-x64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		PageLogin loginPage = new PageLogin(driver);
		loginPage.goTo();
		loginPage.loginApplication(eSOEid);
	
		PageVolunteers volunteersPage = new PageVolunteers(driver);
		volunteersPage.gotoVolunteerspage();
		System.out.println("Volunteer Details: "+eNRIC+ ", "+ePreferredName);
		volunteersPage.NRIC.sendKeys(eNRIC, Keys.TAB);Thread.sleep(2000);
		volunteersPage.validateNRIC();
		
//		driver.findElement(By.xpath("//div[text()='NRIC']//following-sibling::div")).sendKeys(nric, Keys.TAB);Thread.sleep(5000);
//		boolean nc = driver.findElement(By.xpath("//p[text()='Valid Unique NRIC']")).isDisplayed();
//		boolean nu = driver.findElement(By.xpath("//p[text()='NRIC is in use']")).isDisplayed();
//		boolean ni = driver.findElement(By.xpath("//p[text()='Invalid NRIC']")).isDisplayed();
	
		volunteersPage.inputPersonalParticulars(salutation, ePreferredName, eSurName, alias, ePreferredName, sex, eDOB,nationality, country, maritalStatus,
				race,religion);	
//		volunteersPage.validateDDsex();
		volunteersPage.inputContactInformation(email, mobNum, homeTelnum, officeTelnum);	
		volunteersPage.inputhomeAddress(postalcode, typeDwelling, floorNo, unitNo);	
		volunteersPage.inputEducationInformation(eduLevel, highestInstitution);	
		volunteersPage.inputOccuptationInfo(economicStatus,emplSector,occupationCat,occupation,company);

		driver.findElement(By.xpath("//input[@name='Acknowledgement']")).click();
		driver.findElement(By.xpath("//button[@text='Next']")).click();
	
	
		System.out.println("Page Assertions");
		String assertSalutation = driver.findElement(By.xpath("//div[text()='Salutation']//following-sibling::div")).getAttribute("outerText");
		String assertFullName = driver.findElement(By.xpath("//div[text()='Full Name']//following-sibling::div")).getAttribute("outerText");
		String assertSurname = driver.findElement(By.xpath("//div[text()='Surname']//following-sibling::div")).getAttribute("outerText");
		String assertAlias = driver.findElement(By.xpath("//div[text()='Alias']//following-sibling::div[1]")).getAttribute("outerText");
		String assertPreferredName = driver.findElement(By.xpath("//div[text()='Preferred Name (For PAssion Card and e-GRL card)']//following-sibling::div[1]")).getAttribute("outerText");
		String assertSex = driver.findElement(By.xpath("//div[text()='Sex']//following-sibling::div[1]")).getAttribute("outerText");
		String assertDOB = driver.findElement(By.xpath("//div[text()='Date of Birth (Age)']//following-sibling::div[1]")).getAttribute("outerText");
		String assertNationality = driver.findElement(By.xpath("//div[text()='Nationality']//following-sibling::div[1]")).getAttribute("outerText");
		String assertSingaporePR = driver.findElement(By.xpath("//div[text()='Singapore PR']//following-sibling::div[1]")).getAttribute("outerText");
		String assertCOB = driver.findElement(By.xpath("//div[text()='Country of Birth']//following-sibling::div[1]")).getAttribute("outerText");
		String assertDOCC = driver.findElement(By.xpath("//div[text()='Date of Citizenship Certificate']//following-sibling::div[1]")).getAttribute("outerText");
		String assertMaritalStatus = driver.findElement(By.xpath("//div[text()='Marital Status']//following-sibling::div[1]")).getAttribute("outerText");
		String assertNSstatus = driver.findElement(By.xpath("//div[text()='NS Status']//following-sibling::div[1]")).getAttribute("outerText");
		String assertRace = driver.findElement(By.xpath("//div[text()='Race']//following-sibling::div[1]")).getAttribute("outerText");
		String assertReligion = driver.findElement(By.xpath("//div[text()='Religion']//following-sibling::div[1]")).getAttribute("outerText");
		
		Assert.assertEquals(assertSalutation,salutation,"Expected and Actual are not the same");  
		Assert.assertEquals(assertFullName,ePreferredName,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertSurname,eSurName,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertAlias,alias,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertPreferredName,ePreferredName,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertSex,sex,"Expected and Actual are not the same"); 
		Assert.assertTrue(assertDOB.contains("01 May "+eDOB),"Expected and Actual are not the same"); 
		Assert.assertEquals(assertNationality,nationality,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertSingaporePR,"No","Expected and Actual are not the same"); 
		Assert.assertEquals(assertCOB,country,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertDOCC,"N/A","Expected and Actual are not the same"); 
		Assert.assertEquals(assertMaritalStatus,maritalStatus,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertNSstatus,"N/A","Expected and Actual are not the same"); 
		Assert.assertEquals(assertRace,race,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertReligion,religion,"Expected and Actual are not the same"); 
		
		
		String assertEmailAddress = driver.findElement(By.xpath("//div[text()='Email Address']//following-sibling::div[1]")).getText();
		String assertOfficeTelNumber = driver.findElement(By.xpath("//div[text()='Office Telephone Number']//following-sibling::div[1]")).getText();
		String assertMobileNumber = driver.findElement(By.xpath("//div[text()='Mobile Number']//following-sibling::div[1]")).getText();
		String assertMailTo = driver.findElement(By.xpath("//div[text()='Mail To']//following-sibling::div[1]")).getText();
		String assertHomeTelNumber = driver.findElement(By.xpath("//div[text()='Home Telephone Number']//following-sibling::div[1]")).getText();
		Assert.assertEquals(assertEmailAddress,email,"Expected and Actual are not the same");  
		Assert.assertEquals(assertOfficeTelNumber,officeTelnum,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertMobileNumber,mobNum,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertMailTo,"Home","Expected and Actual are not the same"); 
		Assert.assertEquals(assertHomeTelNumber,homeTelnum,"Expected and Actual are not the same"); 
		
		String assertEducationLevel = driver.findElement(By.xpath("//div[text()='Educational Level']//following-sibling::div[1]")).getText();
		String assertNameHighestInstitutionAttended = driver.findElement(By.xpath("//div[text()='Name of Highest Institution Attended']//following-sibling::div[1]")).getText();
		Assert.assertEquals(assertEducationLevel,eduLevel,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertNameHighestInstitutionAttended,highestInstitution,"Expected and Actual are not the same"); 
		
		String assertEconomicStatus = driver.findElement(By.xpath("//div[text()='Economic Status']//following-sibling::div[1]")).getText();
//		String assertEmploymentSector = driver.findElement(By.xpath("//div[text()='Employment Sector']//following-sibling::div[1]")).getText();
		String assertOccupationCategory = driver.findElement(By.xpath("//div[text()='Occupation Category']//following-sibling::div[1]")).getText();
		String assertOccupation = driver.findElement(By.xpath("//div[text()='Occupation']//following-sibling::div[1]")).getText();
		String assertNameofCompany = driver.findElement(By.xpath("//div[text()='Name of Company']//following-sibling::div[1]")).getText();
		Assert.assertEquals(assertEconomicStatus,economicStatus,"Expected and Actual are not the same");  
//		Assert.assertEquals(assertEmploymentSector,emplSector,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertOccupationCategory,occupationCat,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertOccupation,occupation,"Expected and Actual are not the same"); 
		Assert.assertEquals(assertNameofCompany,company,"Expected and Actual are not the same"); 
	
		String pdpaElement1 = driver.findElement(By.xpath("//p[text()='PDPA Declaration']//parent::div//following-sibling::div/div/following-sibling::div/p[1]")).getText();
		String pdpaElement2 = driver.findElement(By.xpath("//p[text()='PDPA Declaration']//parent::div//following-sibling::div/div/following-sibling::div/p[2]")).getText();
		Assert.assertEquals(pdpaElement1,pdpa1,"Expected and Actual are not the same");  
		Assert.assertEquals(pdpaElement2,pdpa2,"Expected and Actual are not the same"); 

		volunteersPage.submitBTN.click();Thread.sleep(2000);
		System.out.println("Volunteer is created. Test Case = PASSED!");Thread.sleep(5000);
	

//		volunteersPage.gotoVolunteerspage();
//		volunteerProfile.editVolunteerBTN.click();
		
		PageAdminVetting addminVettingpage = new PageAdminVetting(driver);
		addminVettingpage.gotoAdminVetting();Thread.sleep(15000);
//		addminVettingpage.implicitaddNewRequestBTN();
		addminVettingpage.inputAddNewRequest(eNRIC,"GRO", "Admiralty","Citizens' Consultative Committee","**Committee not formed, to key in committee name manually.","test");
		
//		volunteersPage.searchVolunteerslink.click();Thread.sleep(10000);
//		addminVettingpage.clearanceRequest.click();Thread.sleep(3000);
//		addminVettingpage.clearrequest(nric,dob,dob,dob,"Proceed","test");
		driver.quit();
	}
	

}
