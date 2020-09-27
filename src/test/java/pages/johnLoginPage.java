package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = ("//div[contains(@class,'desktop-header')]//a[contains(text(),'Hello sraavanthi.thuma')]"))
    WebElement welcomeUserName;

    @FindBy(xpath = ("//button[@data-test='allow-all']"))
    WebElement cookieIcon;


    @FindBy(xpath = ("//a[@href='/sign-out']"))
    WebElement signOut;

    @FindBy(xpath = ("//li[contains(@class,'menu-item-item')]//a[@href='/my-account']"))
    WebElement account;

    @FindBy(xpath = ("//div[@data-test ='links']//a[contains(text(),'View my details')]"))
    WebElement myDetailsLink;

    @FindBy(xpath = ("//span[@data-test ='add-contact_details-cta-label']"))
    WebElement personalDetails;

    @FindBy(id = "sidebar")
    WebElement sidebar;

    @FindBy(id = "dateFilter")
    WebElement ordersBox;


    public void launcJohnLewisHomePage() {
        driver.get( "https://www.johnlewis.com/" );
        driver.manage().window().maximize();
        WebdriverUtilities.waitForElementToBeVisible( cookieIcon );
        cookieIcon.click();
        WebdriverUtilities.waitForElementToBeVisible( signInDesktopLink );
        signInDesktopLink.click();

    }

    public void enterDetails(String Email, String Pwd) {
        WebdriverUtilities.waitForElementToBeVisible( email );
        email.click();
        email.sendKeys( Email );
        pwd.sendKeys( Pwd );
        signIn.click();
    }

    public boolean verifyRegistered() {
        WebdriverUtilities.waitForElementToBeVisible( welcomeUserName );
        return welcomeUserName.isDisplayed();
    }


    public void signOutFromApplication() {
        Actions action = new Actions( driver );
        action.moveToElement( welcomeUserName );
        action.build().perform();
        signOut.click();

    }

    public boolean verifyLogoutSuccessfull() {
        WebdriverUtilities.waitForElementToBeVisible( signInDesktopLink );
        return signInDesktopLink.isDisplayed();
    }

    public void checkMyDetails() {
        Actions action = new Actions( driver );
        action.moveToElement( welcomeUserName );
        action.build().perform();
        WebdriverUtilities.waitForElementToBeVisible( account );
        account.click();
        WebdriverUtilities.waitForElementToBeVisible( myDetailsLink );
        myDetailsLink.click();

    }

    public boolean verifyDetailsDisplayed() {
        WebdriverUtilities.waitForElementToBeVisible( personalDetails );
        return personalDetails.isDisplayed();
    }

    public void checkAccountOverview() {
        Actions action = new Actions( driver );
        action.moveToElement( welcomeUserName );
        action.build().perform();
        WebdriverUtilities.waitForElementToBeVisible( account );
        account.click();
        WebdriverUtilities.waitForElementToBeVisible(sidebar);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowDom = (WebElement) js.executeScript( "return arguments[0].shadowRoot", sidebar);
        WebElement orderLink = shadowDom.findElement(By.id("orders"));
        orderLink.click();

    }
    public boolean verifyOrders(){
        WebdriverUtilities.waitForElementToBeVisible( ordersBox );
        return ordersBox.isDisplayed();

    }
    }



