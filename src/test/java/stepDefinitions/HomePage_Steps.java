package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObject.Base_PO;
import pageObject.HomePage_PO;

import java.text.ParseException;
/*

 */
public class HomePage_Steps extends Base_PO {

    private HomePage_PO homePage_po;

    public HomePage_Steps(HomePage_PO homePage_po){
        this.homePage_po = homePage_po;
    }
    @Given("Access the Resolver Assessment home page")
    public void accessTheResolverAssessmentHomePage() {
        homePage_po.navigateTo_ResolverApplication_Home_Page();
    }

    @And("User Verify that Email address and password fields are present")
    public void user_verify_that_email_address_and_password_fields_are_present() {
        homePage_po.validateEmailAddressField();
        homePage_po.validatePasswordField();
    }
    @And("Verify that login button is present")
    public void verify_that_login_button_is_present() {
        homePage_po.validateLoginButton();

    }
    @Then("Enter the email-address as {}")
    public void enter_the_email_address(String emailAddress) {
        homePage_po.setEmailAddress(emailAddress);
    }
    @Then("Enter the password as {}")
    public void enter_the_password(String password) {
        homePage_po.setPassword(password);
    }
    @And("Click on signin button")
    public void click_on_signin_button() {
        homePage_po.clickOn_Signin_Button();
    }

    @And("User Verify that there are {int} values in the list group")
    public void user_verify_That_There_Are_Values_In_The_ListGroup(int numOfValues) {
        homePage_po.validateNumberOfItemsInListGroup(numOfValues);
    }
    @And("Verify that the {int} list item value is set to {string}")
    public void verify_that_the_list_item_value_is_set_to(int itemNumber, String itemName) {
        homePage_po.validateTheListItemText(itemNumber, itemName);
    }
    @And("Verify that the {int} list item's badge value is {int}")
    public void verify_that_the_list_item_badge_value_is_set(int itemNumber, int badgeValue) throws ParseException {
        homePage_po.validateTheListItemBadgeValue(itemNumber, badgeValue);
    }

    @Then("User verify that the Section title is {string}")
    public void userVerifyThatTheSectionTitleIs(String title) {
        homePage_po.validateTheSectionTitle(title);
    }

    @And("User verify that {string} is the default selected value")
    public void userVerifyThatIsTheDefaultSelectedValue(String defaultSelectedOption) {
        homePage_po.validateTheDefaultSelectedOption(defaultSelectedOption);
    }

    @And("User select {string} from dropdown list")
    public void userSelectFromDropdownList(String selectOption) {
        homePage_po.selectValueFromOptionList(selectOption);
    }

    @And("User verify that 1st button is enabled")
    public void userVerifyThatStButtonIsEnabled() {
        homePage_po.validateButtonIsEnabled();
    }

    @And("User verify that 2nd button is disabled")
    public void userVerifyThatNdButtonIsDisabled() {
        homePage_po.validateButtonIsDisabled();
    }

    @And("User wait for the button to be displayed and click on it")
    public void userWaitForTheButtonToBeDisplayedAndClickOnIt() {
        homePage_po.validateUserIsAbletoClickonButton();
    }

    @Then("User verify that the success message is displayed as {string}")
    public void userVerifyThatTheSuccessMessageIsDisplayedAs(String successMessage) {
        homePage_po.validateSuccessMessage(successMessage);
    }

    @And("User retrieve the value located at coordinates {int},{int}")
    public void userRetrieveTheValueLocatedAtCoordinates(int rowNumber, int columnNumber) {
    homePage_po.getTextFromTest6Table(rowNumber, columnNumber);
    }

    @Then("User assert the value of cell is {string} at {int},{int}")
    public void userAssertTheValueOfCellIsAt(String expectedCellValue, int rowNumber, int columnNumber) {
        String actualcellValue = homePage_po.getTextFromTest6Table(rowNumber, columnNumber);
        assertText(actualcellValue, expectedCellValue);
    }
}
