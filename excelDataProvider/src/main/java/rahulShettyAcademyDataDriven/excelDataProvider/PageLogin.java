package rahulShettyAcademyDataDriven.excelDataProvider;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {
WebDriver driver;
	
	public PageLogin(WebDriver driver) {
		
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//	WebElement userID = driver.findElement(By.id("outlined-basic"));
	////Pagefactory
	
	public void goTo()
	{
//		driver.get("https://pa-grlpa-sit-intranet.activate.sg/grlpa");
		driver.get("https://pa-grlpa-sit-intranet.dev.activate.sg/grlpa");
		
	}

	@FindBy(id="outlined-basic")
	WebElement userID;
	
	@FindBy(id="LoginPage-button-login")
	WebElement loginBTN;
	
	public void loginApplication(String soeID) throws InterruptedException
	{
		userID.sendKeys(soeID);
		loginBTN.click(); Thread.sleep(5000);
		 
		List<WebElement> popup = driver.findElements(By.xpath("//p[text()='You already have an active session.']"));
		 
		 if(popup.size()!=0) {
			 WebElement popupYes= driver.findElement(By.xpath("//button[text()='Yes']"));
			 popupYes.click();
           System.out.println("You already have an active session. But you choose to proceed!");
		 }else {
        	 System.out.println("Successful Login! Opening Home Page.");
         }
     
	}
}
