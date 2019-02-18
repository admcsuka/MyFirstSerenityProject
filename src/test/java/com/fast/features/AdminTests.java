package com.fast.features;

import com.fast.steps.serenity.*;
import com.fast.utils.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AdminTests {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private AdminSteps adminSteps;

    @Steps
    private RegisterSteps registerSteps;

    private String userName = RandomStringUtils.randomAlphanumeric(8);
    private String email = userName + "@mymail.com";

    @Test
    public void checkInAdminAfterReg() {
        registerSteps.navigateToHomePage();
        registerSteps.clickMyAccountButton();
        registerSteps.setEmailField(email);
        registerSteps.setPasswordField(Constants.USER_PASSWORD);
        registerSteps.clickRegisterButton();
        loginSteps.clickLogoutButton();
        loginSteps.setUserEmail(Constants.ADMIN_USERNAME);
        loginSteps.setPassword(Constants.ADMIN_PASSWORD);
        loginSteps.clickOnLoginButton();
        loginSteps.checkLoggedIn("Hello admin");
        adminSteps.selectDashboard();
        adminSteps.clickOnDashboard();
        adminSteps.selectMainMenuCategory("Users");
        adminSteps.clickOnAllUsersButton();
        adminSteps.setUserSearchField(userName);
        adminSteps.clickOnSearchUsersButton();
        adminSteps.checkExistingUser(userName);

    }
}
