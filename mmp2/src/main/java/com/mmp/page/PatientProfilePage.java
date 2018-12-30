package com.mmp.page;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Listeners;

public class PatientProfilePage extends PageObject{

	
	@FindBy(how=How.XPATH, using = "//button[contains(text(),'View History')]")	                                
	WebElement vHistory;
	
	
	public PatientProfilePage(WebDriver driver) {
		super(driver);
	}

	public PatientViewHistoryPage viewHistory() {
		
		scrollDown();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
		vHistory.click();		
		return new PatientViewHistoryPage(driver);
	}

	
	public void scrollDown() {
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1300)");
	}
	
	
	public void verifyProfile(){
		String expected = "profile";
		String actual = driver.getTitle();
		boolean proTitle = actual.equals(expected);
		assertTrue(proTitle);		
		 
		 boolean btnClick = vHistory.equals(vHistory); 
		 assertTrue(btnClick);
			
	}


}
