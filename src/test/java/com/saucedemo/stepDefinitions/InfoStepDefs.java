package com.saucedemo.stepDefinitions;

import com.saucedemo.pages.InfoPage;
import io.cucumber.java.en.When;

public class InfoStepDefs {

    InfoPage infoPage = new InfoPage();

    @When("fills the information inputs")
    public void fills_the_information_inputs() {
        infoPage.fillInformationInputs();
    }

    @When("user clicks Continue button")
    public void user_clicks_continue_button() {
        infoPage.clickContinueButton();
    }
}
