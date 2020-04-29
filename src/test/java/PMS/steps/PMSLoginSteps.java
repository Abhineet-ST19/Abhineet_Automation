package PMS.steps;

import PMS.pages.HomePage;
import PMS.utilities.ConfigLoader;
import com.typesafe.config.Config;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class PMSLoginSteps {
    private static Config conf= ConfigLoader.load();
    HomePage homePage;
    @Given("^I launch the PMS application$")
    public void iLaunchThePMSApplication() {
        homePage.openUrl(conf.getString("webdriver.base.url"));
        getDriver().manage().window().maximize();
    }

    @Then("^I click on LogIn with Google option$")
    public void iClickOnLogInWithGoogleOption() {

        homePage.clickLogInWithGoogleOption();


    }

    @And("^I Provide UserName and Click on Next button$")
    public void iProvideUserNameAndClickOnNextButton() {
        homePage.enterUserNameAndClickOnNextButton();

    }

    @And("^I provide Password and Click on Next Button$")
    public void iProvidePasswordAndClickOnNextButton() {
        homePage.enterPasswordAndClickOnNextButton();

    }

    @Then("^User should be Login Successfully on PMS$")
    public void userShouldBeLoginSuccessfullyOnPMS() {
        homePage.verifyHomePage();

    }


    @When("^I provide \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iProvideAnd(String email, String pwd)  {
        System.out.println("step arrived");
        homePage.pmsLogIn(email);
        homePage.password(pwd);
    }

    @Then("^I should get \"([^\"]*)\"$")
    public void iShouldGet(String message)  {
        homePage.getMessage(message);
    }

    @When("^I provide \"([^\"]*)\"$")
    public void iProvide(String email) {
        homePage.pmsLogIn(email);
    }

    @Then("^I should be on goal page and verity all the components on that page$")
    public void iShouldBeOnGoalPageAndVerityAllTheComponentsOnThatPage() {
        homePage.verifyHomePage();
    }

    @And("^I verify the options in left panel$")
    public void iVerifyTheOptionsInLeftPanel() {
        homePage.verifyLeftPanel();
    }
}
