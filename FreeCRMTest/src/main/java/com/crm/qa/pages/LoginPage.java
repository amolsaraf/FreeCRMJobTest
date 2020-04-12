package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory or Object Repository
	// Alternate method for driver.findElement(By.name("value"))
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Sign Up')]")
	WebElement signUp;
	
	@FindBy(xpath="//a[@class='navbar-brand']/img[@class = 'img-responsive']")
	WebElement crmLogo;
	
//	Create a constructor to initialize the above elements created.
// 	Interview Question = How to initialize the Page Factory.	

	//Initializations
	public LoginPage() {
	PageFactory.initElements(driver, this);
// 	(driver, this) here driver are initialized which are created in the class LoginPage 
//	and this is used to point the class in which the constructor method is created i.e. LoginPage 		
		
	}

	//Actions - i.e Features which i want to perform
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();  //It should return HomePage() class object as the landing page is 
								//Homepage after login
	
	}
}
