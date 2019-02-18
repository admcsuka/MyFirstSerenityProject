package com.fast.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@DefaultUrl("http://qa5.fasttrackit.org:8008/")

public class AdminPage extends PageObject {

    @FindBy(css = "#wp-admin-bar-site-name.menupop")
    private WebElementFacade dashBoardHoverOver;

    @FindBy(css = "#wp-admin-bar-dashboard")
    private WebElementFacade dashBoardButton;

    @FindBy(css = ".wp-menu-name")
    List<WebElementFacade> mainMenuCategories;

    @FindBy(css = ".wp-first-item a[href*=users]")
    private WebElementFacade allUsersButton;

    @FindBy(css = ".username strong a")
    List<WebElementFacade> newUsernames;

    @FindBy(id = "user-search-input")
    private WebElementFacade userSearchField;

    @FindBy(id = "search-submit")
    private WebElementFacade searchUsersButton;

    @FindBy(css = ".wp-first-item a[href*='shop_order']")
    private WebElementFacade ordersButton;

    @FindBy(id = ".order-view strong")
    List<WebElementFacade> ordersList;


    public void selectDashboardHoverOver() {
        Actions action = new Actions(getDriver());
        WebElementFacade e = dashBoardHoverOver;
        action.moveToElement(e).perform();
    }

    public void clickOnDashboard() {
        clickOn(dashBoardButton);
    }

    public boolean selectMainMenuCategory(String categories) {
        Actions action = new Actions(getDriver());
        for (WebElementFacade category : mainMenuCategories) {
            if (category.getText().contains(categories)) {
                WebElementFacade e = category;
                action.moveToElement(e).perform();
                return true;
            }
        }
        return false;
    }

    public void clickOnAllUsersButton() {
        clickOn(allUsersButton);
    }

    public boolean usernameList(String username) {
        for (WebElementFacade userNames : newUsernames) {
            if (userNames.getText().contains(username)) {
                System.out.println("The username exits!");
                return true;
            }
        }
        return false;
    }

    public void setUserSearchField(String username) {
        typeInto(userSearchField, username);
    }

    public void clickOnSearchUsersButton() {
        clickOn(searchUsersButton);
    }

}


