package com.mmp.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.asserts.SoftAssert;


public class PatientLoginPage extends PageObject{

	@FindBy(how=How.XPATH, using = "//input[@id='username']")
	WebElement uname;
	
	@FindBy(how=How.XPATH, using = "//input[@id='password']")
	WebElement pword;
	
	@FindBy(how=How.XPATH, using = "//input[@value='Sign In']")
	WebElement sign;
	
	SoftAssert sa = new SoftAssert();
	
	public PatientLoginPage(WebDriver driver) {
		super(driver);
	}


	public void userName(String user) {
		
		uname.sendKeys(user);		
	}
	
	
    public void passWord(String pass) {
		
	 	pword.sendKeys(pass);
	}
	

    public PatientHomePage signIn() {
		
		sign.click();
		
	return new PatientHomePage(driver);		
	}
    
}
