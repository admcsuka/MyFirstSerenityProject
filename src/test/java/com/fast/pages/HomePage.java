package com.fast.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.concurrent.TimeUnit;

@DefaultUrl("http://qa5.fasttrackit.org:8008/")
public class HomePage extends PageObject {

    @FindBy(css = ".menu-item-70 a")
    private WebElementFacade myAccountButton;

    @FindBy(id = "menu-item-73")
    private WebElementFacade shopButton;

    @FindBy (id = "menu-item-72")
    private WebElementFacade cartButton;

    @FindBy(css = "a[title*='View your shopping cart']")
    private WebElementFacade shoppingCartIcon;


    public void clickMyAccountButton(){
        withTimeoutOf(15, TimeUnit.SECONDS).waitFor(myAccountButton);
        clickOn(myAccountButton);
    }

    public void clickShopButton(){
        clickOn(shopButton);
    }

    public void clickCartButton(){
        clickOn(cartButton);
    }

    public void clickOnShoppingCartIcon(){
        clickOn(shoppingCartIcon);
    }


}
