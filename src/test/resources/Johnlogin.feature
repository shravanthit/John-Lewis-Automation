Feature: Johnlewis Home Page

  @LewisHomepage
  Scenario Outline: Enter details for signin
    Given  I am on Johnlewis Home page
    When   I Enter <Email> andalso  <Password>
    Then   Login Should be fully successful
    Examples:
      | Email               | Password |
      | sraavanthi.thuma@gmail.com | Johnlewis@123  |

@LewisLogout
Scenario: Logout from the johnlewis application

  Given I am on homePage
  When  I






