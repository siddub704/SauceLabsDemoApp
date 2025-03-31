@tag
Feature: Title of your feature

@validLogin
  Scenario: check login is successful with valid credentials
    Given user is on login page
    When user enters username and password
    And click on login button
    Then user is logedin successfully
    Then page title should be "Swag Labs"

  @invalidLogin
  Scenario Outline: check invalid login functionality
    Given user is on login page
    When user enters "<username>" and "<password>"
    And click on login button
    Then I verify the "<status>" based on the credentials

    Examples: 
      | username        | password     |status|
      | locked_out_user4 | secret_sauce |Epic sadface: Username and password do not match any user in this service|
      | problem_user8   | secret_sauce |Epic sadface: Username and password do not match any user in this service|
      