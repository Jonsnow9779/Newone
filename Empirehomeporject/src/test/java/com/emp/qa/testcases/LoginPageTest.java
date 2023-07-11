package com.emp.qa.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emp.qa.basetest.Basetest;
import com.emp.qa.pages.HomePage;
import com.emp.qa.pages.Loginpage;

public class LoginPageTest extends Basetest{
	Loginpage loginpage; // class and reference variable
	HomePage homepage;
	
	public LoginPageTest() throws IOException {
		super(); // properties for parent class	
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		loginpage = new Loginpage();
		homepage = new HomePage();
		initialization();
	}
	
	@Test 
	public void verifyLoginPageTest() throws Throwable {
		homepage = loginpage.verifyloginpage();	
	}
	
	@Test 
	public void verifyPageTitile() {
		String title =loginpage.verifyPagetitle();
		Assert.assertEquals(title, "Empire Home Admin Panel");
	}
	
	@Test 
	public void verifyEmpLogoTest() {
		boolean img =loginpage.verifyEmpLogo();
		Assert.assertTrue(img);
	}
	
	
	
@AfterMethod
public void teaerdown() {
//	driver.close();
}
}
