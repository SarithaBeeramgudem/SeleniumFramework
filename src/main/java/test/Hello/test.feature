
Feature: Verify Google search page

  Scenario: Verify Search Result
    Given User have google url
    And he search  somthing
    When he click on search button
    Then User should see search count
    
    