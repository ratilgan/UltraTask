package com.saucedemo.stepDefinitions;

import com.saucedemo.pages.ResultPage;
import io.cucumber.java.en.Then;

public class ResultStepDefs {

    ResultPage resultPage = new ResultPage();

    @Then("{string} message should appear")
    public void success_message_should_appear(String expectedMessage) {
        resultPage.assertSuccessMessageIsAppeared(expectedMessage);
    }
}
