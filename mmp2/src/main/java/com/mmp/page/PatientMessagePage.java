package com.mmp.page;

import static org.testng.Assert.assertTrue;

import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PatientMessagePage  extends PageObject{

	@FindBy(how=How.XPATH, using = "//input[@id='subject']")	                                
	WebElement subject;
	
	@FindBy(how=How.XPATH, using = "//textarea[@id='message']")	                                
	WebElement enterMsg;
	
	@FindBy(how=How.XPATH, using = "//input[@value='Send']")	                                
	WebElement sendBtn;
	
	Alert alert;
	
	
    public PatientMessagePage(WebDriver driver) {
    	super(driver);
	}
    
	public void verifyMessageTitle(){
		String expected = "Send Messages";
		String actual = driver.getTitle();
		boolean result = actual.equals(expected);
		assertTrue(result);
	 }
    
	public void msgSubject() {
		
		Random rand = new Random();
		String subj = "General Health Check#"+100+rand.nextInt(99);
		subject.sendKeys(subj);		
	}

	public void enterMessage() {
		
		String enteredMsg = "It is just regular health checkup once a year";
		enterMsg.sendKeys(enteredMsg);	
	}

	public void sendMsgBtn() {
		
		sendBtn.click();
	}


	public void acceptAlert() {
	  driver.switchTo().alert().accept();
	  String expected = "Messages Successfully sent";
      String actual = alert.getText();
      boolean alertMsg = actual.equals(expected);
 	  assertTrue(alertMsg);
 	     
	}
	

	
}
