package com.fast.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")
public class MyAccountPage extends PageObject {


    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade welcomeMessageStrong;

    @FindBy(css = "a[href*='customer-logout']")
    private WebElementFacade costumerLogoutButton;

    public boolean checkLoggedIn(String loginMessage) {
        waitFor(welcomeMessageStrong);
        return welcomeMessageStrong.containsText(loginMessage);
    }

    public boolean checkRegister(String username) {
        waitFor(welcomeMessageStrong);
        return welcomeMessageStrong.containsText("Hello " + username);
    }

    public void clickCostumerLogout() {
        clickOn(costumerLogoutButton);
    }

}
