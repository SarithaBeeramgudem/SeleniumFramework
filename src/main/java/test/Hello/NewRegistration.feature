Feature: Registration	
  I want to create a new registration

Scenario Outline: New Registration/user account creation
    Given User opens the web application
    When User click on Register button
    And fill the new registration form with username "<username>", "<firstname>"
    And click on the submit button	
    Then New account is created
    And Verify if the User is created
    And Close the web application
Examples:
	| username	|firstname |
	|	mohan		|Mohan Kumar|
	|	sohan	|Sohan Rao |
    
    