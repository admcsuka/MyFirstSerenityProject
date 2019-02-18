package com.fast.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=5")
public class CartPage extends PageObject {

    @FindBy(id = "menu-item-72")
    private WebElementFacade cartButton;

    @FindBy(css = ".quantity .input-text")
    private WebElementFacade quantityfield;

    @FindBy(css = "button.button")
    private WebElementFacade updateButton;

    @FindBy(css = ".product-name a")
    private WebElementFacade productNameInCart;

    @FindBy(css = " .product-price .amount")
    private WebElementFacade productPriceInCart;

    @FindBy(css = ".product-subtotal .amount")
    private WebElementFacade cartTotalUp;

    @FindBy(css = " .cart-subtotal .amount")
    private WebElementFacade cartSubtotal;

    @FindBy(css = "a.wc-forward")
    private WebElementFacade checkoutButton;

    @FindBy(css = ".product-remove a")
    private WebElementFacade productRemoveButton;

    @FindBy(css = "[role='alert']")
    private WebElementFacade removedMessageInCart;

    public void changeQuantity(String quantity) {
        waitFor(quantityfield);
        clickOn(quantityfield);
        typeInto(quantityfield, quantity);
    }

    public void clickUpdateCartButton() {
        clickOn(updateButton);
    }

    public boolean checkProductInCart(String productName) {
        waitFor(productNameInCart);
        System.out.println("the product name is: "+productNameInCart.getText());
        return productNameInCart.containsText(productName);
    }

    public void checkQuantityPriceUpdate() {

        String productPrice = productPriceInCart.getText().trim();
        String priceTrim = productPrice.replace("lei", "").replace(".", "");
        int productPriceFin = Integer.valueOf(priceTrim);

        String cartTotal = cartTotalUp.getText().trim();
        String totalPriceTrim = cartTotal.replace("lei", "").replace(".", "");
        int totalPriceFin = Integer.valueOf(totalPriceTrim);

        String subtotalCart = cartSubtotal.getText().trim();
        String subtotalTrim = subtotalCart.replace("lei", "").replace(".", "");
        int subtotalFin = Integer.valueOf(subtotalTrim);

        String quantityBox = quantityfield.getValue();
        int quantityFieldConvert = Integer.valueOf(quantityBox);

        int multipleQtyProduct = productPriceFin * quantityFieldConvert;

        if ((multipleQtyProduct == totalPriceFin) && (multipleQtyProduct == subtotalFin)) {
            waitFor(checkoutButton);
            System.out.println("You better work!");
            clickOn(checkoutButton);
        }
    }

    public void proceedToCheckoutButton() {
        clickOn(checkoutButton);
    }

    public void clickOnProductRemoveButton(){
        clickOn(productRemoveButton);
    }

    public boolean checkProductRemoveMessage(String removedMessage){
        waitFor(removedMessageInCart);
        return removedMessageInCart.containsText(removedMessage);
    }

}
