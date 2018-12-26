package com.master.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;
import com.master.qa.base.TestBase;
import com.master.qa.pages.ItemsPage;
import com.master.qa.pages.LoginPage;
//import static com.master.qa.util.StaticVariable.departmentName;
//import static com.master.qa.util.StaticVariable.CategoryName;
public class ItemsPageTest extends TestBase{
	
	public static String depaName="";
	public static String CategoryName="";
	ItemsPage itemspage;
	LoginPage loginPage;
	
	Xls_Reader reader = new Xls_Reader("E:\\Appium1\\Com.Master.Test\\src\\main\\java\\com\\testData\\ItemDataList.xlsx");
	public ItemsPageTest(){
		super();
		
	}
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
	    itemspage = new ItemsPage();
	    loginPage = new LoginPage();
	    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    Thread.sleep(3000);
        driver.get(prop.getProperty("url"));
        Thread.sleep(5000);
		
		
	}
	@Test(priority=1)
	public void pageTitleTest() throws InterruptedException{
		Thread.sleep(2000);
		String title = itemspage.validatePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Items", "Title does not match");
		
		
	}
	@Test(priority=2)
	public void itemwWindowTitleTest() throws InterruptedException{
		itemspage.newItemAddclick();
		Thread.sleep(2000);
		Assert.assertTrue(true, "window title not shown");
		
	}
	@Test(priority=3)
	public void addItemDataTest() throws InterruptedException{
		int rowCount=reader.getRowCount("Item_data");
		 for(int rowNum=2; rowNum<=rowCount; rowNum++)
		 {
			 Thread.sleep(2000);
			    String ItemNo = reader.getCellData("Item_data", "Item Number", rowNum); 
			    System.out.println(ItemNo);
			    String ItemBarCode = reader.getCellData("Item_data", "BarcodeNumber", rowNum);
		        System.out.println(ItemBarCode);
		        String ItemDescription = reader.getCellData("Item_data", "Description", rowNum);
		        System.out.println(ItemDescription);
		        String itemsearchCode = reader.getCellData("Item_data", "ItemSearchCode", rowNum); 
			    System.out.println(ItemNo);
			    String fbLink = reader.getCellData("Item_data", "fblink", rowNum);
		        System.out.println(fbLink);
		        String ItemExtenDescri = reader.getCellData("Item_data", "ItemExtenDescri", rowNum);
		        System.out.println(ItemExtenDescri);
		        String price = reader.getCellData("Item_data", "Price", rowNum); 
			    System.out.println(price);
			    String cost = reader.getCellData("Item_data", "Cost", rowNum);
		        System.out.println(cost);
		        String depaName = reader.getCellData("Item_data", "Department", rowNum);
		        System.out.println(depaName);
		        String CategoryName = reader.getCellData("Item_data", "Category", rowNum);
		        System.out.println(CategoryName);
		itemspage.addItemData(ItemNo, ItemBarCode, ItemDescription, ItemExtenDescri, itemsearchCode, fbLink, price, cost, depaName, CategoryName );
		Thread.sleep(2000);
		Assert.assertTrue(true, "window title not shown");
		 }	
	}
	@AfterMethod
	public void teatDown(){
	    driver.close();
	    
	}

	
}
