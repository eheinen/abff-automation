Feature: Login
  As an admin of website
  I need to authenticate in the website
  So that, I can see the Index page

  @login @factory
  Scenario: Authenticate with PageFactory
    Given I am on the LoginPage
    When I type "admin" in username field
    And I type "admin" in password field
    And I click on submit button
    Then I should be able to see a message
    And I should be able to be redirected to IndexPage

    @login @object
    Scenario: Authenticate with PageObject
    Given I am on the LoginPage
    When I authenticate on LoginPage
    Then I should be able to be redirected to IndexPage