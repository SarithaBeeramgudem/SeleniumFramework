
Feature: Add numbers
  I want user to provide any  numbers and add them in the result

  @tag1
  Scenario: User providing number and adding them in result
    Given Ask the user to provide how many number they wants us to add
    When I take those numbers input from user
		Then I should add the numbers and display the result