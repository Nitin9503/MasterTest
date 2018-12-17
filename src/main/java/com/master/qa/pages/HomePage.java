package com.master.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.master.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(id="addNew")
	WebElement AddNewDepBtn;
	
	@FindBy(xpath="//span[contains(text(),'Department')]")
	WebElement DepatmentLogo; 
	public HomePage(){
		PageFactory.initElements(driver, this);
	} 
	
	public String validateDepaPageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean validateDepartText(){
		return AddNewDepBtn.isDisplayed();
		
	}
	
	public DepartMentPage validateNewDepart(){
		AddNewDepBtn.click();
		return new DepartMentPage();
		
	}
	

}
