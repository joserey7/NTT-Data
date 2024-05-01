package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Helpers;

import java.util.List;

public class SauceCartPage {

    WebDriver driver;
    JavascriptExecutor js;

    public SauceCartPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    public WebElement buttonCheckout;

    @FindBy(css = "[data-test = 'inventory-item-name']")
    public WebElement divInventoryItemName;

    @FindBy(css = "[data-test = 'inventory-item-price']")
    public WebElement divInventoryItemPrice;

    public void clickCheckout() {
        Helpers.waitToBeVisible(buttonCheckout);
        buttonCheckout.click();
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
