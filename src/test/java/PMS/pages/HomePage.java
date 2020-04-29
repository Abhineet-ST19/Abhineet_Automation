package PMS.pages;
import PMS.utilities.ConfigLoader;
import com.typesafe.config.Config;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class HomePage extends PageObject {
    private static Config conf = ConfigLoader.load();
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
    @FindBy(xpath = "//span[text()='Help Desk']")
    WebElement helpDeskLink;


    public void clickLogInWithGoogleOption() {
        loginButton.click();
        String HeaderVerifyForLogin = headertext.getText();
        Assert.assertEquals("Sign in with Google", HeaderVerifyForLogin);
        waitFor(username).waitUntilVisible();
    }

    public void enterUserNameAndClickOnNextButton() {
        username.sendKeys("butestuser@successivesoftwares.com");
        nextButton.click();
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(password);
    }

    public void pmsLogIn(String email) {

        username.sendKeys(email);
        nextButton.click();
    }

    public void password(String pwd) {

        waitFor(password).waitUntilClickable();
        password.sendKeys(pwd);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(nextButton);

        waitFor(nextButton).withTimeoutOf(10, TimeUnit.SECONDS).waitUntilClickable();
        nextButton.click();

    }

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


    public void enterPasswordAndClickOnNextButton() {
        password.sendKeys("8802420232");
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(nextButton);
        nextButton.click();
        System.out.println(pageTitle);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(pageTitle);
    }

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

    public void verifyLeftPanel() {
        Assert.assertEquals("Inbox", inboxLink.getText());
        Assert.assertEquals("Goals", goalLink.getText());
        Assert.assertEquals("One-To-One", oneToOneLink.getText());
        Assert.assertEquals("Teams", teamsLink.getText());
        Assert.assertEquals("Year End Review", yearEndReviewLink.getText());
        Assert.assertEquals("My Profile", myProfileLink.getText());
        Assert.assertEquals("Help Desk", helpDeskLink.getText());
    }


}

