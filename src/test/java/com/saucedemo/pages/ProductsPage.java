package com.saucedemo.pages;

import com.saucedemo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ProductsPage {

    public ProductsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[starts-with(@id,'add-to-cart') or starts-with(@id,'remove')]")
    public List<WebElement> addToCartAndRemoveButtons;

    @FindBy(xpath = "//button[starts-with(@id,'add-to-cart')]")
    public List<WebElement> addToCartButtons;

    @FindBy(css = ".shopping_cart_link")
    public WebElement shoppingCartLink;

    @FindBy(css = ".shopping_cart_link>span")
    public WebElement shoppingCartBadge;

    @FindBy(css = ".inventory_item_name")
    public List<WebElement> productNames;

    @FindBy(css = ".inventory_item_price")
    public List<WebElement> productPrices;


    int numberOfItemsToAdd;

    Random random = new Random();
    public static Map<String, String> productInformations = new HashMap<>();


    public void addAnItemToTheCart(){
        numberOfItemsToAdd = random.nextInt(addToCartAndRemoveButtons.size()-1);
        addToCartAndRemoveButtons.get(numberOfItemsToAdd).click();
    }

    public void removeAnItemFromTheCart(){
        addToCartAndRemoveButtons.get(numberOfItemsToAdd).click();
    }

    public void assertTheTextAndColorOfTheButton(String expectedText){
        Assert.assertEquals(expectedText, addToCartAndRemoveButtons.get(numberOfItemsToAdd).getText());
    }

    public void clickToButtonWithTextName(String buttonName){
        Driver.get().findElement(By.xpath("//button[.='"+ buttonName +"']")).click();
    }

    public void addSomeItemsToTheCart(int numberOfItemsToAdd){
        if (!productInformations.keySet().isEmpty())
            productInformations.clear();

        this.numberOfItemsToAdd = numberOfItemsToAdd;

        for (int i = 0; i < numberOfItemsToAdd; i++) {

            if(addToCartAndRemoveButtons.get(i).getAttribute("name").startsWith("add-to-cart"))
                addToCartAndRemoveButtons.get(i).click();

            if(addToCartAndRemoveButtons.get(i).getAttribute("name").startsWith("remove"))
                productInformations.put(productNames.get(i).getText(), productPrices.get(i).getText());

            System.out.println(productInformations);
        }
    }

    public void assertNumberOfAddedItems(){
        Assert.assertEquals(numberOfItemsToAdd, Integer.parseInt(shoppingCartBadge.getText()));
    }

}
