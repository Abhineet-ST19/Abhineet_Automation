package PMS.pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ProfilePage extends PageObject {
    HomePage homePage;
    //FileInputStream fis = new FileInputStream("C:\\WorkFolder\\Automation\\PMS-BDD\\src\\PropertyFilejkj.property");
    //Properties prop=new Properties();

    @FindBy(xpath = "//h3[@class='kt-subheader__title']")
    WebElement myProfilePageTitle;
    @FindBy(xpath = "//a[@class='kt-widget__username']")
    WebElement employeeName;
    @FindBy(xpath = "//a[contains(@href,'mailto')]")
    WebElement employeeEmailId;
    @FindBy(xpath = "(//a[contains(@href,'javascript:;')])[3]")
    WebElement employeeWorkLocation;
    @FindBy(xpath = "(//a[contains(@href,'javascript:;')])[4]")
    WebElement employeeDesignation;
    @FindBy(xpath = "(//a[contains(@href,'javascript:;')])[5]")
    WebElement employeeID;
    @FindBy(xpath = "//span[text()='Department']")
    WebElement departmenetTitle;
    @FindBy(xpath = "//span[text()='Sub Department']")
    WebElement subDepartmentTitle;
    @FindBy(xpath = "//span[text()='Reporting Manager']")
    WebElement reportingManagerTitle;
    @FindBy(xpath = "(//span[@class='kt-widget__value'])[1]")
    WebElement empolyeeDepartment;
    @FindBy(xpath = "(//span[@class='kt-widget__value'])[2]")
    WebElement empolyeeSubDepartment;
    @FindBy(xpath = "(//span[@class='kt-widget__value'])[3]")
    WebElement empolyeeReportingManager;
    @FindBy(xpath = "//h3[contains(text(),'Goals')]")
    WebElement employeeGoal;
    @FindBy(xpath = "//h3[contains(text(),'One To One')]")
    WebElement employeeOneToOne;
    @FindBy(xpath = "//h3[contains(text(),'Year End Review')]")
    WebElement employeeYearEndReview;

//Click on My Profile option//
    public void clickOnMyProfilePage() {

        homePage.myProfileLink.click();
    }
//This function will verify the page title as My Profile//
    public void verifyPageTitle() {
        Assert.assertEquals("  My Profile", myProfilePageTitle.getText());
    }
//This function will verify all the basic details about emp//
    public void verifyEmployeeDetailsOnTop() {
        Assert.assertEquals("Abhineet Kumar", employeeName.getText());
        Assert.assertEquals("abhineet.kumar@successive.tech", employeeEmailId.getText());
        Assert.assertEquals("Noida", employeeWorkLocation.getText());
        Assert.assertEquals("Quality Engineer", employeeDesignation.getText());
        Assert.assertEquals("SS/SD/19/106", employeeID.getText());
    }
    //This function will verify all the department details about emp//
    public void verifyEmployeeDetailsOnMiddle() {
        Assert.assertEquals("Department",departmenetTitle.getText());
        Assert.assertEquals("Sub Department",subDepartmentTitle.getText());
        Assert.assertEquals("Reporting Manager",reportingManagerTitle.getText());
        Assert.assertEquals("Quality Analysis",empolyeeDepartment.getText());
        Assert.assertEquals("Quality Analyst",empolyeeSubDepartment.getText());
        Assert.assertEquals("Prawal Sharma",empolyeeReportingManager.getText());
    }
    //This function will verify all the tabs like goal,one to one,and year of review//
    public void verifyEmployeeDetailsOnBottom(){
        Assert.assertEquals("Goals",employeeGoal.getText());
        Assert.assertEquals("One To One",employeeOneToOne.getText());
        Assert.assertEquals("Year End Review",employeeYearEndReview.getText());
    }
}
