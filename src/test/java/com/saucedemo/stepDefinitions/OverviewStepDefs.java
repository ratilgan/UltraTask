package com.saucedemo.stepDefinitions;

import com.saucedemo.pages.OverviewPage;
import io.cucumber.java.en.Then;

public class OverviewStepDefs {

    OverviewPage overviewPage = new OverviewPage();

    @Then("total price should validated")
    public void total_price_should_validated() {
        overviewPage.validateTheTotalPrice();
    }
}
