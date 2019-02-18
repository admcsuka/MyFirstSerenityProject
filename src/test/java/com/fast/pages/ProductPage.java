package com.fast.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


import java.util.List;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?post_type=product")
public class ProductPage extends PageObject {

    @FindBy(id = "menu-item-73")
    private WebElementFacade shopButton;

    @FindBy(css = ".collection_title h3")
    List<WebElementFacade> listOfProducts;

    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade addToCart;

    @FindBy(css = ".summary h1")
    private WebElementFacade searchResultProduct;

    @FindBy(css = "div.content-inner p")
    private WebElementFacade noSearchResultMessage;

    @FindBy(css = ".input-text.qty.text")
    private WebElementFacade quantityBoxInProduct;

    public boolean selectProductFromList(String productName){
        for (WebElementFacade product : listOfProducts){
            if (product.getText().contains(productName)){
                clickOn(product);
                return true;
            }
        }
        return false;
    }

    public boolean findProductFromListWithIf(String nonExistent, String existingProduct){
        for (WebElementFacade product : listOfProducts){
            if (product.getText().contains(nonExistent)){
                clickOn(product);
                return true;
            }else if (product.getText().contains(existingProduct)){
                clickOn(product);
                return true;
            }
        }
        return false;
    }

    public void clickAddToCart(){
        clickOn(addToCart);
    }

    public boolean checkSearchResultForProduct(String productName) {
        waitFor(searchResultProduct);
        return searchResultProduct.containsText(productName);
    }

    public boolean checkMessageSearchBarNoProductFound(String errorMessage){
        waitFor(noSearchResultMessage);
        System.out.println(noSearchResultMessage.getText());
        return noSearchResultMessage.containsText(errorMessage);
    }

    public void setQuantityBoxInProduct(String quantity){
        typeInto(quantityBoxInProduct,quantity);
    }


}
