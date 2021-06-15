@Grid
Feature: I can find a city insede a test
Scenario Outline: As a tester Engineer , i want to validate that a text is present insede the lsit
    Given I navigate to the list page 
    When I search <state> in the list
    Then I cand find <city> in the list 
    Examples:
        | state      | city                 |
        | Washington | Seattle, Washington  |
        | Chicago    | Chicago, Illinois   |
        | California | Fresno, Californ   |