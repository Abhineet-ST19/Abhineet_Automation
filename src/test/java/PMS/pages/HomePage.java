package PMS.pages;
import PMS.utilities.ConfigLoader;
import com.typesafe.config.Config;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class HomePage extends PageObject {

    @FindBy(xpath = "//*[contains(text(),'Login with Google')]")
    WebElement loginButton;
    @FindBy(xpath = "//div[text()='Sign in with Google']")
    WebElement headertext;
    @FindBy(xpath = "//input[@autocomplete='username']")
    WebElement username;
    @FindBy(xpath = "//span[text()='Next']")
    WebElement nextButton;
    @FindBy(xpath = "//input[@autocomplete='current-password']")
    WebElement password;
    @FindBy(xpath = "//span[text()='Goals']")
    WebElement pageTitle;
    @FindBy(xpath = "//li[@class='dropdown notifications-menu']//a[1]")
    WebElement logout;
    @FindBy(xpath = "//div[@class='o6cuMc']")
    WebElement validationMessageUserName;

    @FindBy(xpath = "(//div[@jsname='B34EJ'])[1]")
    WebElement getValidationMessagePassword;

    @FindBy(xpath = "//h3[@class='kt-subheader__title']")
    WebElement goalText;
    @FindBy(xpath = "//a[@class='nav-link active']")
    WebElement submittedGoalsButton;
    @FindBy(xpath = "//a[@class='nav-link ']")
    WebElement savedDraftsButton;
    @FindBy(xpath = "//div[@id='kt_contacts_view_tab_1']//th[contains(text(),'Goal Title')]")
    WebElement goalTitle;
    @FindBy(xpath = "//div[@id='kt_contacts_view_tab_1']//th[contains(text(),'Appraisal Cycle')]")
    WebElement appraisalCycle;
    @FindBy(xpath = "//div[@id='kt_contacts_view_tab_1']//th[contains(text(),'Status')]")
    WebElement status;
    @FindBy(xpath = "//a[contains(@class,'btn btn-brand')]")
    WebElement addGoalButton;
    @FindBy(xpath = "//span[text()='Inbox']")
    WebElement inboxLink;
    @FindBy(xpath = "//span[text()='Goals']")
    WebElement goalLink;
    @FindBy(xpath = "//span[text()='One-To-One']")
    WebElement oneToOneLink;
    @FindBy(xpath = "//span[text()='Teams']")
    WebElement teamsLink;
    @FindBy(xpath = "//span[text()='Year End Review']")
    WebElement yearEndReviewLink;
    @FindBy(xpath = "//span[text()='My Profile']")
    WebElement myProfileLink;
    @FindBy(xpath = "//span[text()='FAQ']")
    WebElement faqLink;

//This function will click on google login option and verify the header of page//
    public void clickLogInWithGoogleOption() {
        loginButton.click();
        Assert.assertEquals("Sign in with Google", headertext.getText());
        waitFor(username).waitUntilVisible();
    }
//This function will enter username in username text box and click on next button//
    public void pmsLogIn(String email) {

        username.sendKeys(email);
        nextButton.click();
    }
    //This function will enter password in password text box and click on next button//
    public void password(String pwd) {

        waitFor(password).waitUntilClickable();
        password.sendKeys(pwd);
        waitFor(nextButton).waitUntilVisible();

        //waitFor(nextButton).withTimeoutOf(10, TimeUnit.SECONDS).waitUntilClickable();
        nextButton.click();

    }
//This function will assert the validations according to different scenarios//
    public void getMessage(String message) {
        try {
            if (validationMessageUserName.isDisplayed()) {
                Assert.assertEquals(message, validationMessageUserName.getText());
            }
        } catch (Exception e) {
//waitFor(getValidationMessagePassword).withTimeoutOf(10,TimeUnit.SECONDS).waitUntilVisible();

            Assert.assertEquals(message, getValidationMessagePassword.getText());
        }

    }
//This method will verify all the options on landing page//
    public void verifyHomePage() {
        waitFor(goalText).waitUntilVisible();
        Assert.assertEquals("  Goals", goalText.getText());
        Assert.assertEquals("Submitted Goals", submittedGoalsButton.getText());
        Assert.assertEquals("Saved Drafts", savedDraftsButton.getText());
        Assert.assertEquals("Goal Title", goalTitle.getText());
        Assert.assertEquals("Appraisal Cycle", appraisalCycle.getText());
        Assert.assertEquals("Status", status.getText());
        Assert.assertEquals("Add Goals", addGoalButton.getText());
    }
//This method will verify all the option in left panel//
    public void verifyLeftPanel() {
        Assert.assertEquals("Inbox", inboxLink.getText());
        Assert.assertEquals("Goals", goalLink.getText());
        Assert.assertEquals("One-To-One", oneToOneLink.getText());
        Assert.assertEquals("Teams", teamsLink.getText());
   //     Assert.assertEquals("Year End Review", yearEndReviewLink.getText());
        Assert.assertEquals("My Profile", myProfileLink.getText());
        Assert.assertEquals("FAQ", faqLink.getText());
    }


}

