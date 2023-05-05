package com.saucedemo.pages;

import com.saucedemo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ProductsPage {

    public ProductsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[starts-with(@id,'add-to-cart') or starts-with(@id,'remove')]")
    public List<WebElement> addToCartAndRemoveButtons;

    @FindBy(xpath = "//button[starts-with(@id,'add-to-cart')]")
    public List<WebElement> addToCartButtons;

    @FindBy(css = ".shopping_cart_link>span")
    public WebElement shoppingCartBadge;


    int itemIndexNumber;
    int numberOfItemsToAdd;
    Random random = new Random();


    public void addAnItemToTheCart(){
        itemIndexNumber = random.nextInt(addToCartAndRemoveButtons.size()-1);
        addToCartAndRemoveButtons.get(itemIndexNumber).click();
    }

    public void removeAnItemFromTheCart(){
        addToCartAndRemoveButtons.get(itemIndexNumber).click();
    }

    public void assertTheTextAndColorOfTheButton(String expectedText){
        Assert.assertEquals(expectedText, addToCartAndRemoveButtons.get(itemIndexNumber).getText());
    }

    public void clickToButtonWithTextName(String buttonName){
        Driver.get().findElement(By.xpath("//button[.='"+ buttonName +"']")).click();
    }

    public void addSomeItemsToTheCart(int numberOfItemsToAdd){
        this.numberOfItemsToAdd = numberOfItemsToAdd;
        for (int i = numberOfItemsToAdd; i > 0; i--) {
            addToCartButtons.get(random.nextInt(addToCartButtons.size())).click();
        }
    }

    public void assertNumberOfAddedItems(){
        Assert.assertEquals(numberOfItemsToAdd, Integer.parseInt(shoppingCartBadge.getText()));
    }
}
