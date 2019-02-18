package com.fast.steps.serenity;

import com.fast.pages.HomePage;
import com.fast.pages.MyAccountPage;
import com.fast.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class RegisterSteps extends ScenarioSteps {

    private HomePage homePage;
    private RegisterPage registerPage;
    private MyAccountPage myAccountPage;

    @Step
    public void navigateToHomePage() {
        getDriver().manage().window().maximize();
        homePage.open();
    }

    @Step
    public void clickMyAccountButton() {
        homePage.clickMyAccountButton();
    }

    @Step
    public void setEmailField(String email) {
        registerPage.setRegisterEmailField(email);
    }

    @Step
    public void setPasswordField(String password) {
        registerPage.setRegisterPasswordField(password);
    }

    @Step
    public void clickRegisterButton() {
        registerPage.clickOnRegisterButton();
    }

    @Step
    public void checkRegistration(String userName) {
        Assert.assertTrue(myAccountPage.checkRegister(userName));
    }

    @Step
    public void  checkWeakPasswordAlert(){
        Assert.assertTrue(registerPage.checkWeakPasswordAlert("Weak"));
    }

}
