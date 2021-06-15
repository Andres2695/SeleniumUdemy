
Feature: Test diferent action on the static table
Rule: The user can return values from the table and validate them.
Background: Navigate to Table web app
    Given I navigate to static table 
Scenario: As a text Engineer, I want to retrive the value of an static table.
    Then I can return the value i wanted
 Scenario: As a tester Engineer , i want to validate the static table is displayed
    Then I can validate the table is displayeds