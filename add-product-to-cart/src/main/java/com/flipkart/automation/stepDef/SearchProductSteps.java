package com.flipkart.automation.stepDef;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchProductSteps extends BasePage {

	@Given("^user navigates to flipkart homepage$")
	public void user_navigates_to_flipkart_homepage() throws Throwable {
		getDriver().get(prop.getProperty("url"));
	}
	
	@And("^login using username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void login_using_username_and_password(String user, String pass) {
		sendKeysToWebElement(prop.getProperty("xpath.username"), user);
		sendKeysToWebElement(prop.getProperty("xpath.password"), pass);
		waitandclick(prop.getProperty("xpath.loginbtn"));
	}

	@Then("^user search for a product \"([^\"]*)\"$")
	public void user_search_for_a_product(String productName) throws InterruptedException{
	   sendKeysToWebElement(prop.getProperty("xpath.searchProdInput"), productName);
	   sendEnterkeyStroke(prop.getProperty("xpath.searchProdInput"));
	   waitandclick(prop.getProperty("xpath.productNameClick"));
	}

	@And("^then adds the product to cart$")
	public void then_adds_the_product_to_cart() throws InterruptedException{
		Thread.sleep(5);
		clickUsingActions(prop.getProperty("xpath.buyNow"));
	}

	@Then("^verifies the product \"([^\"]*)\" is added to cart$")
	public void verifies_the_product_is_added_to_cart(String productName){
	    
	}
	
	
}
