package com.fast.features;

import com.fast.steps.serenity.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CheckoutTests {

    @Managed(uniqueSession = true)
    private WebDriver webDriver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private ProductsSteps productsSteps;

    @Steps
    private CartSteps cartSteps;

    @Steps
    private CheckoutSteps checkoutSteps;

    @Steps
    private AdminSteps adminSteps;

    @Test
    public void checkoutWithValid(){
        productsSteps.addToCartItem("Album");
        cartSteps.clickCheckoutButton();
        checkoutSteps.setFirstName();
        checkoutSteps.setLastName();
        checkoutSteps.chooseCountry();
        checkoutSteps.setCityName();
        checkoutSteps.setStreetAddress();
        checkoutSteps.setPostcode();
        checkoutSteps.setPhoneNumber();
        checkoutSteps.setEmailAddress();
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.checkOrderReceivedMessage();
    }

    @Test
    public void checkoutInvalid(){
        productsSteps.addToCartItem("Cap");
        cartSteps.clickCheckoutButton();
        checkoutSteps.setFirstName();
        checkoutSteps.setLastName();
        checkoutSteps.chooseCountry();
        checkoutSteps.setCityName();
        checkoutSteps.setStreetAddress();
        checkoutSteps.setPostcode();
        checkoutSteps.setPhoneWithoutValue();
        checkoutSteps.setWrongEmail();
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.missingDetails();
        checkoutSteps.setOrderComments();
    }

}
