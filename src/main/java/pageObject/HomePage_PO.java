package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Global_Vars;

import java.text.ParseException;

import static java.lang.Integer.parseInt;

public class HomePage_PO extends Base_PO {

    /*
      @author aSalguti
      @Locators Store all the locators available in the HomePage
     */
    private @FindBy(id = "inputEmail") WebElement emailAddress_TextField;
    private @FindBy(id = "inputPassword") WebElement password_TextField;
    private @FindBy(css = ".form-signin .btn") WebElement signin_Button;
    private @FindBy(css = ".col-sm-4 .list-group") WebElement list_Group;
    private @FindBy(css = ".col-sm-4 .list-group .list-group-item[1]") WebElement list_item;
    private @FindBy(css = ".container #test-1-div h1") WebElement section1_Title;
    private @FindBy(css = ".container #test-2-div h1") WebElement section2_Title;
    private @FindBy(css = ".container #test-3-div h1") WebElement section3_Title;
    private @FindBy(css = ".container #test-4-div h1") WebElement section4_Title;
    private @FindBy(css = ".container #test-5-div h1") WebElement section5_Title;
    private @FindBy(css = ".container #test-6-div h1") WebElement section6_Title;
    private @FindBy(css = ".container #test-3-div #dropdownMenuButton") WebElement test3_DropdownButton;
    private @FindBy(css = ".container #test-3-div .dropdown .dropdown-menu") WebElement dropdownMenu;
    private @FindBy(css = ".container #test-4-div .btn-primary") WebElement firstButtonElement;
    private @FindBy(css = ".container #test-4-div .btn-secondary") WebElement secondButtonElement;
    private @FindBy(css = ".col-sm-4 #test5-button") WebElement test5Button;
    private @FindBy(css = ".col-sm-4 #test5-alert") WebElement button5Alert;

    /*
      @author aSalguti
      @Constructor Super method will initialize the Base_PO constructor and the driver elements
                    Same logic should be used in all newly created PageObjects
     */

    public HomePage_PO() {
        super();
    }

    /*
       @author aSalguti
       Redirect to the url stored in global variables
         */
    public void navigateTo_ResolverApplication_Home_Page() {
        navigateTo_URL(Global_Vars.RESOLVER_APPLICATION_HOMEPAGE_URL);
    }

    /*
       @author aSalguti
       Assert if the Email Address field is visible and enabled
        */
    public void validateEmailAddressField() {
        Assert.assertTrue(WaitUntilWebElementIsVisible(emailAddress_TextField));
        Assert.assertTrue(webElementIsEnabled(emailAddress_TextField));
    }
    /*
       @author aSalguti
       Assert if the password field is visible and enabled
       */
    public void validatePasswordField() {
        Assert.assertTrue(WaitUntilWebElementIsVisible(password_TextField));
        Assert.assertTrue(webElementIsEnabled(password_TextField));
    }
    /*
       @author aSalguti
       Assert if the SignIn button is visible and enabled
       */
    public void validateLoginButton() {
        Assert.assertTrue(WaitUntilWebElementIsVisible(signin_Button));
        Assert.assertTrue(webElementIsEnabled(signin_Button));
    }
    /*
       @author aSalguti
       @params Email Address
       Set email address provided in the feature file
       */
    public void setEmailAddress(String emailAddress) {
        sendkeys(emailAddress_TextField, emailAddress);
    }
    /*
    @author aSalguti
    @params password
    Set password provided in the feature file
       */
    public void setPassword(String password) {
        sendkeys(password_TextField, password);
    }

    public void clickOn_Signin_Button() {
        waitForWebElementAndClick(signin_Button);
    }
    /*
    @author aSalguti
    @params password
    Set password provided in the feature file
       */
    public void validateNumberOfItemsInListGroup(int numOfValues) {
        int numberofItemsList = getNumberOfItems(By.cssSelector(".col-sm-4 .list-group li"));
        Assert.assertEquals(numberofItemsList, numOfValues);

    }

    public void validateTheListItemText(int itemNumber, String itemName) {
        String listItemName = waitForElementAndGetText(getDriver().findElement(By.cssSelector(".col-sm-4 .list-group li:nth-child(" + itemNumber + ")")));
        Assert.assertTrue(listItemName.contains(itemName));
    }

    public void validateTheListItemBadgeValue(int itemNumber, int badgeValue) throws ParseException {
        String listItemBadgeValue = waitForElementAndGetText(getDriver().findElement(By.cssSelector(".col-sm-4 .list-group li:nth-child(" + itemNumber + ") .badge")));
        Assert.assertEquals(parseInt(listItemBadgeValue), badgeValue);
    }


    public void validateTheSectionTitle(String title) {
        switch (title) {
            case "Test 1" -> {
                assertText(waitForElementAndGetText(section1_Title), title);
                visibilityOfElement(section1_Title);
                break;
            }
            case "Test 2" -> {
                assertText(waitForElementAndGetText(section2_Title), title);
                visibilityOfElement(section2_Title);
                break;
            }
            case "Test 3" -> {
                assertText(waitForElementAndGetText(section3_Title), title);
                visibilityOfElement(section3_Title);
                break;
            }
            case "Test 4" -> {
                assertText(waitForElementAndGetText(section4_Title), title);
                visibilityOfElement(section4_Title);
                break;
            }
            case "Test 5" -> {
                assertText(waitForElementAndGetText(section5_Title), title);
                visibilityOfElement(section5_Title);
                break;
            }
            case "Test 6" -> {
                assertText(waitForElementAndGetText(section6_Title), title);
                visibilityOfElement(section6_Title);
                break;
            }

        }
    }

    public void validateTheDefaultSelectedOption(String defaultSelectedOption) {
        assertText(waitForElementAndGetText(test3_DropdownButton), defaultSelectedOption);
    }

    public void selectValueFromOptionList(String selectOption) {
        waitForWebElementAndClick(test3_DropdownButton);
        String[] nthValue = selectOption.split(" ");
        getDriver().findElement(By.cssSelector(".container #test-3-div .dropdown .dropdown-menu a:nth-child(" + nthValue[1] + ")")).click();
    }

    public boolean validateButtonIsEnabled() {
        Assert.assertTrue(webElementIsEnabled(firstButtonElement));
        return webElementIsEnabled(firstButtonElement);
    }

    public boolean validateButtonIsDisabled() {
        Assert.assertTrue(webElementIsDisabled(secondButtonElement));
        return webElementIsDisabled(secondButtonElement);
    }

    public void validateUserIsAbletoClickonButton() {
        waitForWebElementAndClick(test5Button);
    }

    public void validateSuccessMessage(String successMessage) {
        assertText(waitForElementAndGetText(button5Alert).trim(), successMessage);
    }

    public String getTextFromTest6Table(int rowNumber, int columnNumber) {
        return waitForElementAndGetText(By.cssSelector("#test-6-div > div > table > tbody > tr:nth-child(" + (columnNumber + 1) + ") td:nth-child(" + (rowNumber + 1) + ")"));
    }

}
