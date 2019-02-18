package com.fast.features;

import com.fast.steps.serenity.CartSteps;
import com.fast.steps.serenity.LoginSteps;
import com.fast.steps.serenity.ProductsSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class ProductsTests {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private ProductsSteps productsSteps;

    @Steps
    private CartSteps cartSteps;

    @Test
    public void addToCart() {
        loginSteps.login("Hello csukaadam93");
        productsSteps.navigateToShopPage();
        productsSteps.selectProductFromList("Long Sleeve Tee");
        productsSteps.checkSearchResultForProduct("Long Sleeve Tee");
        productsSteps.clickAddToCart();
        productsSteps.navigateToCartButton();
        productsSteps.checkProductAddedToCart("Long Sleeve Tee");
        cartSteps.clickOnProductRemoveButton();
        cartSteps.checkProductRemoveMessage();

    }

    @Test
    public void addToCartWithIfSelection() {
        loginSteps.login("Hello csukaadam93");
        productsSteps.navigateToShopPage();
        productsSteps.findProductFromListWithIf("Flux capacitor", "Belt");
        productsSteps.checkSearchResultForProduct("Belt");
        productsSteps.clickAddToCart();
        productsSteps.clickOnShoppingCartIcon();
        productsSteps.checkProductAddedToCart("Belt");
        cartSteps.clickOnProductRemoveButton();
        cartSteps.checkProductRemoveMessage();
    }

}
