package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverFactory;
import utils.webdriverutils.WebdriverUtilities;

public class LinkedInPage {
    WebDriver driver = DriverFactory.driver;
    DriverFactory dFactory = new DriverFactory();
    DriverFactory visible = new DriverFactory();
    @FindBy(id = "session_key")
    WebElement email;

    @FindBy(id = "session_password")
    WebElement pwd;

    @FindBy(className = "sign-in-form__submit-button")
    WebElement signIn;

    @FindBy(id = "feed-tab-icon")
    WebElement homeIcon;


    public void launchLinkedinPage() {
        driver.get( "https://www.linkedin.com/" );
    }

    public void enterDetails(String Email, String Pwd) {
        WebdriverUtilities.waitForElementToBeVisible(email);
        email.click();
        email.sendKeys(Email);
        pwd.sendKeys( Pwd );
        signIn.click();
    }

    public boolean verifyRegistered() {

        return homeIcon.isDisplayed();
    }

}

