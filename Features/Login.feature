Feature: Login

  Scenario: Successful login with valid credentials
    Given User launch chrome browser
    When User opens URL "http://automationpractice.com/index.php?controller=authentication&back=my-account"
    And User enters email as "pradap@mailinator.com" and password as "pradap"
    And Click on login
    Then Page title should be "My account - My Store"
    When User click on logout button
    Then Page title should be "Login - My Store"
    And Close the browser