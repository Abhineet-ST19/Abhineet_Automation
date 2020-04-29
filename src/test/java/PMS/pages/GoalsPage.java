package PMS.pages;

import cucumber.api.java.bs.A;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static PMS.utilities.RandomGenerator.randomInteger;

public class GoalsPage extends PageObject {
String goalTitleName="Goal 2020";



    @FindBy(xpath = "//a[text()=' Add Goals']")
    WebElement addGoalbutton;

    @FindBy(xpath = "//button[text()=' Submit for Review']")
    WebElement submitForReviewButton;

    @FindBy(xpath = "//p[text()='Title is required field']")
    WebElement goalTitleValidation;

    @FindBy(xpath = "//p[text()='Subcategory is required field']")
    WebElement subCategoryValidation;

    @FindBy(xpath = "//p[text()='Goal is required field']")
    WebElement goalFieldValidation;

    @FindBy(xpath = "//p[text()='Sum of weightage must be 80']")
    WebElement weightageVaildationForWeightage;

    @FindBy(xpath = "//p[text()='Weightage is required field']")
    WebElement weightageVaildationForMandatory;
    @FindBy(xpath = "//input[@id='goalstitle']")
    WebElement goalTitle;
    @FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    WebElement goalSection;
    @FindBy(xpath = "(//iframe[@class='cke_wysiwyg_frame cke_reset'])")
    List<WebElement> goaliFrame;
    @FindBy(xpath = "//select[@name='subcategory[]']")
    List<WebElement> subCategoryValue;
    @FindBy(xpath = "//input[@placeholder='Weightage']")
    List<WebElement> weightageValue;
    @FindBy(xpath = "//button[@class='btn btn-default addmore']")
    WebElement subAddGoalButton;
    @FindBy(xpath = "//button[text()=' Save Draft']")
    WebElement saveDraftButton;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    WebElement successMessage;
    @FindBy(xpath = "//a[text()='Drafts']")
    WebElement draftButton;
    @FindBy(xpath = "//td[2]/a")
    WebElement goalTitleHyperLink;
    @FindBy(xpath = "//a[@class='btn btn-sm btn-primary']")
    WebElement editGoalButton;
    @FindBy(xpath = "//button[text()=' Submit']")
    WebElement submitButton;
    @FindBy(xpath = "//span[text()='Pending Approval']")
    WebElement checkForStatusOfGoal;



    public void addGoalButtonClick() {
        addGoalbutton.click();
    }

    public void submitForReviewButtonClick() {
        Assert.assertEquals("Submit for Review", submitForReviewButton.getText());
        submitForReviewButton.click();
    }

    public void checkValidationForGoalTitleField() {
        Assert.assertEquals("Title is required field", goalTitleValidation.getText());
    }

    public void checkValidationForSubCategoryField() {
        Assert.assertEquals("Subcategory is required field", subCategoryValidation.getText());

    }

    public void checkValidationForGoalField() {
        Assert.assertEquals("Goal is required field", goalFieldValidation.getText());
    }

    public void checkValidationForWeightageField() {
        Assert.assertEquals("Sum of weightage must be 80", weightageVaildationForWeightage.getText());
        Assert.assertEquals("Weightage is required field", weightageVaildationForMandatory.getText());
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(goalTitle);
    }

    public void enterGoalTitle() {
        goalTitle.sendKeys(goalTitleName);



    }

    public void addSubGoal() {

        for (int i = 0; i <= 3; i++) {
            subAddGoalButton.click();

        }
    }

    public void enterGoalFieldsDetails(String weightage) {
        waitABit(3000);

        for (int y = 0; y < goaliFrame.size(); y++) {

            getDriver().switchTo().frame(y);

            goalSection.sendKeys("Test goal_1" + randomInteger(2));

            getDriver().switchTo().defaultContent();

            waitFor(subCategoryValue.get(y)).selectByIndex(y + 1);
            waitFor(weightageValue.get(y)).sendKeys(weightage);
        }


    }
    public void checkValidationForWeightageMustBeEqual80(){
        Assert.assertEquals("Sum of weightage must be 80", weightageVaildationForWeightage.getText());
    }
public void clickOnSaveDraftButton(){
        saveDraftButton.click();
}

public void checkForSuccessMessage(){
        Assert.assertEquals("Action performed successfully!",successMessage.getText());
}
public void clickOnDraftButton(){
        draftButton.click();
}
public void clickOnGoalTitleHyperLink(){
    goalTitleHyperLink.click();
        withTimeoutOf(5,TimeUnit.SECONDS).waitFor(editGoalButton);
}
public void clickOnEditGoalButton(){
        editGoalButton.click();
}
public void clickOnSubmitButton(){
    Assert.assertEquals("Submit",submitButton.getText());
    submitButton.click();
}
public void checkForStatusofGoal(){
        Assert.assertEquals("Pending Approval",checkForStatusOfGoal.getText());
}


}



