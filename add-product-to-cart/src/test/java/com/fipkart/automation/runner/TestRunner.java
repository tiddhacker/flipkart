package com.fipkart.automation.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "." }, glue = { "com.flipkart.automation.stepDef" }, monochrome = true, tags = "")

public class TestRunner {
	
	

}
