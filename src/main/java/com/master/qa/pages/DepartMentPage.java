package com.master.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.master.qa.base.TestBase;

public class DepartMentPage extends TestBase{
	
	public int depaRowSize1;
	@FindBy(id="addNew")
	public static WebElement AddNewDepBtn;
	
	@FindBy(xpath="html/body/div[8]/div[1]/div")
	WebElement CancelDepart;
	
	@FindBy(id="Department_wnd_title")
	WebElement DepaWindowTitle;
	
	@FindBy(xpath="//div[@id='deptInfo']/div[@id='first']/p/input")
	WebElement dStatus; 
	
	@FindBy(xpath="//div[@id='deptInfo']/div[@id='second']/p/input")
	WebElement depaCode;
	
	@FindBy(xpath="//div[@id='deptInfo']/div[@id='third']/p/input")
	WebElement depaName; 
	
	@FindBy(xpath="//div[@id='Department']//span[contains(text(), 'Save and New')]")
	WebElement saveAndNewBtn;
	
	@FindBy(xpath="//div[@id='Department']//span[contains(text(), 'Save and Close')]")
	WebElement saveAndCloseBtn;
	
	@FindBy(xpath="//div[@id='departmentMainGrid']//tbody/tr")
	WebElement depaRowSize;
	
	public DepartMentPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateDepaWindowTitle(){
		return DepaWindowTitle.getText();
		
	}
	public int validateAddedDepaRow(){
		return driver.findElements(By.xpath("//div[@id='departmentMainGrid']//tbody/tr")).size();
		
		
	} 
	
	public DepartMentPage depaNameAndCode(String dCode, String dName){
		dStatus.click();
		depaCode.sendKeys(dCode);
		depaName.sendKeys(dName);
		saveAndCloseBtn.click();
		
		return new DepartMentPage();
		 
		
	}
	
	public DepartMentPage validateCancelClick(){
	    CancelDepart.click();
	    return new DepartMentPage();
		
	}
}
