package com.mmp.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PatientHomePage extends PageObject{

	
	@FindBy(how=How.XPATH, using = "//a[@href='profile.php']")
	WebElement profileBtn;
	

	public PatientHomePage(WebDriver driver) {
		super(driver);
	}
	
	public PatientProfilePage profileButton() {
		
	 profileBtn.click();	
	 
	return new PatientProfilePage(driver);
	}
	

	public void verifyHome(){
		String expected = "home";
		String actual = driver.getTitle();
		boolean hTitle = actual.equals(expected);
		assertTrue(hTitle);
		System.out.println(expected+"===="+actual);
	  }

	

}
