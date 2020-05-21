package PMS.pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamPage extends PageObject {
    HomePage homePage;
    ProfilePage profilePage;
    @FindBy(xpath = "//h3[@class='kt-subheader__title']")
    WebElement teamTitle;
    @FindBy(xpath = "//a[@class='nav-link active']")
    WebElement directReportingTab;
    @FindBy(xpath = "//a[@class='nav-link']")
    WebElement buTeamTab;
    @FindBy(xpath = "(//span[@class='tf-nc customCard'])[1]")
    WebElement buHeadName;
    @FindBy(xpath = "//th[text()='Sr. No']")
    WebElement srNo;
    @FindBy(xpath = "//th[text()='Name']")
    WebElement empName;
    @FindBy(xpath = "//th[text()='Employee Id']")
    WebElement empID;
    @FindBy(xpath = "//th[text()='Email']")
    WebElement empEmail;
    @FindBy(xpath = "//label[text()='Search:']")
    WebElement searchLabel;
    @FindBy(xpath = "//input[@type='search']")
    WebElement searchBox;
    @FindBy(xpath = "//td/a")
    WebElement searchedEmpName;
//click on team module//
    public void clickOnTeamModule() {
        waitFor(homePage.teamsLink).waitUntilVisible();
        homePage.teamsLink.click();
    }
//This function will verify the page title as My Teams//
    public void verifyTeamPage() {
        Assert.assertEquals("  My Teams", teamTitle.getText());
    }
//This function will verify the tabs on this page//
    public void verifyTabsOnTeamsPage() {
        Assert.assertEquals("Direct Reporting", directReportingTab.getText());
        Assert.assertEquals("BU Team(Quality Analyst)", buTeamTab.getText());
    }
//This function will verify the BU head name//
    public void verifyBUHeadNameOfDepartment() {
        Assert.assertEquals("Manoj Kumar Mehra", buHeadName.getText());

    }
//This function will redirect on BU team//
    public void clickOnBUTeamTab() {
        buTeamTab.click();
    }
//This function will verify the columns of table//
    public void verifyBUTeamPage() {
        Assert.assertEquals("Sr. No", srNo.getText());
        Assert.assertEquals("Name", empName.getText());
        Assert.assertEquals("Employee Id", empID.getText());
        Assert.assertEquals("Email", empEmail.getText());
    }
//This function will verify the search functionality//
    public void verifySearchOption() {
        Assert.assertEquals("Search:", searchLabel.getText());
        searchBox.sendKeys("Abhineet Kumar", searchedEmpName.getText());


    }

}
