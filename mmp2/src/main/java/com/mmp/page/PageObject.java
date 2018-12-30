package com.mmp.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class PageObject {
	
		 protected WebDriver driver;
         
		    public PageObject(WebDriver driver){
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		    }



}
