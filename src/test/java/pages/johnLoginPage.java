package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverFactory;
import utils.webdriverutils.WebdriverUtilities;

public class johnLoginPage {
        WebDriver driver = DriverFactory.driver;
        DriverFactory dFactory = new DriverFactory();
        DriverFactory visible = new DriverFactory();

        @FindBy(xpath = ("//div[contains(@class,'desktop-header')]//a[contains(text(),'Sign in')]"))
        WebElement signInDesktopLink;

        @FindBy(id = "email")
        WebElement email;

        @FindBy(id = "password")
        WebElement pwd;

        @FindBy(id = "loginForm")
        WebElement signIn;

        @FindBy(xpath =("//div[contains(@class,'desktop-header')]//a[contains(text(),'Hello sraavanthi.thuma')]"))
        WebElement welcomeUserName;

        @FindBy(xpath = ("//button[@data-test='allow-all']"))
        WebElement cookieIcon;


        public void launchLinkedinPage() {
            driver.get( "https://www.johnlewis.com/" );
            driver.manage().window().maximize();
            WebdriverUtilities.waitForElementToBeVisible( cookieIcon );
            cookieIcon.click();
            WebdriverUtilities.waitForElementToBeVisible( signInDesktopLink );
            signInDesktopLink.click();

        }

        public void enterDetails(String Email, String Pwd) {
            WebdriverUtilities.waitForElementToBeVisible(email);
            email.click();
            email.sendKeys(Email);
            pwd.sendKeys( Pwd );
            signIn.click();
        }

        public boolean verifyRegistered() {
            WebdriverUtilities.waitForElementToBeVisible(welcomeUserName);
            return welcomeUserName.isDisplayed();
        }

    }



