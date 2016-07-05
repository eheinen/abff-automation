package com.abff.support.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.abff.support.helper.Settings;

public class Driver {

	private static WebDriver instance = null;

	private Driver() {
	}

	public static WebDriver getInstance() {
		if(isClosed())
			instance = getDriver();
		return instance;
	}
	
	public static boolean isClosed(){
		if(instance == null || ((RemoteWebDriver) instance).getSessionId() == null)
			return true;
		return false;
	}

	/**
	 * Responsible for get the driver according to settings file. The browser
	 * will open in this method.
	 * 
	 * @return Driver created
	 */
	private static WebDriver getDriver() {
		new Settings();
		WebDriver driver = null;
		String browser = System.getProperty("browser");
		
		if(browser == null)
			throw new RuntimeException("Could not read browser property on settings file.");
			
		switch (browser.toUpperCase()) {
		case "CHROME":
			// Estou setando abaixo o local onde o meu ChromeDriver se encontra,
			// ou seja, dentro do diretório do meu projeto.
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			driver = new FirefoxDriver(capabilities);
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;
		case "SAFARI":
			driver = new SafariDriver();
			break;
		case "OPERA":
			driver = new OperaDriver();
			break;
		default:
			throw new RuntimeException("Please, inform a browser driver inside settings.properties");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

}

// http://www.wunderkraut.com/blog/creating-and-running-a-simple-selenium-webdriver-test/2011-09-15
// https://cucumber.io/cucumber-eclipse//update-site
// http://chromedriver.storage.googleapis.com/index.html