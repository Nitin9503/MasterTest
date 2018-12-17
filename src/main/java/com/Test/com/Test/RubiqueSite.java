package com.Test.com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RubiqueSite {
	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "E:\\AppiumFile\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();      
		 driver.get("https://www.rubique.com/");
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         driver.manage().window().maximize();
         driver.findElement(By.xpath(".//*[@id='navbarSupportedContent']/ul/li[1]/a")).click();
         Thread.sleep(2000);
         //driver.findElement(By.className("Select-arrow")).click();
         Select Oselect = new Select(driver.findElement(By.xpath("//*[@id='react-select-2--value']/div[1]")));
         Oselect.selectByVisibleText("Agra");
         
}
}