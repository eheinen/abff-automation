package com.abff.support.driver;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

public abstract class AbstractDriver extends AbstractWait {
	
	protected static WebDriver driver = null;
	
	public AbstractDriver(){
		driver = Driver.getInstance();
	}
	
	/**
	 * Responsible for close the driver and every window that was open.
	 */
	public static void quit() {
		driver.quit();
	}

	/**
	 * Responsible for close the driver and every window that was open.
	 */
	public static void close() {
		driver.close();
	}
	
	/**
	 * Responsible for open an url according to the part passed through argument
	 * Example:
	 * 	  application = http://www.animalbestfriendforever.com/
	 * 	  partUrl     = login.html
	 *    navigateTo  = http://www.animalbestfriendforever.com/login.html
	 * @param partUrl Part of url
	 */
	public static WebDriver openPart(String partUrl){
		driver.navigate().to(System.getProperty("application") + partUrl);
		return Driver.getInstance();
	}
	
	/**
	 * Responsible for get the window title 
	 * @return Title
	 */
	public static String getTitle(){
		return driver.getTitle();
	}
	
	/**
	 * Responsible for open an url
	 * @param url
	 */
	public static void open(String url){
		driver.navigate().to(url);
	}
	
	public static void takeScreenShot(String screenshotPath, String fileName){
		WebDriver augmentedDriver = new Augmenter().augment(driver);
        File scrFile = ((TakesScreenshot)augmentedDriver).
                            getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(scrFile, new File(screenshotPath + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
