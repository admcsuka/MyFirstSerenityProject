package com.fast.steps.serenity;

import com.fast.pages.HomePage;
import com.fast.pages.SearchBarPage;
import com.fast.pages.ProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class SearchBarSteps extends ScenarioSteps {


    private HomePage homePage;
    private SearchBarPage searchBarPage;
    private ProductPage productPage;

    @Step
    public void navigateToHomePage() {
        getDriver().manage().window().maximize();
        homePage.open();
    }

    @Step
    public void navigateToSearchBar() {
        searchBarPage.navigateToSearchBar();
    }

    @Step
    public void writeProductName(String productName) {
        searchBarPage.enterProduct(productName);
    }

    @Step
    public void clickSearchBarButton() {
        searchBarPage.clickSearchBarButton();
    }

    @Step
    public void enterSearchTermLength(String searchTerm) {
        searchBarPage.enterSearchTermLength(searchTerm);
    }

    @Step
    public void checkSearchResultForProduct(String productNameResult) {
        Assert.assertTrue(productPage.checkSearchResultForProduct(productNameResult));
    }

    @Step
    public void checkMessageSearchBarNoProductFound() {
        Assert.assertTrue(productPage.checkMessageSearchBarNoProductFound("No products were found matching your selection."));
    }

}
