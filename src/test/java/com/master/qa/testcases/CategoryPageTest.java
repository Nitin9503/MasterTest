package com.master.qa.testcases;

import static com.master.qa.pages.DepartMentPage.AddNewDepBtn;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;
import com.master.qa.base.TestBase;
import com.master.qa.pages.CategoryPage;
import com.master.qa.pages.LoginPage;
import com.master.qa.util.CustomListener;
@Listeners(CustomListener.class)
public class CategoryPageTest extends TestBase {
	
	public static String depaName="";
	LoginPage loginPage;
	LoginPageTest loginPageTest;
	CategoryPage categoryPage;
	Xls_Reader reader = new Xls_Reader("E:\\Appium1\\Com.Master.Test\\src\\main\\java\\com\\testData\\ItemDataList2.xlsx");
	public CategoryPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
	    loginPage=new LoginPage();
	    loginPageTest=new LoginPageTest();
	    categoryPage=new CategoryPage();
	    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    
	}
	/*@Test(priority=0)
	public void CategoryPageTitleTest() throws InterruptedException{
		Thread.sleep(3000);
		String catepagetitle=categoryPage.validateCategoryPageTitle();
		System.out.println(catepagetitle);
		assertEquals(catepagetitle, "Categories", "Title does not match");
		
	}
	@Test(priority=1)
	public void addNewCateClickTest() throws InterruptedException{
		categoryPage.validateaddNewCateClick();
		Thread.sleep(3000);
		Assert.assertTrue(true, "category window title not displayed");
		
	}*/
	@Test(priority=3)
	public void AddNewCateDataTest() throws InterruptedException{
		int rowCount=reader.getRowCount("Category_data");
		 for(int rowNum=2; rowNum<=rowCount; rowNum++)
		 {
			 Thread.sleep(2000);
			    String categoryCode = reader.getCellData("Category_data", "Category_Code", rowNum); 
			    System.out.println(categoryCode);
			    String categoryName = reader.getCellData("Category_data", "Category_Name", rowNum);
		        System.out.println(categoryName);
		        String departmentName = reader.getCellData("Category_data", "Department_Name", rowNum);
		        System.out.println(departmentName);
		categoryPage.validateAddNewCateData(categoryCode, categoryName, departmentName);
		//driver.findElement(By.xpath("//div[@id='DepartmentListGrid']//td[text()='" + depaName+ "'")).click();
		
		/*int depaSize1=departMentPage.validateAddedDepaRow();
	    System.out.println(depaSize1);
	    Assert.assertEquals(depaSize1, depaSize+1, "department not added hence mot match");*/
		}
		
		
		
	}
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
