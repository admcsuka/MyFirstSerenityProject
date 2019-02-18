package com.fast.steps.serenity;
import com.fast.pages.CartPage;
import com.fast.pages.HomePage;
import com.fast.pages.ProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;


public class ProductsSteps extends ScenarioSteps {

    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;

    @Step
    public void navigateToHomePage(){
        getDriver().manage().window().maximize();
        homePage.open();
    }

    @Step
    public void navigateToShopPage(){
        homePage.clickShopButton();
    }

    @Step
    public void selectProductFromList(String productName){
        productPage.selectProductFromList(productName);
    }

    @Step
    public void findProductFromListWithIf(String nonExistent, String existingProduct){
        productPage.findProductFromListWithIf(nonExistent,existingProduct);
    }

    @Step
    public void checkSearchResultForProduct(String productName){
        Assert.assertTrue(productPage.checkSearchResultForProduct(productName));
    }

    @Step
    public void setQuantityBoxInProduct(String quantity){
        productPage.setQuantityBoxInProduct(quantity);
    }

    @Step
    public void clickAddToCart(){
        productPage.clickAddToCart();
    }
    @Step
    public void clickOnShoppingCartIcon(){
        homePage.clickOnShoppingCartIcon();
    }

    @Step
    public void navigateToCartButton(){
        homePage.clickCartButton();
    }

    @Step
    public void checkProductAddedToCart(String productName){
        Assert.assertTrue(cartPage.checkProductInCart(productName));
    }

    @StepGroup
    public void addToCartItem(String productName){
        navigateToHomePage();
        navigateToShopPage();
        selectProductFromList(productName);
        clickAddToCart();
        navigateToCartButton();
    }
}
