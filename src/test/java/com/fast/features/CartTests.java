package com.fast.features;

import com.fast.pages.HomePage;
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
public class CartTests {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private HomePage homePage;

    @Steps
    private ProductsSteps productsSteps;

    @Steps
    private CartSteps cartSteps;

    @Test
    public void changeProductQuantity() {
        cartSteps.navigateToHomePage();
        cartSteps.navigateToShopButton();
        productsSteps.selectProductFromList("Belt");
        productsSteps.setQuantityBoxInProduct("12");
        productsSteps.clickAddToCart();
        cartSteps.navigateToCartButton();
        cartSteps.checkQuantityPriceUpdate();
    }

    @Test
    public void deleteFromCart() {
        cartSteps.navigateToHomePage();
        loginSteps.login("Hello csukaadam93");
        cartSteps.navigateToShopButton();
        productsSteps.selectProductFromList("Belt");
        productsSteps.clickAddToCart();
        cartSteps.navigateToCartButton();
        cartSteps.clickOnProductRemoveButton();
        cartSteps.checkProductRemoveMessage();
    }

    @Test
    public void checkCartAfterReopen() {
        cartSteps.navigateToHomePage();
        loginSteps.login("Hello csukaadam93");
        cartSteps.navigateToShopButton();
        productsSteps.selectProductFromList("Belt");
        productsSteps.clickAddToCart();
        cartSteps.navigateToCartButton();
        driver.quit();
        cartSteps.navigateToHomePage();
        loginSteps.login("Hello csukaadam93");
        cartSteps.navigateToCartButton();
        cartSteps.clickOnProductRemoveButton();
        cartSteps.checkProductRemoveMessage();
    }


}
