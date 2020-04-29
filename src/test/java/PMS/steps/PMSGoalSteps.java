package PMS.steps;

import PMS.pages.GoalsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PMSGoalSteps {
   GoalsPage goalsPage;
    @When("^I click on add goal button$")
    public void iClickOnAddGoalButton() {
goalsPage.addGoalButtonClick();

    }

    @When("^I click on Submit for review button$")
    public void iClickOnSubmitForReviewButton() {
        goalsPage.submitForReviewButtonClick();
    }

    @Then("^I will verify that goal title field showing validation message$")
    public void iWillVerifyThatGoalTitleFieldShowingValidationMessage() {
goalsPage.checkValidationForGoalTitleField();
    }

    @And("^I will verify Goal field showing validation message$")
    public void iWillVerifyGoalFieldShowingValidationMessage() {
        goalsPage.checkValidationForGoalField();
    }

    @And("^SubCategory field showing validation message$")
    public void subcategoryFieldShowingValidationMessage() {
        goalsPage.checkValidationForSubCategoryField();
    }

    @And("^Weightage field showing validation message$")
    public void weightageFieldShowingValidationMessage() {
        goalsPage.checkValidationForWeightageField();
    }

    @When("^I enter Goal Title$")
    public void iEnterGoalTitle() {
        goalsPage.enterGoalTitle();
        goalsPage.addSubGoal();

    }


    @Then("^I Enter Goal fields with Weightage value \"([^\"]*)\"$")
    public void iEnterGoalfieldswithWeightagevalue(String Weightage) throws Throwable {

        goalsPage.enterGoalFieldsDetails(Weightage);
    }

    @Then("^I see a Validation message for Weightage$")
    public void iSeeAValidationMessageForWeightage() {
        goalsPage.checkValidationForWeightageMustBeEqual80();
    }

    @Then("^I click on save Draft button$")
    public void iClickOnSaveDraftButton() {
        goalsPage.clickOnSaveDraftButton();
    }

    @Then("^I click on Draft button$")
    public void iClickOnDraftButton() {
        goalsPage.clickOnDraftButton();
        goalsPage.checkForSuccessMessage();

    }

    @Then("^I click on Goal Title HyperLink$")
    public void iClickOnGoalTitleHyperLink() {
        goalsPage.clickOnGoalTitleHyperLink();
    }

    @Then("^I click on Edit Goal Button$")
    public void iClickOnEditGoalButton() {
        goalsPage.clickOnEditGoalButton();
    }

    @When("^I click on Submit button$")
    public void iClickOnSubmitButton() {
        goalsPage.clickOnSubmitButton();

    }

    @Then("^Goal Should be Submitted Successfully$")
    public void goalShouldBeSubmittedSuccessfully() {
goalsPage.checkForStatusofGoal();
    }
}
