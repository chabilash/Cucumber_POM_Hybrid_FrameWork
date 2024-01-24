Feature: Login Page feature

  Scenario: Home Page Title
    Given user is on home page
    When user gets the title of the home page
    Then home page title should be "Your Store"

  Scenario: Forgot Password Loink
    Given user is on home page
    Then user clicks My Account
    And user clicks Login
    Then Forgotten Password link should be displayed

  Scenario: Login with correct credentials
    Given user is on home page
    Then user clicks My Account
    And user clicks Login
    When user enters username "abilash.ch.qa@gmail.com"
    And user enters password "Abilash@12345"
    And user clicks on Login button
    Then user gets the title of the account page
    And account page title should be "My Account"
