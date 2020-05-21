package PMS.pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OneToOnePage extends PageObject {
    HomePage homePage;
    @FindBy(xpath = "//a[@class='btn btn-sm btn-brand btn-elevate btn-icon-sm']")
    WebElement addNotesButton;

    @FindBy(xpath = "//div[@class='input-group']//input[@class='form-control']")
    WebElement calenderButton;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm form-submit']")
    WebElement submitForReviewButton;

    @FindBy(xpath = "//p[text()='Title is required field']")
    WebElement titleRequiredValidation;
    @FindBy(xpath = "//p[text()='Notes is required field']")
    WebElement notesFieldRequiredValidation;
    @FindBy(xpath = "//input[@name='title']")
    WebElement noteTitle;
    @FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
    WebElement iFrameOneToOneSection;
    @FindBy(xpath = "//body[contains(@class,'cke_editable')]")
    WebElement oneToOneSection;
    @FindBy(xpath = "//td[contains(text(),'TestNote')]")
    WebElement oneToOneTitle;
    @FindBy(xpath = "//span[@class='badge badge-warning']")
    WebElement oneToOneStatus;
    @FindBy(xpath = "//strong[text()='Action performed successfully!']")
    WebElement actionSuccessMessage;


//This function will click on one to one option//

    public void clickOnOneToOneModule() {
        homePage.oneToOneLink.click();

    }
//This function will verify the page title as Add Notes//
    public void verifyOneToOnePage() {
        Assert.assertEquals("Add Notes", addNotesButton.getText());

    }
//This function will click on add button of one to one notes//
    public void clickOnAddNotesButton() {
        addNotesButton.click();
    }
//This function will check that the calender option is not clickable//
    public void verifyCalenderNotClickable() {
        Assert.assertFalse(calenderButton.isEnabled());
    }
//This method will verify the validation on mandatory fields//
    public void verifyMandatoryfieldsValidations() {
        submitForReviewButton.click();
        Assert.assertEquals("Title is required field", titleRequiredValidation.getText());
        Assert.assertEquals("Notes is required field", notesFieldRequiredValidation.getText());

    }
//This method will enter the title of note//
    public void enterNoteTitle(String notetitlename) {
        noteTitle.sendKeys(notetitlename);
    }
    //This method will enter the description of note//

    public void enterOneToOneDesc(String onetoonedecs) {
        waitFor(iFrameOneToOneSection).waitUntilVisible();
        getDriver().switchTo().frame(iFrameOneToOneSection);
        oneToOneSection.sendKeys(onetoonedecs);
        getDriver().switchTo().defaultContent();
    }
//This method will click on review button//
    public void submitForReviewButton() {
        submitForReviewButton.click();
    }
//This method will the success message,note title and status of note//
    public void oneToOneVerification(String title, String status) {
        Assert.assertEquals("Action performed successfully!",actionSuccessMessage.getText());
        Assert.assertEquals(title, oneToOneTitle.getText());
        Assert.assertEquals(status, oneToOneStatus.getText());
    }

}
