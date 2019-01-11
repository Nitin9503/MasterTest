package com.master.qa.util;





import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.master.qa.base.TestBase;

public class ScreenShotHandle extends TestBase{
	public ScreenShotHandle() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String screenshotName;
	public static void takeScreenshot(String filename) throws IOException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		Date date = new Date();
	    String screenshotName = sdf.format(date);
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(".\\screenShot\\"+screenshotName+".jpeg"));
		
		
		
	}
}
