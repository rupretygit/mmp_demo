package com.mmp.page;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PatientViewHistoryPage extends PageObject{

	
	@FindBy(how=How.XPATH, using = "//input[@value='Past Transaction']")	                                
	WebElement pTrans;
	
	@FindBy(how=How.XPATH, using = "//input[@value='Past Appointments']")	                                
	WebElement pAppoint;
	
	@FindBy(how=How.XPATH, using = "//input[@value='Past Diagnosis']")	                                
	WebElement pDiag;
	
	@FindBy(how=How.XPATH, using = "//input[@value='Past Prescription']")	                                
	WebElement pPres;
	

	@FindBy(how=How.XPATH, using = "//span[contains(text(),'Messages')]")	                                
	WebElement msgBtn;
	
		
	public PatientViewHistoryPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
    public void verifyViewHistoryTitle(){
		String expected = "history";
		String actual = driver.getTitle();
		boolean historyTitle = actual.equals(expected);
		assertTrue(historyTitle);	
		System.out.println(expected+"===="+actual);
		
	 }
    
	public void pastTransactionBtn() {
	
		pTrans.click();
		
		String completeString = "PAST TRANSACTION";
		String expected = toProperCase(completeString).trim();
		
		String actual = pTrans.getAttribute("value").trim();
		
		boolean result = actual.equals(expected);
		assertTrue(result);
	   }
	
	
	 static String toProperCase(String str) {
		
		String[] splitStrings = str.split(" ");
		String camelCase = ""; 
		
		for(String wordByword: splitStrings)
		{
			camelCase = camelCase + toCamelCase(wordByword); 
			
		}
		return camelCase;
	  }   
	
	 
	 static String toCamelCase(String s){
		return s.substring(0,  1).toUpperCase()+s.substring(1).toLowerCase()+" ";
	 }
	
	 
	 
    public void pastAppointmentBtn() {
    	 pAppoint.click();
    	 back2PreviousPage();
    	
    	 String completeString = "PAST APPOINTMENTS";
 		 String expectedStr = toProperCase(completeString).trim();
		
 		String actual = pAppoint.getAttribute("value").trim();
 		
 		boolean result = actual.equals(expectedStr);
 		assertTrue(result);     
     }

    public void pastDiagnosisBtn() {
      
      pDiag.click();
      back2PreviousPage();
      
      String completeString = "PAST DIAGNOSIS";
      String expected = toProperCase(completeString).trim();
	  String actual = pDiag.getAttribute("value").trim();
		
	  boolean result = actual.equals(expected);
	  assertTrue(result);     
     }

    public void pastPrescriptionBtn() {
     
     pPres.click();
     back2PreviousPage();
     String completeString = "PAST PRESCRIPTION";
     String expected = toProperCase(completeString).trim();
	 String actual = pPres.getAttribute("value").trim();
		
	 boolean result = actual.equals(expected);
	 assertTrue(result);     
	  
    }
    
    
    public void back2PreviousPage() {
      driver.navigate().back();
    }

    public PatientMessagePage messageBtn() {
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
    	msgBtn.click();
    	boolean mBtn = msgBtn.equals(msgBtn);
   	    assertTrue(mBtn);
		return new PatientMessagePage(driver);
	 }
	
    
}
