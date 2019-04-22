
Feature: Student marks sheet
  I want to print the list of students marks where percentage is greater than 90% pass or print failed the exam
  
  @tag1
  Scenario: To print student mark sheet pass / fail
    Given a student subject mark list "C:\\Users\\Reddy\\Documents\\Book1.xlsx"
    When printed the students mark list where the condition is if percentage is >90% then pass and <90% is fail
    
    