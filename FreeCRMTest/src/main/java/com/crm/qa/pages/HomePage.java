package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(), 'User: Demo User')]")
	@CacheLookup
	WebElement userName;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//body//form//form//table//input[3]")
	WebElement newContactButton;
	
	//Initialization of the Page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsernName() {
		return userName.isDisplayed();
		
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDealsLink() {
		contactsLink.click();
		return new DealsPage();
	
	}
	
	public TasksPage clickOnTasksLink() {
		contactsLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		newContactLink.click();
		
		contactsLink.click();
		newContactButton.click();
		
	}

}
