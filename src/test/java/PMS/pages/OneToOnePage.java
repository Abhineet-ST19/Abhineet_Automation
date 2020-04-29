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




    public void clickOnOneToOneModule() {
        homePage.oneToOneLink.click();

    }

    public void verifyOneToOnePage() {
        Assert.assertEquals("Add Notes", addNotesButton.getText());
        System.out.println("*********" + addNotesButton.getText());
    }

    public void clickOnAddNotesButton() {
        addNotesButton.click();
    }

    public void verifyCalenderNotClickable() {
        Assert.assertFalse(calenderButton.isEnabled());
    }

    public void verifyMandatoryfieldsValidations() {
        submitForReviewButton.click();
        Assert.assertEquals("Title is required field", titleRequiredValidation.getText());
        Assert.assertEquals("Notes is required field", notesFieldRequiredValidation.getText());

    }

    public void enterNoteTitle(String notetitlename) {
        noteTitle.sendKeys(notetitlename);
    }

    public void enterOneToOneDesc(String onetoonedecs) {
        waitFor(iFrameOneToOneSection).waitUntilVisible();
        getDriver().switchTo().frame(iFrameOneToOneSection);
        oneToOneSection.sendKeys(onetoonedecs);
        getDriver().switchTo().defaultContent();
    }

    public void submitForReviewButton() {
        submitForReviewButton.click();
    }

    public void oneToOneVerification(String title, String status) {
        Assert.assertEquals("Action performed successfully!",actionSuccessMessage.getText());
        Assert.assertEquals(title, oneToOneTitle.getText());
        Assert.assertEquals(status, oneToOneStatus.getText());
    }

}
