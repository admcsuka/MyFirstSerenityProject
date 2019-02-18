package com.fast.steps.serenity;

import com.fast.pages.CheckoutPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class CheckoutSteps extends ScenarioSteps {

    private CheckoutPage checkoutPage;

    @Step
    public void setFirstName(){
        checkoutPage.setBillingFirstName("Slim");
    }

    @Step
    public void setLastName(){
        checkoutPage.setBillingLastName("Shady");
    }

    @Step
    public void chooseCountry(){
        checkoutPage.clickOnCountryDropDown("Romania");
    }

    @Step
    public void setStreetAddress(){
        checkoutPage.setStreetAddress("Elm Street");
    }

    @Step
    public void setCityName(){
        checkoutPage.setCityName("Cluj-Napoca");
    }

    @Step
    public void setPostcode(){
        checkoutPage.setBillingPostCode("666777");
    }

    @Step
    public void setPhoneNumber(){
        checkoutPage.setBillingPhoneNumber("120098767");
    }

    @Step
    public void setEmailAddress(){
        checkoutPage.setBillingEmail("godsavethequeen@pistols.com");
    }

    @Step
    public void setOrderComments(){
        checkoutPage.setOrderComments("Ain`t nobody got time for that");
    }

    @Step
    public void clickPlaceOrderButton(){
        checkoutPage.clickOnPlaceOrderButton();
    }

    @Step
    public void checkOrderReceivedMessage(){
        Assert.assertTrue(checkoutPage.checkOrderPlacement("Thank you. Your order has been received."));
    }

    @Step
    public void setPhoneWithoutValue(){
        checkoutPage.setBillingPhoneNumberWithoutValue("");
    }

    @Step
    public void setWrongEmail(){
        checkoutPage.setBillingEmailInvalid("nokardashians@.com");
    }

    @Step
    public void missingDetails(){
        checkoutPage.missingDetails("Billing Phone is a required field.", "Billing Email address is not a valid email address.","0788569421","new.email@email.com" );
    }

}
