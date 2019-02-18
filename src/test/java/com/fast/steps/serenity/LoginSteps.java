package com.fast.steps.serenity;

import com.fast.pages.HomePage;
import com.fast.pages.LoginPage;
import com.fast.pages.MyAccountPage;
import com.fast.utils.Constants;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class LoginSteps extends ScenarioSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @Step
    public void navigateToHomepage() {
        getDriver().manage().window().maximize();
        homePage.open();
    }

    @Step
    public void clickMyAccountButton() {
        homePage.clickMyAccountButton();
    }

    @Step
    public void setUserEmail(String email) {
        loginPage.setEmailField(email);
    }

    @Step
    public void setPassword(String password) {
        loginPage.setPasswordField(password);
    }

    @Step
    public void clickOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step
    public void checkLoggedIn(String loginMessage) {
        Assert.assertTrue(myAccountPage.checkLoggedIn(loginMessage));
    }

    @Step
    public void invalidLoginIfStep() {
        loginPage.invalidLoginIfNextStep("ERROR", Constants.USER_PASSWORD);
    }

    @Step
    public void clickLogoutButton() {
        myAccountPage.clickCostumerLogout();
    }

    @StepGroup
    public void login(String loginMessage) {
        navigateToHomepage();
        clickMyAccountButton();
        setUserEmail(Constants.USER_EMAIL);
        setPassword(Constants.USER_PASSWORD);
        clickOnLoginButton();
        checkLoggedIn(loginMessage);
    }

}
