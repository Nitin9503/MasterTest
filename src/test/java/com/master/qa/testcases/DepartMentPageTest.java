package com.master.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;
import com.master.qa.base.TestBase;
import com.master.qa.pages.DepartMentPage;
import com.master.qa.pages.HomePage;
import com.master.qa.pages.LoginPage;
import static com.master.qa.pages.DepartMentPage. AddNewDepBtn;

public class DepartMentPageTest extends TestBase{
	public static int depaSize;
	public static int rowCount;
	LoginPage loginPage;
	HomePage homePage;
	DepartMentPage departMentPage;
	Xls_Reader reader = new Xls_Reader("E:\\Appium1\\Com.Master.Test\\src\\main\\java\\com\\testData\\ItemDataList.xlsx");
	
	public DepartMentPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		
		   
		    initialization();
		    loginPage = new LoginPage();
		    homePage = new HomePage(); 
		    departMentPage = new DepartMentPage();
		    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		    Thread.sleep(2000);
		    driver.get(prop.getProperty("departUrl"));
		    Thread.sleep(2000);
		    int depaSize=departMentPage.validateAddedDepaRow();
		    System.out.println(depaSize);
		    Thread.sleep(2000);
		    departMentPage=homePage.validateNewDepart();
		    
		    
	}
	@Test(priority=0)
	public void depaWindowTitleTest(){
		String DepartWindowtext=departMentPage.validateDepaWindowTitle();
		System.out.println(DepartWindowtext);
		Assert.assertEquals(DepartWindowtext, "Department", "department window text not match");
		
	}
	
	@Test(priority=1)
	public void depaNameAndCodeTest() throws InterruptedException{
		int rowCount=reader.getRowCount("Department_data");
		 for(int rowNum=2; rowNum<=rowCount; rowNum++)
		 {
			 Thread.sleep(2000);
			 try {
				if(AddNewDepBtn.isDisplayed()){
					departMentPage=homePage.validateNewDepart();
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			    
			    String dapaMentCode = reader.getCellData("Department_data", "DepartMent_Code", rowNum); 
			    System.out.println(dapaMentCode);
			    String departMentName = reader.getCellData("Department_data", "DepartMent_Name", rowNum);
		        System.out.println(departMentName);
		departMentPage.depaNameAndCode(dapaMentCode, departMentName);
		int depaSize1=departMentPage.validateAddedDepaRow();
	    System.out.println(depaSize1);
	    Assert.assertEquals(depaSize1, depaSize+1, "department not added hence mot match");
		 }
		 
	}
	
	@Test(priority=2)
	public void depaCancelClickTest(){
		
		departMentPage.validateCancelClick();
		System.out.println("");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		
	}

}
