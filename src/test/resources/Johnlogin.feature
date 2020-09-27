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
Scenario Outline: Logout from the johnlewis application

  Given I am loggedin with <Email> and <Password>
  When  I logout from the application
  Then  I should be logged out succesfully
  Examples:
    | Email               | Password |
    | sraavanthi.thuma@gmail.com | Johnlewis@123  |

  @LewischeckMydetails

  Scenario Outline: Check mydetails in account tab

    Given I am loggedin with <Email> and <Password>
    When  I check my details in account tab
    Then  I should be able to see my details
    Examples:
      | Email               | Password |
      | sraavanthi.thuma@gmail.com | Johnlewis@123  |

  @shadowDomImplementation

  Scenario Outline: check accountoverview from sidebar

    Given I am loggedin with <Email> and <Password>
    When  I click on order tab in the sidebar
    Then  I should be able to see my order details
    Examples:
      | Email               | Password |
      | sraavanthi.thuma@gmail.com | Johnlewis@123  |





