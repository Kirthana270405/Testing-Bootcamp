Feature: Automation Exercise

Scenario: Checking Login user with incorrect email and password

    Given User should Launch Chrome browser
    When User should Navigate to URL "http://automationexercise.com"
    Then User should Verify that Home Page is visible successfully
    When User Should Click on 'Signup / Login' button
    Then User Should Verify that 'Login to your account' is visible
    When User Should Enter incorrect email address and password
    And User Should Click 'login' button
    Then User Should Verify that 'Your email or password is incorrect!' is visible