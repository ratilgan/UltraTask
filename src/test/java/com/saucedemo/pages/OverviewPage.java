package com.saucedemo.pages;

import com.saucedemo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class OverviewPage {

    public OverviewPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "summary_subtotal_label")
    public WebElement totalListedPrice;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemPrices;

    public void validateTheTotalPrice(){

        // getting the actual total price as String without $ sign
        String totalPriceListed = totalListedPrice.getText().substring(totalListedPrice.getText().indexOf('$')+1);

        // parsing the actual total price to double
        String[] arr = totalPriceListed.split("\\.");
        double actualTotalPrice = Double.parseDouble(arr[0]) + Double.parseDouble(arr[1]) / 100;
        System.out.println("actualTotalPrice = " + actualTotalPrice);

        // getting each price, parsing them to double and calculating total expected price
        double expectedTotalPrice = 0;
        List<Double> expectedPrices = new ArrayList<>();

        for (WebElement itemPrice : itemPrices) {
            String itemPriceString = itemPrice.getText().substring(itemPrice.getText().indexOf("$")+1);
            String[] arr1 = itemPriceString.split("\\.");
            expectedPrices.add(Double.valueOf(arr1[0]) + Double.valueOf(arr1[1])/100);
        }

        for (Double expectedPrice : expectedPrices) {
            expectedTotalPrice += expectedPrice.doubleValue();
        }
        System.out.println("expectedTotalPrice = " + expectedTotalPrice);

        Assert.assertEquals(expectedTotalPrice, actualTotalPrice, 0);
    }
}
