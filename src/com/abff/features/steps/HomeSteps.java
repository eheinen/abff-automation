package com.abff.features.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.abff.support.page_objects.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeSteps extends HomePage {

	@Given("^I am on the HomePage$")
	public void i_am_on_the_HomePage() {
	    assertThat(title, equalTo(openPart("index.html").getTitle()));
	}
	
	@Given("^the menu items to (\\w+) menu are not displayed$")
	public void the_menu_items_to_menu_are_not_displayed(String menu){
		checkMenuItemIsDisplayed(menu, false);
	}
	
	@When("^I put the mouse pointer over the (\\w+) menu$")
	public void i_put_the_mouse_pointer_over_the_menu(String menu) {
		hoverMenu(menu);		
	}

	@Then("^I should be able to see the menu items from (\\w+) menu$")
	public void i_should_be_able_to_see_the_menu_items_from(String menu) {
	    checkMenuItemIsDisplayed(menu, true);
	}
	
}
