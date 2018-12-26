package com.master.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.master.qa.testcases.CategoryPageTest.depaName;

import com.master.qa.base.TestBase;

public class CategoryPage extends TestBase{
	
	@FindBy(id="NewCategory")
	WebElement addNewCategory;  
	
	@FindBy(id="Category_wnd_title")
	WebElement CateWindowTitle; 
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement Cstaus;
	
	@FindBy(xpath="//div[@id='categoryInfo']/div[@id='second']/p/input")
	WebElement categoryCode;
	
	@FindBy(xpath=".//*[@id='third']/p/input")
	WebElement categoryName;

	@FindBy(xpath="//button[@type='button' and text()='Browse']")
	WebElement depaBrowse;
	
	@FindBy(xpath="//div[@id='DepartmentListGrid']//td[text()='Food2']")
	WebElement depaSelect;
	
	@FindBy(xpath="//input[@type='button' and @value='OK']")
	WebElement depaOkBtn;
	
	@FindBy(xpath="//button[@class='alert-confirm k-button']")
	WebElement cateAlertOkBtn;
	
	@FindBy(xpath="html/body/div[7]/div[1]/div/a/span")
	WebElement cateWndCancelBtn;
	 
	
	@FindBy(xpath="//span[text()='Save and Close']")
	WebElement cateSaveCloseBtn;
	
	@FindBy(xpath="//button[@class='save-cancel k-button']")
	WebElement cateSaveNoBtn;
	
	@FindBy(xpath="//div[@id='DepartmentListGrid']//a[@class='k-link k-pager-nav' and @title='Go to the next page']")
	WebElement cateNextListBtn;
	
	@FindBy(xpath="//div[@id='DepartmentListGrid']//a[@class='k-link k-pager-nav' and @title='Go to the previous page']")
	WebElement catePreviousListBtn;
	
	public CategoryPage(){
		PageFactory.initElements(driver, this);
	}
    
	public String validateCategoryPageTitle(){
		return driver.getTitle();
	}
	
	public String validateCateWindowTitle(){
		return CateWindowTitle.getText();
	}
	
	public boolean validateaddNewCateClick(){
	    addNewCategory.click();
	    return CateWindowTitle.isDisplayed();
	    
	}
	
	
	public void validateAddNewCateData(String cateCode, String cateName, String depaName) throws InterruptedException{
		
		addNewCategory.click();
		Cstaus.click();
		categoryCode.sendKeys(cateCode);
		categoryName.sendKeys(cateName);
		depaBrowse.click();
		Thread.sleep(1000);
		System.out.println(depaName);
		 for(int i=1; i<=3; i++){
        	 System.out.println("it enter into for loop "+i);
        	 try {
        		 Thread.sleep(1000);
				if(driver.findElement(By.xpath("//div[@id='DepartmentListGrid']//td[text()='"+depaName+"']")).isDisplayed()){
					Thread.sleep(1000);
					System.out.println("it enter into try block");
					driver.findElement(By.xpath("//div[@id='DepartmentListGrid']//td[text()='"+depaName+"']")).click();
					break;
				 }
				
			} catch (Exception e) {
				    System.out.println("it enter into try block");
				    //cateNextListBtn.click();
				    //e.printStackTrace();
				    try {
				    	
						if(cateNextListBtn.isDisplayed()){
							 cateNextListBtn.click();
						     	
						}
					} catch (Exception e2) {
						catePreviousListBtn.click();
						// TODO: handle exception
					}
			}
        	 
         }
		//driver.findElement(By.xpath("//div[@id='DepartmentListGrid']//td[text()='"+depaName+"']")).click();
		//depaSelect.click();
		Thread.sleep(1000);
		depaOkBtn.click();
		cateSaveCloseBtn.click();
		try {
			if(cateAlertOkBtn.isDisplayed()){
				System.out.println("The category Code is already in use");
				cateAlertOkBtn.click();
				cateWndCancelBtn.click();
				Thread.sleep(2000);
				cateSaveNoBtn.click();
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		
	}
	
}


