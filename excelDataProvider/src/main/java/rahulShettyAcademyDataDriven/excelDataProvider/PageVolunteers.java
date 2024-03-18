package rahulShettyAcademyDataDriven.excelDataProvider;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageVolunteers {

	WebDriver driver;

	public PageVolunteers(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	///Page Factory
	@FindBy(xpath="//b[text()='Volunteers']")
	WebElement volunteersTab;
	
	@FindBy(xpath="//span[text()='Search For Volunteer']")
	WebElement searchVolunteerslink;
	
	@FindBy(xpath="//main[@id='test']//button[@type='button'][text()='Create']")
	WebElement createBTN;
	
	public void gotoVolunteerspage()
	{
		volunteersTab.click();
		searchVolunteerslink.click();
		createBTN.click();
		
	}
	
	public void validateNRIC()
	{
//		driver.findElement(By.xpath("//p[text()='Valid Unique NRIC']")).isDisplayed();
//		driver.findElement(By.xpath("//p[text()='NRIC is in use']")).isDisplayed();
//		driver.findElement(By.xpath("//p[text()='Invalid NRIC']")).isDisplayed();
		List<WebElement> invalidNRIC = driver.findElements(By.xpath("//p[text()='Invalid NRIC']"));
		List<WebElement> inUseNRIC = driver.findElements(By.xpath("//p[text()='NRIC is in use']"));
		List<WebElement> validNRIC = driver.findElements(By.xpath("//p[text()='Valid Unique NRIC']"));
		 
		 if(inUseNRIC.size()!=0) {
			 System.out.println("NRIC is in USE. Please use different NRIC to proceed.");
        	 driver.quit();			
		 }else if (invalidNRIC.size()!=0) {
			 System.out.println("NRIC is INVALID. Please use different NRIC to proceed.");
        	 driver.quit();
         }else {
        	 System.out.println("NRIC is valid and we can now proceed with volunteer creation.");
         }
		
	}  
	
	
	
	
	///Personal Particulars
		@FindBy(xpath="//div[text()='NRIC']//following-sibling::div//input")
		WebElement NRIC;
		@FindBy(xpath="//div[text()='Salutation']//following-sibling::div//input")
		WebElement Salutation;
		@FindBy(xpath="//div[text()='Full Name']//following-sibling::div//input")
		WebElement FullName;
		@FindBy(xpath="//div[text()='Surname']//following-sibling::div//input")
		WebElement Surname;
		@FindBy(xpath="//div[text()='Alias']//following-sibling::div[1]//input")
		WebElement Alias;
		//26 Sept Update - updated the xpath link
		@FindBy(xpath="//div[text()='Preferred Name (For PAssion Card and e-GRL card)']//following-sibling::div[1]//input")
		WebElement PreferredName;
		@FindBy(xpath="//div[text()='Sex']//following-sibling::div[1]//input")
		WebElement Sex;
		@FindBy(xpath="//div[text()='Date of Birth']//following-sibling::div[1]//input")
		WebElement DOB;
		@FindBy(xpath="//div[text()='Nationality']//following-sibling::div[1]//input")
		WebElement Nationality;
		@FindBy(xpath="//div[text()='Singapore PR?']//following-sibling::div[1]//input")
		WebElement SingaporePR;
		@FindBy(xpath="//div[text()='Country of Birth']//following-sibling::div[1]//input")
		WebElement COB;
		@FindBy(xpath="//div[text()='Date of Citizenship Certificate']//following-sibling::div[1]//input")
		WebElement DOCC;
		@FindBy(xpath="//div[text()='Marital Status']//following-sibling::div[1]//input")
		WebElement MaritalStatus;
		@FindBy(xpath="//div[text()='NS Status']//following-sibling::div[1]//input")
		WebElement NSstatus;
		@FindBy(xpath="//div[text()='Race']//following-sibling::div[1]//input")
		WebElement Race;
		@FindBy(xpath="//div[text()='Religion']//following-sibling::div[1]//input")
		WebElement Religion;

		@FindBy(xpath="//div[text()='Email Address']//following-sibling::div[1]//input")
		WebElement EmailAddress;
		@FindBy(xpath="//div[text()='Office Telephone Number']//following-sibling::div[1]//input")
		WebElement OfficeTelNumber;
		@FindBy(xpath="//div[text()='Mobile Number']//following-sibling::div[1]//input")
		WebElement MobileNumber;
		@FindBy(xpath="//div[text()='Mail To']//following-sibling::div[1]//input")
		WebElement MailTo;
		@FindBy(xpath="//div[text()='Home Telephone Number']//following-sibling::div[1]//input")
		WebElement HomeTelNumber;
				
		@FindBy(xpath="//div[text()='Educational Level']//following-sibling::div[1]//input")
		WebElement EducationLevel;
		@FindBy(xpath="//div[text()='Name of Highest Institution Attended']//following-sibling::div[1]//input")
		WebElement NameHighestInstitutionAttended;
		
		@FindBy(xpath="//div[text()='Economic Status']//following-sibling::div[1]//input")
		WebElement EconomicStatus;
		@FindBy(xpath="//div[text()='Employment Sector']//following-sibling::div[1]//input")
		WebElement EmploymentSector;
		@FindBy(xpath="//div[text()='Occupation Category']//following-sibling::div[1]//input")
		WebElement OccupationCategory;
		@FindBy(xpath="//div[text()='Occupation']//following-sibling::div[1]//input")
		WebElement Occupation;
		@FindBy(xpath="//div[text()='Name of Company']//following-sibling::div[1]//input")
		WebElement NameofCompany;
		
		
		public void inputPersonalParticulars(String salValue, String fullNamevalue, String surNamevalue, String alisvalue,
				String preferredNamevalue, String sexvalue, String dobvalue, String nationalityvalue, String countryvalue, 
				String maritalStatusvalue, String racevalue, String religionvalue)
		{
			Salutation.sendKeys(salValue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
			FullName.sendKeys(fullNamevalue);
			Surname.sendKeys(surNamevalue);
			Alias.sendKeys(alisvalue);
			PreferredName.sendKeys(preferredNamevalue);
			Sex.sendKeys(sexvalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
			DOB.sendKeys("01 May "+dobvalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
			Nationality.sendKeys(nationalityvalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
			COB.sendKeys(countryvalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
			MaritalStatus.sendKeys(maritalStatusvalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
			Race.sendKeys(racevalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
			Religion.sendKeys(religionvalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
			System.out.println("inputPersonalParticulars done");
			
		}

		
		public void validateDDsex() 
		{
			
			Select s = new Select(driver.findElement(By.xpath("//div[text()='Sex']//following-sibling::div[1]//input")));
			List <WebElement> op = s.getOptions();
			int size = op.size();
			for(int i=0; i<size; i++) {
				String options =op.get(i).getText();
				System.out.println(options);
			}
//			System.out.println("validateDD");
//			String[] exp = {"Male", "Female", "Unknown", "Other"};
//			WebElement ddSex = Sex;
//	        Select select = new Select(ddSex);  
//	        
//	        int count = 0;
//	        List<WebElement> options = select.getOptions();
//	        for (WebElement we : options) {
//	            for (int i = 0; i < exp.length; i++) {
//	                if (we.getText().equals(exp[i])) {
//	                    count++;
//	                }
//	            }
//	        }
//	        if (count == exp.length) {
//	            System.out.println("matched");
//	        } else {
//	            System.out.println("Houston, we have a problem.");
//	        }
	    }
	      
			///Contact Information	
			@FindBy(xpath="//input[@name='email']")
			WebElement email;
			@FindBy(xpath="//input[@name='mobileNumber']")
			WebElement mobNum;
			@FindBy(xpath="//input[@name='homeNumber']")
			WebElement homeTelnum;
			@FindBy(xpath="//input[@name='officeNumber']")
			WebElement officeTelnum;
			
			public void inputContactInformation(String emailValue, String mobNumvalue, String homeTelnumvalue, String officeTelnumvalue)
			{
				email.sendKeys(emailValue);
				mobNum.sendKeys(mobNumvalue);
				homeTelnum.sendKeys(homeTelnumvalue);
				officeTelnum.sendKeys(officeTelnumvalue);
				System.out.println("Contact Information Added");
			}
			
			///Home Address
			@FindBy(xpath="//input[@name='home_postalCode']")
			WebElement postalcode;
			@FindBy(xpath="//input[@name='home_typeOfDwelling']")
			WebElement typeDwelling;
			@FindBy(xpath="//input[@placeholder='Enter Floor']")
			WebElement floorNo;
			@FindBy(xpath="//input[@placeholder='Enter Unit Number']")
			WebElement unitNo;
			
			public void inputhomeAddress(String postalcodevalue, String typedwellingvalue, String floornovalue, String unitnovalue) throws InterruptedException
			{
				postalcode.sendKeys(postalcodevalue);	Thread.sleep(3000);
				typeDwelling.sendKeys(typedwellingvalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);Thread.sleep(3000);
				floorNo.sendKeys(floornovalue);
				unitNo.sendKeys(unitnovalue);
				System.out.println("Home Address Added");
			}
		
			///Education Information
			@FindBy(xpath="//input[@name='Educationlvl']")
			WebElement eduLevel;
			@FindBy(xpath="//input[@name='nameOfHighestInstitution']")
			WebElement highestInstitution;

			
			public void inputEducationInformation(String eduLevelvalue, String highestInstitutionvalue)
			{
				eduLevel.sendKeys(eduLevelvalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
				highestInstitution.sendKeys(highestInstitutionvalue);
				System.out.println("Education Information Added");
			}
			
			///Occupation Information
			@FindBy(xpath="//input[@placeholder='Select Economic Status']")
			WebElement economicStatus;
			@FindBy(xpath="//input[@placeholder='Select Employment Sector']")
			WebElement emplSector;
			@FindBy(xpath="//input[@name='occupationcategory']")
			WebElement occupationCat;
			@FindBy(xpath="//input[@name='occupation']")
			WebElement occupation;
			@FindBy(xpath="//input[@name='companyName']")
			WebElement company;
			
			public void inputOccuptationInfo(String economicStatusvalue, String emplSectorvalue,String occupationCatvalue,
					String occupationvalue,String companyvalue)
			{
				economicStatus.sendKeys(economicStatusvalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
				//26 Sept Update - employment sector field is removed
//				emplSector.sendKeys(emplSectorvalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
				occupationCat.sendKeys(occupationCatvalue, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
				occupation.sendKeys(occupationvalue);
				company.sendKeys(companyvalue);
				System.out.println("Occupation Information Added");
				
			}
			@FindBy(xpath="//div[text()='NRIC']//following-sibling::div")
			WebElement assertNRIC;
			@FindBy(xpath="//div[text()='Salutation']//following-sibling::div")
			WebElement assertSalutation;
			@FindBy(xpath="//div[text()='Full Name']//following-sibling::div")
			WebElement assertFullName;
			@FindBy(xpath="//div[text()='Surname']//following-sibling::div")
			WebElement assertSurname;
			@FindBy(xpath="//div[text()='Alias']//following-sibling::div[1]")
			WebElement assertAlias;
			@FindBy(xpath="//div[text()='Preferred Name']//following-sibling::div[1]")
			WebElement assertPreferredName;
			@FindBy(xpath="//div[text()='Sex']//following-sibling::div[1]")
			WebElement assertSex;
			@FindBy(xpath="//div[text()='Date of Birth (Age)']//following-sibling::div[1]")
			WebElement assertDOB;
			@FindBy(xpath="//div[text()='Nationality']//following-sibling::div[1]")
			WebElement assertNationality;
			@FindBy(xpath="//div[text()='Singapore PR?']//following-sibling::div[1]")
			WebElement assertSingaporePR;
			@FindBy(xpath="//div[text()='Country of Birth']//following-sibling::div[1]")
			WebElement assertCOB;
			@FindBy(xpath="//div[text()='Date of Citizenship Certificate']//following-sibling::div[1]")
			WebElement assertDOCC;
			@FindBy(xpath="//div[text()='Marital Status']//following-sibling::div[1]")
			WebElement assertMaritalStatus;
			@FindBy(xpath="//div[text()='NS Status']//following-sibling::div[1]")
			WebElement assertNSstatus;
			@FindBy(xpath="//div[text()='Race']//following-sibling::div[1]")
			WebElement assertRace;
			@FindBy(xpath="//div[text()='Religion']//following-sibling::div[1]")
			WebElement assertReligion;

			@FindBy(xpath="//div[text()='Email Address']//following-sibling::div[1]")
			WebElement assertEmailAddress;
			@FindBy(xpath="//div[text()='Office Telephone Number']//following-sibling::div[1]")
			WebElement assertOfficeTelNumber;
			@FindBy(xpath="//div[text()='Mobile Number']//following-sibling::div[1]")
			WebElement assertMobileNumber;
			@FindBy(xpath="//div[text()='Mail To']//following-sibling::div[1]")
			WebElement assertMailTo;
			@FindBy(xpath="//div[text()='Home Telephone Number']//following-sibling::div[1]")
			WebElement assertHomeTelNumber;
					
			@FindBy(xpath="//div[text()='Educational Level']//following-sibling::div[1]")
			WebElement assertEducationLevel;
			@FindBy(xpath="//div[text()='Name of Highest Institution Attended']//following-sibling::div[1]")
			WebElement assertNameHighestInstitutionAttended;
			
			@FindBy(xpath="//div[text()='Economic Status']//following-sibling::div[1]")
			WebElement assertEconomicStatus;
			@FindBy(xpath="//div[text()='Employment Sector']//following-sibling::div[1]")
			WebElement assertEmploymentSector;
			@FindBy(xpath="//div[text()='Occupation Category']//following-sibling::div[1]")
			WebElement assertOccupationCategory;
			@FindBy(xpath="//div[text()='Occupation']//following-sibling::div[1]")
			WebElement assertOccupation;
			@FindBy(xpath="//div[text()='Name of Company']//following-sibling::div[1]")
			WebElement assertNameofCompany;
			
			@FindBy(xpath="//button[text()='Submit']")
			WebElement submitBTN;
			
			
	
	
	
	
	
	
}
