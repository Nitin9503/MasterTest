package com.master.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.master.qa.testcases.ItemsPageTest.depaName;
import static com.master.qa.testcases.ItemsPageTest.CategoryName;

import com.master.qa.base.TestBase;
import com.master.qa.util.TestUtil;

public class ItemsPage extends TestBase{
      
	@FindBy(xpath="//input[@id='addNew' and @onclick='addNewItem()']")
	WebElement addnewItemBtn;
	
	@FindBy(name="Item Number")
	WebElement itemNumber;
	
	@FindBy(name="Item_wnd_tit")
	WebElement itemwndText;
	
	@FindBy(name="ItemSearchCode")
	WebElement itemSearchCode;
	
	@FindBy(name="fblink")
	WebElement fblink;
	
	@FindBy(name="BarcodeNumber")
	WebElement barcodeNumber;
	
	@FindBy(xpath=".//*[@id='leftsectionthird']/p/input")
	WebElement description;
	
	@FindBy(xpath=".//*[@id='leftsectionfourth']/p/textarea")
	WebElement extendedDescription;
	
	@FindBy(xpath=".//*[@id='rightsectionfirst']/p/input")
	WebElement itemStatus;
	
	@FindBy(xpath=".//*[@id='rightsectionsecond']/p/span/span/span[2]/span")
	WebElement itemType;
	
	@FindBy(xpath="html/body/div[38]/div/ul/li[2]")
	WebElement itemTypeClick;
	
	@FindBy(xpath="//div[@id='rightsectionthird']//button[text()='Browse']")
	WebElement DepaBrowse;
	
	@FindBy(xpath="//div[@id='DepartmentGrid']//span[text()='select']")
	WebElement DepaListCount;
	
	@FindBy(xpath="html/body/div[62]/div/ul/li[1]")
	WebElement DepaListCountclick;
	
	@FindBy(xpath="//div[@id='DepartmentGrid']//a[@title='Go to the next page' and @class='k-link k-pager-nav']")
	WebElement depaListNextbtn;
	
	@FindBy(xpath="//div[@id='DepartmentGrid']//a[@title='Go to the previous page' and @class='k-link k-pager-nav']")
	WebElement depaListpreviousbtn;
	
	@FindBy(xpath="//div[@id='DepartmentGrid']//td[text()='Food']")
	WebElement depaSelect;
	
	@FindBy(xpath="//input[@onclick='selectDepartment()']")
	WebElement depaSelectOk;
	
	@FindBy(xpath="//div[@id='rightsectionfourth']//button[text()='Browse']")
	WebElement cateBrowse;
	
	@FindBy(xpath="//div[@id='CategoryGrid']//td[text()='Chinese Menu']")
	WebElement cateSelect;
	
	@FindBy(xpath="//input[@onclick='selectCategory()']")
	WebElement cateSelectOk;
	
	@FindBy(xpath="//div[@id='PriceAndCostForItem']//div[@id='rightsectionsix']//input[@type='text' and @style='width: 55%' and @class='k-textbox']")
	WebElement itemPrice;
	
	@FindBy(xpath="//div[@id='PriceAndCostForItem']//div[@id='rightsectionseven']//input[@type='text' and @style='width: 55%' and @class='k-textbox']")
	WebElement itemCost;
	
	@FindBy(xpath="//img[@id='ItemPicture' and @src='resources/ItemsImages/item_logo.jpg' and @style='margin-left:150px']")
	WebElement itemImage;
	
	@FindBy(xpath="//div[@id='Item']//span[text()='Save and Close']")
	WebElement itemSaveAndCloseBtn;
	
	
	public ItemsPage(){
		PageFactory.initElements(driver, this);
		
	}
	public String validatePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateItemWindowTitle(){
		return itemwndText.isDisplayed();
	}
	
	public String validateItemWindowTitle1(){
		return itemwndText.getText();
	}
	
	public void newItemAddclick(){
		addnewItemBtn.click();
	}
	public void addItemData(String ItemNo, String ItemBarCode, String ItemDescription, String ItemExtenDescri, String itemsearchCode, String fbLink, String price, String cost, String depaName, String CategoryName ) throws InterruptedException{
		addnewItemBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		itemNumber.sendKeys(ItemNo);
		barcodeNumber.sendKeys(ItemBarCode);
		description.sendKeys(ItemDescription);
		itemSearchCode.sendKeys(itemsearchCode);
		fblink.sendKeys(fbLink);
		extendedDescription.sendKeys(ItemExtenDescri);
		itemStatus.click();
		itemType.click();
		itemTypeClick.click();
		DepaBrowse.click();
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DepaListCount.click();
		DepaListCountclick.click();
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 for(int i=1; i<=3; i++){
        	 System.out.println("it enter into for loop "+i);
        	 try {
        		    System.out.println(depaName);
				if(driver.findElement(By.xpath("//div[@id='DepartmentGrid']//td[text()='"+depaName+"']")).isDisplayed()){
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					//Thread.sleep(1000);
					System.out.println("it enter into try block");
					//driver.findElement(By.xpath("//div[@id='DepartmentGrid']//td[text()='Beverage1']")).click();
					driver.findElement(By.xpath("//div[@id='DepartmentGrid']//td[text()='"+depaName+"']")).click();
					break;
				 }
			} catch (Exception e) {
				    System.out.println("it enter into first catch block");
				    //depaListNextbtn.click();
				    e.printStackTrace();
				    try {
				    	System.out.println("it enter into try block of  catch block");
						if(depaListNextbtn.isDisplayed()){
							System.out.println("it enter into if condition and shown depaListNextbtn");
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							//Thread.sleep(1000);
						   depaListNextbtn.click(); 
						}
					} catch (Exception e2) {
						System.out.println("it enter into second catch block");
						depaListpreviousbtn.click();
						e2.printStackTrace();
						// TODO: handle exception
					}
			}
        	 
         }
		
		//depaSelect.click();
		depaSelectOk.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		cateBrowse.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		try {  
       		System.out.println(CategoryName);
       		Thread.sleep(3000);
    		//driver.findElement(By.xpath("//td[text()='"+CategoryName+"']")).click();
    		driver.findElement(By.xpath("//div[@id='categoryGrid']//div[@class='k-grid-content']//td[text()='"+CategoryName+"']")).click();
    		//driver.findElement(By.xpath(".//*[@id='categoryGrid']/div[3]/table/tbody/tr[5]/td[3]")).click();
           	System.out.println("it enter into for loop ");   
			} catch (Exception e) {
				    System.out.println("it enter into catch block");
				   // depaListNextbtn.click();
				    e.printStackTrace();
			}
        //cateSelect.click();
		cateSelectOk.click();
		itemPrice.sendKeys(price);
		itemCost.sendKeys(cost);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		itemSaveAndCloseBtn.click();
	
		//addnewItemBtn.click();
	}
}
 