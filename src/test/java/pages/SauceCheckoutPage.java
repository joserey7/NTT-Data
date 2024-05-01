package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;

public class SauceCheckoutPage {

    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(id = "first-name")
    public WebElement inputFirstName;

    @FindBy(id = "last-name")
    public WebElement inputLastName;

    @FindBy(id = "postal-code")
    public WebElement inputPostalCode;

    @FindBy(id = "continue")
    public WebElement inputContinue;

    @FindBy(id = "finish")
    public WebElement buttonFinish;

    @FindBy(css = "[data-test = 'complete-header']")
    public WebElement h2CompleteHeader;

    @FindBy(css = "[data-test = 'inventory-item-name']")
    public WebElement divInventoryItemName;

    @FindBy(css = "[data-test = 'inventory-item-price']")
    public WebElement divInventoryItemPrice;

    public SauceCheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    
    public void fillInformation(String firstName, String lastName, String postalCode) {
        Helpers.waitToBeVisible(inputFirstName);
        Helpers.waitToBeVisible(inputLastName);
        Helpers.waitToBeVisible(inputPostalCode);
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputPostalCode.sendKeys(postalCode);
    }

    public void clickContinue() {
        Helpers.waitToBeVisible(inputContinue);
        inputContinue.click();
    }

    public void clickFinish() {
        Helpers.waitToBeVisible(buttonFinish);
        buttonFinish.click();
    }

    public String getCompleteHeader() {
        Helpers.waitToBeVisible(h2CompleteHeader);
        return h2CompleteHeader.getText().trim().toLowerCase();
    }

    public String getProductPrice() {
        Helpers.waitToBeVisible(divInventoryItemName);
        return divInventoryItemPrice.getText();
    }

    public String getProductName() {
        Helpers.waitToBeVisible(divInventoryItemPrice);
        return divInventoryItemName.getText();
    }
    
}
