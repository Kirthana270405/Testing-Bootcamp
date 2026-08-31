Feature: Automation Exercise

Scenario: Checking Logout user

    Given User should Launch Chrome browser
    When User should Navigate to URL "http://automationexercise.com"
    Then User should Verify that Home Page is visible successfully
    When User Should Click on 'Signup / Login' button
    Then User Should Verify that 'Login to your account' is visible
    When User Should Enter correct email address and password
    And User Should Click 'login' button
    Then User Should Verify that 'Logged in as username' is visible
    When User Should Click 'Logout' button
    Then User Should Verify that user is navigated to login page