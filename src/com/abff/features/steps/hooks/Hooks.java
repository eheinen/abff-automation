package com.abff.features.steps.hooks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.abff.support.driver.AbstractDriver;
import com.abff.support.driver.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends AbstractDriver {
	
	@Before
	public void before(){
		Driver.getInstance();
		open(System.getProperty("application"));
	}
	
	@After
	public void after(Scenario scenario){
		if(!Driver.isClosed()){
			if(scenario != null && scenario.isFailed()){
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MMM_uuuu hh_mm_ss_a");
	        	String fileName = scenario.getName() + " " + LocalDateTime.now().format(formatter) + ".jpg";
	        	takeScreenShot(System.getProperty("screenshot_path_fail"), fileName);
			}
			quit();
		}
	}
	
}
