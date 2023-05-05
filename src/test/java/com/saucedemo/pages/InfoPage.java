package com.saucedemo.pages;

import com.github.javafaker.Faker;
import com.saucedemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfoPage {

    public InfoPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "first-name")
    public WebElement firstNameInputBox;

    @FindBy(id = "last-name")
    public WebElement lastNameInputBox;

    @FindBy(id = "postal-code")
    public WebElement postalCodeInputBox;

    @FindBy(id = "continue")
    public WebElement continueButton;


    public void fillInformationInputs(){
        Faker faker = new Faker();

        firstNameInputBox.sendKeys(faker.name().firstName());
        lastNameInputBox.sendKeys(faker.name().lastName());
        postalCodeInputBox.sendKeys(faker.address().zipCode());
    }

    public void clickContinueButton(){
        continueButton.click();
    }


}
