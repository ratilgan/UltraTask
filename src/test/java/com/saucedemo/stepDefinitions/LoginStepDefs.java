package com.saucedemo.stepDefinitions;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("Standard user logs in")
    public void standard_user_logs_in() {
        loginPage.logIn();
    }

}
