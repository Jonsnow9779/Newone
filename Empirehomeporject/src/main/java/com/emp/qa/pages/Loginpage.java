package com.emp.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emp.qa.basetest.Basetest;

public class Loginpage extends Basetest { //child class inherit properties from parent class
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(xpath ="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath = "html/body/div/div/div/div/div[2]/form/div[4]/button")
	WebElement loginbtn;
	
	@FindBy(xpath ="//img[@src='/WebApp/assets/dist/img/logo.png']")
	WebElement emplogo;
	
	public Loginpage() throws IOException {
		super();
		PageFactory.initElements(driver, this); 
		// pagefactory class have initelements method which used for driver operations 
	}
	
	public boolean verifyEmpLogo() {
		return emplogo.isDisplayed();
	}
	
	public String verifyPagetitle() {
		return driver.getTitle();
	}
	public HomePage verifyloginpage() throws Throwable {
		email.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginbtn.click();  
		return new HomePage();
	}

}
