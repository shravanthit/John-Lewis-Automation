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


        @Given("^I am on Johnlewis Home page$")
        public void on_Linkedin_page() {
            johnlewis.launchLinkedinPage();
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
    }

