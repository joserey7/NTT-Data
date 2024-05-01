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

// page_url = https://www.saucedemo.com/
public class SauceProductsPage {

    WebDriver driver;
    JavascriptExecutor js;

    public SauceProductsPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "[data-test='inventory-item']")
    List<WebElement> productContainers;

    @FindBy(css = "[data-test = 'inventory-item-price']")
    public WebElement divInventoryItemPrice;

    @FindBy(css = "[data-test = 'inventory-item-name']")
    public WebElement divInventoryItemName;

    @FindBy(css = "span[data-test='title']")
    public WebElement pageTitle;

    @FindBy(css = "a[data-test='shopping-cart-link']")
    public WebElement linkShoppingCart;

    public String getPageTitle() {
        Helpers.waitToBeVisible(pageTitle);
        return pageTitle.getText().trim().toLowerCase();
    }
    
    public void clickAddToCart() {
        Helpers.waitToBeVisible(productContainers.get(0));
        WebElement firstProductContainer = productContainers.get(0);
        WebElement buttonAddToCart = firstProductContainer.findElement(By.tagName("button"));
        buttonAddToCart.click();
    }

    public void checkRemoveButton() {
        Helpers.waitToBeVisible(productContainers.get(0));
        WebElement firstProductContainer = productContainers.get(0);
        WebElement buttonRemove = firstProductContainer.findElement(By.tagName("button"));
        Assert.assertTrue(buttonRemove.getText().equalsIgnoreCase("remove"));
    }
    
    public void clickShoppingCart() {
        Helpers.waitToBeVisible(linkShoppingCart);
        linkShoppingCart.click();
    }

    public String getProductPrice() {
        Helpers.waitToBeVisible(productContainers.get(0));
        WebElement firstProductContainer = productContainers.get(0);
        return firstProductContainer.findElement(By.cssSelector("[data-test = 'inventory-item-price']")).getText();
    }

    public String getProductName() {
        Helpers.waitToBeVisible(productContainers.get(0));
        WebElement firstProductContainer = productContainers.get(0);
        return firstProductContainer.findElement(By.cssSelector("[data-test = 'inventory-item-name']")).getText();
    }

}
