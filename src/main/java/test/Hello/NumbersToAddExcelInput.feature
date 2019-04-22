Feature: Add numbers
  I want user to provide any  numbers to add and take the input from Excel, add them and display in the result

  
  Scenario: User providing number to add and take numbers from Excel and add them in result
    Given Ask the user to provide how many numbers they wants to add
    When I take those numbers input from Excel sheet "C:\Users\Reddy\Documents\\Book2.xlsx"
		Then I add the numbers and display the result correctly


