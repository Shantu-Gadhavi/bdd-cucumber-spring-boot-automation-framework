package com.cucumber.steps;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.cucumber.commonbase.Base;
import com.cucumber.configurations.annotations.LazyAutowired;
import com.cucumber.pages.LoginPage;
import com.cucumber.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SpringDemoStepDef extends Base {

    @LazyAutowired LoginPage loginPage;
    @LazyAutowired ProductsPage productsPage;

    @When("user logged in with valid login details")
    public void user_logged_in_with_valid_login_details() {
        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
    }

    @Then("verify that it should redirect to product page")
    public void verify_that_it_should_redirect_to_page() {
        waitHelper.waitForElement();
        softAssert.assertTrue(loginPage.verifyProductsPage(),"verify that it should redirect to product page - Failed");
    }

    @When("user add {string} product to the cart")
    public void user_add_product_to_the_cart(String prodName){
        waitHelper.waitForElement();
        productsPage.clickAddToCart(prodName);
    }

    @Then("verify that selected product is added to cart or not")
    public void verify_that_selected_product_is_added_to_cart_or_not(){
        softAssert.assertTrue(productsPage.verifyTheProductsAddedInCart(), "verify that selected product is added to cart or not - FAILED");
    }

    @When("user click on cart button")
    public void user_click_on_cart_button() {
        waitHelper.waitForElement();
        productsPage.clickViewCart();
    }

    @And("take a screenshot")
    public void take_a_screenshot() {
        try {
            scenario.attach(screenshotService.getScreenshot(), "image/png", scenario.getName());
        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());
        }
    }
}
