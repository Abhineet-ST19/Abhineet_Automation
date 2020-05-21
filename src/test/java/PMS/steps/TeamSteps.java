package PMS.steps;

import PMS.pages.TeamPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TeamSteps {
    TeamPage teamPage;

    @Given("^I click on Team Module$")
    public void iClickOnTeamModule() {
        teamPage.clickOnTeamModule();
    }

    @Then("^I will verify that user landed on Team page$")
    public void iWillVerifyThatUserLandedOnTeamPage() {
        teamPage.verifyTeamPage();
    }

    @Then("^I will verify that Direct Reporting and BU Team options are available$")
    public void iWillVerifyThatDirectReportingAndBUTeamOptionsAreAvailable() {
teamPage.verifyTabsOnTeamsPage();
    }

    @Then("^I verify the name of Team Head from Direct Reporting section$")
    public void iVerifyTheNameOfTeamHeadFromDirectReportingSection() {
teamPage.verifyBUHeadNameOfDepartment();
    }

    @And("^verify the table columns from BU Team$")
    public void verifyTheTableColumnsFromBUTeam() {
        teamPage.clickOnBUTeamTab();
        teamPage.verifyBUTeamPage();
        teamPage.verifySearchOption();
    }
}
