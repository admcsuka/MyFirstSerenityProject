package com.fast.steps.serenity;

import com.fast.pages.AdminPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class AdminSteps extends ScenarioSteps {


    private AdminPage adminPage;

    @Step
    public void selectDashboard() {
        adminPage.selectDashboardHoverOver();
    }

    @Step
    public void clickOnDashboard() {
        adminPage.clickOnDashboard();
    }

    @Step
    public void selectMainMenuCategory(String category) {
        adminPage.selectMainMenuCategory(category);
    }

    @Step
    public void clickOnAllUsersButton(){
        adminPage.clickOnAllUsersButton();
    }

    @Step
    public void checkExistingUser(String username){
        Assert.assertTrue(adminPage.usernameList(username));
    }

    @Step
    public void setUserSearchField(String username){
        adminPage.setUserSearchField(username);
    }

    @Step
    public void clickOnSearchUsersButton(){
        adminPage.clickOnSearchUsersButton();
    }

}
