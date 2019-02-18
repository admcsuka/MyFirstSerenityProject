package com.fast.features;

import com.fast.steps.serenity.LoginSteps;
import com.fast.utils.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTests {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void validLoginTest() {
        loginSteps.navigateToHomepage();
        loginSteps.clickMyAccountButton();
        loginSteps.setUserEmail(Constants.USER_EMAIL);
        loginSteps.setPassword(Constants.USER_PASSWORD);
        loginSteps.clickOnLoginButton();
        loginSteps.checkLoggedIn("Hello csukaadam93");
    }

    @Test
    public void invalidLogin() {
        loginSteps.navigateToHomepage();
        loginSteps.clickMyAccountButton();
        loginSteps.setUserEmail(Constants.USER_EMAIL);
        loginSteps.setPassword(Constants.INVALID_PASSWORD);
        loginSteps.clickOnLoginButton();
        loginSteps.invalidLoginIfStep();
        loginSteps.clickOnLoginButton();

    }

    @Test
    public void loginWithUpperCase(){
        loginSteps.navigateToHomepage();
        loginSteps.clickMyAccountButton();
        loginSteps.setUserEmail("CSUKAADAM93");
        loginSteps.setPassword(Constants.USER_PASSWORD);
        loginSteps.clickOnLoginButton();
        loginSteps.checkLoggedIn("Hello csukaadam93");
    }

    @Test
    public void loginAsAdmin() {
        loginSteps.navigateToHomepage();
        loginSteps.clickMyAccountButton();
        loginSteps.setUserEmail(Constants.ADMIN_USERNAME);
        loginSteps.setPassword(Constants.ADMIN_PASSWORD);
        loginSteps.clickOnLoginButton();
        loginSteps.checkLoggedIn("Hello admin");
    }

}
