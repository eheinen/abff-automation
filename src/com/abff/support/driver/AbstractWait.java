package com.abff.support.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractWait {

	private static final long POOL = 100;
	private static final int TIMEOUT = 10;
	private static WebDriver driver = null;
	
	public AbstractWait(){
		driver = Driver.getInstance();
	}
	
	/**
	 * Responsible for pause the Thread in execution
	 * @param milliseconds Time to stop
	 */
	public static void pause(long milliseconds){
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Responsible for wait an element be displayed on the screen
	 * @param element Element to wait
	 * @return Element
	 */
	public static WebElement waitForElementDisplayed(WebElement element){	
		int timeout = TIMEOUT;
		while(!element.isDisplayed() || timeout > 0){
			pause(POOL);
			timeout--;
		}
		return element;
	}
	
	/**
	 * Responsible for wait an title be displayed on the screen according to the text
	 * @param title Text to wait
	 * @return Title
	 */
	public static String waitForTitle(String title){	
		int timeout = TIMEOUT;
		while(!driver.getTitle().equals(title) || timeout > 0){
			pause(POOL);
			timeout--;
		}
		return driver.getTitle();
	}
	
}
