package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SauceCartPage;
import pages.SauceCheckoutPage;
import pages.SauceLoginPage;
import pages.SauceProductsPage;

import static hooks.BaseTest.driver;

public class SauceStepDef {
    SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
    SauceProductsPage sauceProductsPage = new SauceProductsPage(driver);
    SauceCartPage sauceCartPage = new SauceCartPage(driver);
    SauceCheckoutPage sauceCheckoutPage = new SauceCheckoutPage(driver);


    @Given("The user navigates to {string}")
    public void the_user_navigates_to(String url) {
        driver.get(url);
    }

    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @When("The user enters the username {string}")
    public void the_user_enters_the_username(String username) {
        sauceLoginPage.typeUsername(username);
    }

    @When("The user enters the password {string}")
    public void the_user_enters_the_password(String password) {
        sauceLoginPage.typePassword(password);
    }

    @When("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        sauceLoginPage.clickLoginButton();
    }

    @Then("The user should be navigated to the products page")
    public void the_user_should_be_navigated_to_the_products_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));
    }


    @Given("The user is on the products page")
    public void the_user_is_on_the_products_page() {
        String title = sauceProductsPage.getPageTitle();
        Assert.assertTrue(title.equalsIgnoreCase("products"));
    }

    @When("The user clicks on the Add to cart button on the first product")
    public void the_user_clicks_on_the_Add_to_cart_button_on_the_first_product() {
        sauceProductsPage.clickAddToCart();
    }

    @When("The user should see the remove button")
    public void the_user_should_see_the_remove_button() {
        sauceProductsPage.checkRemoveButton();
    }

    @When("The user clicks on the shopping cart icon")
    public void the_user_clicks_on_the_shopping_cart_icon() {
        sauceProductsPage.clickShoppingCart();
    }

    @When("The user should be navigated to the cart page")
    public void the_user_should_be_navigated_to_the_cart_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("cart.html"));;
        Assert.assertEquals(sauceProductsPage.getProductPrice(), sauceCartPage.getProductPrice());
        Assert.assertEquals(sauceProductsPage.getProductName(), sauceCartPage.getProductName());
    }

    @When("The user clicks on the checkout button")
    public void the_user_clicks_on_the_checkout_button() {
        sauceCartPage.clickCheckout();
    }

    @When("fills the personal information")
    public void fills_the_personal_information() {
        sauceCheckoutPage.fillInformation("John", "Doe", "12345");
    }

    @When("clicks on the continue button")
    public void clicks_on_the_continue_button() {
        sauceCheckoutPage.clickContinue();
    }

    @When("clicks on the finish button")
    public void clicks_on_the_finish_button() {
        Assert.assertEquals(sauceProductsPage.getProductPrice(), sauceCheckoutPage.getProductPrice());
        Assert.assertEquals(sauceProductsPage.getProductName(), sauceCheckoutPage.getProductName());
        sauceCheckoutPage.clickFinish();
    }

    @Then("The user should see the thank you message {string}")
    public void the_user_should_see_the_thank_you_message(String message) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-complete.html"));
        Assert.assertEquals(sauceCheckoutPage.getCompleteHeader(), message.toLowerCase());
    }

}
