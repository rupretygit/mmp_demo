package com.mmp.test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mmp.page.PatientHomePage;
import com.mmp.page.PatientLoginPage;
import com.mmp.page.PatientMessagePage;
import com.mmp.page.PatientProfilePage;
import com.mmp.page.PatientViewHistoryPage;

import appSetup.Base;

@Listeners(appSetup.Base.class)
public class PatientProfileTest extends Base{
	
	   PatientLoginPage loginPage;
	   PatientHomePage home;
	   PatientProfilePage profile;
	   PatientViewHistoryPage vHistory;
	   static PatientMessagePage emailMsg;

	   @Test(priority=0)
	    public void invalid_Username_To_LoginPage(){
	        
	    	loginPage = new PatientLoginPage(driver);
	    	loginPage.userName("rita");
	    	loginPage.passWord("Ria12345");
	    	home = loginPage.signIn();
	    	alertCall();
	     }
	 
	   @Test(priority=1)
	   public void invalid_Password_To_LoginPage() {
	        
	    	loginPage = new PatientLoginPage(driver);
	    	loginPage.userName("ria1");
	    	loginPage.passWord("Rita123");
	    	home = loginPage.signIn();
	    	alertCall();
	     }

		
	     @Test(priority=2)
         public void valid_credentials_LoginPage() {
     
 	     loginPage = new PatientLoginPage(driver);
 	     loginPage.userName("ria1");
 	     loginPage.passWord("Ria12345");
 	     home = loginPage.signIn();
 	   
        }
	 
	   
	    @Test(priority=3)
	    public void homePage(){
	        
	    	home.verifyHome();
	    	profile = home.profileButton();
	     }  
	    
	    @Test(priority=4)
	    public void profilePage(){
	    
            profile.verifyProfile();
            vHistory = profile.viewHistory();
	    }
         
	    @Test(priority=5)
	    public void historyPage(){
            vHistory.verifyViewHistoryTitle();
            vHistory.pastTransactionBtn();
            vHistory.pastAppointmentBtn();
            vHistory.pastDiagnosisBtn();
            vHistory.pastPrescriptionBtn();
           	emailMsg=vHistory.messageBtn();
	     }
	    
	    @Test(priority=6)
	    public void emailPage(){
	    	emailMsg.verifyMessageTitle();
	    	emailMsg.msgSubject();
	    	emailMsg.enterMessage();
	    	emailMsg.sendMsgBtn();
	    	alertCall();
	     }
	    
 }


