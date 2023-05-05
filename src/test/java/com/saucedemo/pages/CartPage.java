package com.saucedemo.pages;

import com.github.javafaker.Faker;
import com.saucedemo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".inventory_item_name")
    public List<WebElement> listedProductNames;

    @FindBy(css = ".inventory_item_price")
    public List<WebElement> listedProductPrices;








    public Map<String, String> getlistedProductInformation(){
        Map<String, String> listedProductInformation = new HashMap<>();
        for (int i = 0; i < listedProductNames.size(); i++) {
             listedProductInformation.put(listedProductNames.get(i).getText(),
                     listedProductPrices.get(i).getText());
        }

        return listedProductInformation;
    }









}
