package com.fast.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=6")
public class CheckoutPage extends PageObject {

    @FindBy(css = ".wc-proceed-to-checkout a")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(id = "billing_first_name")
    private WebElementFacade billingFirstName;

    @FindBy(id = "billing_last_name")
    private WebElementFacade billingLastName;

    @FindBy(id = "billing_country")
    private WebElementFacade dropdownCountry;

    @FindBy(id = "billing_address_1")
    private WebElementFacade streetAddress;

    @FindBy(id = "billing_city")
    private WebElementFacade cityName;

    @FindBy(id = "billing_postcode")
    private WebElementFacade billingPostCode;

    @FindBy(id = "billing_phone")
    private WebElementFacade billingPhoneNumber;

    @FindBy(id = "billing_email")
    private WebElementFacade billingEmail;

    @FindBy(id = "createaccount")
    private WebElementFacade createAccountCheckBox;

    @FindBy(id = "account_password")
    private WebElementFacade createAccountPasswordInCheckout;

    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;

    @FindBy(id = "order_comments")
    private WebElementFacade orderCommnets;

    @FindBy(css = ".content-page p.woocommerce-notice")
    private WebElementFacade orderRecievedMessage;

    @FindBy(css = ".woocommerce-NoticeGroup li:nth-child(1)")
    private WebElementFacade missingPhone;

    @FindBy(css = ".woocommerce-NoticeGroup li:nth-child(2)")
    private WebElementFacade wrongEmail;


    public void setBillingFirstName(String firstName) {
        typeInto(billingFirstName, firstName);
    }

    public void setBillingLastName(String lastName) {
        typeInto(billingLastName, lastName);
    }

    public void clickOnCountryDropDown(String country) {
        dropdownCountry.selectByVisibleText(country);
    }

    public void setStreetAddress(String street) {
        typeInto(streetAddress, street);
    }

    public void setCityName(String city) {
        typeInto(cityName, city);
    }

    public void setBillingPostCode(String postCode) {
        typeInto(billingPostCode, postCode);
    }

    public void setBillingPhoneNumber(String phoneNumber) {
        typeInto(billingPhoneNumber, phoneNumber);
    }

    public void setBillingPhoneNumberWithoutValue(String wrongNumber) {
        typeInto(billingPhoneNumber, wrongNumber);
    }

    public void setBillingEmail(String email) {
        typeInto(billingEmail, email);
    }

    public void setBillingEmailInvalid(String invalidEmail) {
        typeInto(billingEmail, invalidEmail);
    }

    public void clickOnPlaceOrderButton() {
        clickOn(placeOrderButton);
    }

    public void setOrderComments(String comment) {
        typeInto(orderCommnets, comment);
    }


    public boolean checkOrderPlacement(String orderPlacementMessage) {
        waitFor(orderRecievedMessage);
        return orderRecievedMessage.containsText(orderPlacementMessage);
    }

    public boolean missingDetails(String missingPhoneNO, String wrongEmailAddress, String newNumber, String newEmail) {
        if ((missingPhone.getText().contains(missingPhoneNO)) && (wrongEmail.getText().contains(wrongEmailAddress))) {
            typeInto(billingPhoneNumber, newNumber);
            typeInto(billingEmail, newEmail);
            return true;
        }
        return false;
    }


}

