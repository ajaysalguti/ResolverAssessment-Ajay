Feature: Resolver Assessment - Home page

Background: User navigate to resolver html page
  Given Access the Resolver Assessment home page

  Scenario: Access Resolver Assessment - Home page and validate Test1 fields
    Then User verify that the Section title is "Test 1"
    And User Verify that Email address and password fields are present
    And Verify that login button is present
    Then Enter the email-address as ajaydatta@gmail.com
    Then Enter the password as MyPa$$word
    And Click on signin button

  Scenario: Access Resolver Assessment - Home page and validate Test2 section list items
    Then User verify that the Section title is "Test 2"
    And User Verify that there are 3 values in the list group
    And Verify that the 2 list item value is set to "List Item 2"
    And Verify that the 2 list item's badge value is 6

  Scenario: Access Resolver Assessment - Home page and validate Test3 Options dropdown
    Then User verify that the Section title is "Test 3"
    And User verify that "Option 1" is the default selected value
    And User select "Option 3" from dropdown list

  Scenario: Access Resolver Assessment - Home page and validate Test3 Options dropdown
    Then User verify that the Section title is "Test 4"
    And User verify that 1st button is enabled
    And User verify that 2nd button is disabled

  Scenario: Access Resolver Assessment - Home page and validate Test3 Options dropdown
    Then User verify that the Section title is "Test 5"
    And User wait for the button to be displayed and click on it
    Then User verify that the success message is displayed as "You clicked a button!"
    And User verify that 2nd button is disabled

  Scenario: Access Resolver Assessment - Home page and validate Test3 Options dropdown
    Then User verify that the Section title is "Test 6"
    And User retrieve the value located at coordinates 2,2
    Then User assert the value of cell is "Ventosanzap" at 2,2


