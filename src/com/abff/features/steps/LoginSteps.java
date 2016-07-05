package com.abff.features.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.abff.support.page_objects.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends LoginPage {
	
	@Given("^I am on the LoginPage$")
	public void i_am_on_the_LoginPage() {
	    assertThat(title, equalTo(openPart("login.html").getTitle()));
	}

	@When("^I type \"([^\"]*)\" in username field$")
	public void i_type_in_username_field(String username) {
	    txtUsername.sendKeys(username);
	}

	@When("^I type \"([^\"]*)\" in password field$")
	public void i_type_in_password_field(String password) {
		txtPassword.sendKeys(password);
	}
	
	@When("^I click on submit button$")
	public void i_click_on_submit_button() {
	    btnEntrar.click();
	}
	
	@When("^I authenticate on LoginPage$")
	public void i_authenticate_on_LoginPage() {
	    authenticate("admin", "admin");
	}
	
	@Then("^I should be able to see a message$")
	public void i_should_be_able_to_see_a_message() {
		assertThat("Autenticação realizada com sucesso!", equalTo(waitForElementDisplayed(lblMessage).getText()));
	}

	@Then("^I should be able to be redirected to IndexPage$")
	public void i_should_be_able_to_be_redirected_to_IndexPage() {
		assertThat("ABFF", equalTo(waitForTitle("ABFF")));
	}
}
