package pageObject;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;
import java.util.List;

public class Base_PO {
    public Base_PO() {
        // Initialize all of our page objects
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateTo_URL(String url) {
        getDriver().get(url);
    }

    public void sendkeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }
    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitForAlert_And_ValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text, text);
    }

    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean webElementIsEnabled(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
            wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            return true;
        } catch (Exception e) {
            Assert.fail("WebElement is NOT enabled, Exception: " + e.getMessage());
            return false;
        }
    }
    public boolean webElementIsDisabled(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
            return !wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
    }
    public String waitForElementAndGetText(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }
    public String waitForElementAndGetText(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }
    //This will scroll the page till the element is found
    public void visibilityOfElement(WebElement element ) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public int getNumberOfItems(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        List<WebElement> itemsList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return itemsList.size();
    }
    public void assertText(String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText);
    }

}

