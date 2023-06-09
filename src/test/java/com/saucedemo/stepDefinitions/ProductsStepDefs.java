package com.saucedemo.stepDefinitions;

import com.saucedemo.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsStepDefs {

    ProductsPage productsPage = new ProductsPage();

    @When("user adds an item to the cart")
    public void user_adds_an_item_to_the_cart() {
        productsPage.addAnItemToTheCart();
    }

    @Then("{string} text should appear")
    public void text_should_appear(String expectedText) {
        productsPage.assertTheTextOfTheButton(expectedText);
    }

    @When("user clicks {string} button")
    public void user_clicks_button(String buttonText) {
        productsPage.clickToButtonWithTextName(buttonText);
    }

    @Then("{string} text should be visible again")
    public void text_should_be_visible_again(String expectedText) {
        productsPage.assertTheTextOfTheButton(expectedText);
    }

    @When("user adds {int} item to the cart")
    public void user_adds_item_to_the_cart(int numberOfItemsToAdd) {
        productsPage.addSomeItemsToTheCart(numberOfItemsToAdd);
    }

    @Then("number of added items should be visible on the shopping cart badge")
    public void number_of_added_items_should_be_visible_on_the_shopping_cart_badge() {
        productsPage.assertNumberOfAddedItems();
    }
}
