package com.fast.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")
public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElementFacade emailField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(css = ".login p.form-row button")
    private WebElementFacade loginButton;

    @FindBy(css = ".woocommerce-error li " )
    private WebElementFacade invalidLoginMessage;

    public void setEmailField(String email){
        waitFor(emailField);
        typeInto(emailField,email);
    }

    public void setPasswordField(String password){
        typeInto(passwordField, password);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }

    public boolean invalidLoginIfNextStep(String errorMessage, String password){
        waitFor(invalidLoginMessage);
        System.out.println(invalidLoginMessage.getText());
        if (invalidLoginMessage.getText().contains(errorMessage)){
            typeInto(passwordField,password);
            return true;
        }
        return false;
    }


}

