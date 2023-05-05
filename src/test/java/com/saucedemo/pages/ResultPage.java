package com.saucedemo.pages;

import com.saucedemo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
    public ResultPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "complete-header")
    public WebElement successMessage;

    public void assertSuccessMessageIsAppeared(String expectedMessage){
        String actualMessage = successMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
