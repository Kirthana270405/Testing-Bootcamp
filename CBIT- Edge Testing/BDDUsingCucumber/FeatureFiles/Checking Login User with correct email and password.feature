Feature: Automation Exercise

Scenario: Checking Login user with correct email and password

    Given User should Launch Chrome browser
    When User should Navigate to URL "http://automationexercise.com"
    Then User should Verify that Home Page is visible successfully
    Then User Should Click on 'Signup / Login' button
    Then User Should Verify that 'Login to your account' is visible
    Then User Should Enter correct email address and password
    Then User Should Click 'login' button
    Then User Should Verify that 'Logged in as username' is visible
    Then User Should Click 'Delete Account' button
    Then User Should Verify that 'ACCOUNT DELETED!' is visible