package com.saucedemo.stepDefinitions;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartStepsDefs {

    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();

    @When("navigates the cart page")
    public void navigates_the_cart_page() {
        productsPage.shoppingCartLink.click();
    }
    @Then("items added should be listed")
    public void items_added_should_be_listed() throws InterruptedException {
        Assert.assertEquals(ProductsPage.productInformations, cartPage.getlistedProductInformation());
    }






}
