package com.master.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.master.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page Factory
	@FindBy(id="usernm")
	WebElement username;
	
	@FindBy(id="pwd")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//h1[text()='Login']")
	WebElement loginLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action:
	/*public String validateLoginPageTitle(){
		return driver.getTitle();
		
	}*/
	public String validateLoginPageLogo(){
		return loginLogo.getText();
	}
	
	public boolean validateLoginImage(){
		return loginLogo.isDisplayed();
	}
	
	public HomePage login(String usn, String pwd ){
		username.sendKeys(usn);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
		
	}
	
	
	
	
	

}
