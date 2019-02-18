package com.fast.features;

import com.fast.steps.serenity.AdminSteps;
import com.fast.steps.serenity.LoginSteps;
import com.fast.steps.serenity.RegisterSteps;
import com.fast.utils.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RegisterTests {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private RegisterSteps registerSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private AdminSteps adminSteps;

    private String userName = RandomStringUtils.randomAlphanumeric(8);
    private String email = userName + "@mymail.com";

    @Test
    public void validRegister() {
        registerSteps.navigateToHomePage();
        registerSteps.clickMyAccountButton();
        registerSteps.setEmailField(email);
        registerSteps.setPasswordField(Constants.USER_PASSWORD);
        registerSteps.clickRegisterButton();
        registerSteps.checkRegistration(userName);

    }

    @Test
    public void invalidRegister() {
        registerSteps.navigateToHomePage();
        registerSteps.clickMyAccountButton();
        registerSteps.setEmailField(email);
        registerSteps.setPasswordField(Constants.INVALID_PASSWORD);
        registerSteps.checkWeakPasswordAlert();
    }

}
