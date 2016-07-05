Feature: Home Page Testing

	Scenario: Test mouse hover on menu
		Given I am on the HomePage
		And the menu items to animals menu are not displayed
		When I put the mouse pointer over the animals menu
		Then I should be able to see the menu items from animals menu