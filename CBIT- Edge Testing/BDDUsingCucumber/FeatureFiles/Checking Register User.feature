Feature: Automation Exercise

Scenario: Checking Register user


    Given User should Launch Chrome browser
    When User should Navigate to URL "http://automationexercise.com"
    Then User should Verify that Home Page is visible successfully
    When User Should Click on 'Signup / Login' button
    Then User Should Verify that 'New User Signup!' is visible
    Then User Should Enter name and email address
    Then User Should Click 'Signup' button
    Then User Should Verify that 'ENTER ACCOUNT INFORMATION' is visible
    Then User Should Fill details: Title, Name, Email, Password, Date of birth
    Then User Should Select checkbox 'Sign up for our newsletter!'
    Then User Should Select checkbox 'Receive special offers from our partners!'
    Then User Should Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    Then User Should Click 'Create Account' button
    Then User Should Verify that 'ACCOUNT CREATED!' is visible
    Then User Should Click 'Continue' button
    Then User Should Verify that 'Logged in as username' is visible
    Then User Should Click 'Delete Account' button
    And User Should Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button