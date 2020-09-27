package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LinkedInPage;
import pages.johnLoginPage;
import utils.DriverFactory;

public class johnloginSteps {
        WebDriver driver = DriverFactory.driver;
        johnLoginPage johnlewis = PageFactory.initElements( driver, johnLoginPage.class );
        public String e;
        public String p;

        @Given("^I am on Johnlewis Home page$")
        public void on_Linkedin_page() {
            johnlewis.launcJohnLewisHomePage();
        }

        @When("^I Enter (.*) andalso (.*)$")
        public void i_Enter_details(String email, String pwd) {

            johnlewis.enterDetails( email, pwd );
        }

        @Then("^Login Should be fully successful$")
        public void registration_Should_be_successful() {
            johnlewis.verifyRegistered();
            Assert.assertTrue( "Registration not successful", johnlewis.verifyRegistered() );

        }
    @Given("I am loggedin with (.*) and (.*)")
    public void i_am_loggedin_with_Email_and_Password(String email, String pwd) throws InterruptedException {

        johnlewis.launcJohnLewisHomePage();
        johnlewis.enterDetails( email , pwd );
        johnlewis.verifyRegistered();


    }

    @When("I logout from the application")
    public void i_logout_from_the_application() throws Throwable {
            johnlewis.signOutFromApplication();

    }

    @Then("I should be logged out succesfully")
    public void i_should_be_logged_out_succesfully() throws Throwable {
            Assert.assertTrue( "Signout not successfull" ,johnlewis.verifyLogoutSuccessfull() );

    }

    @When("I check my details in account tab")
    public void checkDetails() throws InterruptedException {
            johnlewis.checkMyDetails();

    }

    @Then("I should be able to see my details")
    public void detailsDisplayedSuccesfully(){
            Assert.assertTrue( "details not displayed", johnlewis.verifyDetailsDisplayed());

    }
   @When("I click on order tab in the sidebar")
    public void accountdetailsFromSidebar() throws Throwable{
       johnlewis.checkAccountOverview();
    }
   @Then( "I should be able to see my order details" )
    public void orderDetails(){
            Assert.assertTrue( "Order details not displayed", johnlewis.verifyOrders());

    }
    }

