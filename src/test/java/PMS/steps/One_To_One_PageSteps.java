package PMS.steps;

import PMS.pages.OneToOnePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class One_To_One_PageSteps {
    OneToOnePage oneToOnePage;
    @When("^I click on one to one module$")
    public void iClickOnOneToOneModule() {
oneToOnePage.clickOnOneToOneModule();
    }

    @Then("^I verify that the user landing on one to one module$")
    public void iVerifyThatTheUserLandingOnOneToOneModule() {
oneToOnePage.verifyOneToOnePage();
    }

    @Then("^I click on add one to one button$")
    public void iClickOnAddOneToOneButton() {
oneToOnePage.clickOnAddNotesButton();
    }

    @Then("^I verify that the calender functionality is disable$")
    public void iVerifyThatTheCalenderFunctionalityIsDisable() {
oneToOnePage.verifyCalenderNotClickable();
    }

    @And("^I verify the validation on mandatory fields$")
    public void iVerifyTheValidationOnMandatoryFields() {
        oneToOnePage.verifyMandatoryfieldsValidations();
    }





    @Then("^I Enter Notes Title \"([^\"]*)\"$")
    public void iEnterNotesTitle(String notetitlename)  {
oneToOnePage.enterNoteTitle(notetitlename);
    }

    @And("^I Enter Notes In Notes Section \"([^\"]*)\"$")
    public void iEnterNotesInNotesSection(String onetoonedecs) {
oneToOnePage.enterOneToOneDesc(onetoonedecs);
    }
    @When("^I click on Submit for review button On Notes Button$")
    public void iClickOnSubmitForReviewButtonOnNotesButton() {
        oneToOnePage.submitForReviewButton();
    }

    @Then("^I verify the onetoone submitted successfully with title \"([^\"]*)\" and status \"([^\"]*)\"$")
    public void iVerifyTheOnetooneSubmittedSuccessfullyWithTitleAndStatus(String title, String status)  {
        oneToOnePage.oneToOneVerification(title,status);
    }
}
