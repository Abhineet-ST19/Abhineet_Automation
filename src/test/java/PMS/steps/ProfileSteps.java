package PMS.steps;

import PMS.pages.ProfilePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProfileSteps {
    ProfilePage profilepage;
    @When("^I click on profile page$")
    public void iClickOnProfilePage() {
        profilepage.clickOnMyProfilePage();
    }

    @Then("^I verify that the user is on profile page$")
    public void iVerifyThatTheUserIsOnProfilePage() {
        profilepage.verifyPageTitle();

    }

    @And("^I verify All the details of that employee from top section$")
    public void iVerifyAllTheDetailsOfThatEmployeeFromTopSection() {
        profilepage.verifyEmployeeDetailsOnTop();
    }

    @And("^I verify all the details of that employee from middle section$")
    public void iVerifyAllTheDetailsOfThatEmployeeFromMiddleSection() {
        profilepage.verifyEmployeeDetailsOnMiddle();
    }

    @And("^I verify all the details of that employee from bottom section$")
    public void iVerifyAllTheDetailsOfThatEmployeeFromBottomSection() {
        profilepage.verifyEmployeeDetailsOnBottom();
    }
}
