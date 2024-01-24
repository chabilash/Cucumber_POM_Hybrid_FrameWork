Feature: Accounts Page Validation Feature

  Background: 
    Given user is on home page
    Then user clicks My Account
    And user clicks Login
    When user enters valid credentials and clicks Login button
      | username                | password      |
      | abilash.ch.qa@gmail.com | Abilash@12345 |

  Scenario: Accounts Page Title
    Given user in on Accounts page
    When user gets the title of the account page
    Then account page title should be "My Account"

  Scenario: Accounts Section Count
    Given user in on Accounts page
    Then user gets accounts section
      | My Account           |
      | My Orders            |
      | My Affiliate Account |
      | Newsletter           |
    And accounts section count should be 4
