package com.abff.support.helper;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/test_report/"},
		//plugin = {"pretty", "html:/Users/eheinen/Workspace/qa/cucumber/cucumber-report/report/"},
		glue = { "com.abff.features" }, // hooks and steps
		features = {"src/com/abff/features/specs/"} // specs
        //tags = "@login"
)
public class RunCukies {}
