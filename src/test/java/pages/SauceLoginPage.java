package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;

// page_url = https://www.saucedemo.com/
public class SauceLoginPage {

    WebDriver driver;
    JavascriptExecutor js;

    public SauceLoginPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement usernameTexfield;

    @FindBy(id = "password")
    WebElement passwordTexfield;

    @FindBy(css = "input[data-test='login-button']")
    WebElement loginButton;

    public void typeUsername(String username) {
        Helpers.waitToBeVisible(usernameTexfield);
        usernameTexfield.sendKeys(username);
    }

    public void typePassword(String password) {
        Helpers.waitToBeVisible(passwordTexfield);
        passwordTexfield.sendKeys(password);
    }

    public void clickLoginButton() {
        Helpers.waitToBeVisible(loginButton);
        loginButton.click();
    }

}
