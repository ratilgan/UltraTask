package com.saucedemo.stepDefinitions;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.Given;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("Standard user logs in")
    public void standard_user_logs_in() {
        loginPage.logIn();
    }
}
