package com.fast.features;

import com.fast.steps.serenity.SearchBarSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchBarTests {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private SearchBarSteps searchBarSteps;

    private String searchTerm = RandomStringUtils.randomAlphabetic(22);

    @Test
    public void searchByProductName(){
        searchBarSteps.navigateToHomePage();
        searchBarSteps.navigateToSearchBar();
        searchBarSteps.writeProductName("wordpress pennant");
        searchBarSteps.clickSearchBarButton();
        searchBarSteps.checkSearchResultForProduct("WordPress Pennant");
    }

    @Test
    public void searchWithRandomString(){
        searchBarSteps.navigateToHomePage();
        searchBarSteps.navigateToSearchBar();
        searchBarSteps.enterSearchTermLength(searchTerm);
        searchBarSteps.clickSearchBarButton();
        searchBarSteps.checkMessageSearchBarNoProductFound();
    }

    @Test
    public void searchWithAllCaps(){
        searchBarSteps.navigateToHomePage();
        searchBarSteps.navigateToSearchBar();
        searchBarSteps.writeProductName("BELT");
        searchBarSteps.clickSearchBarButton();
        searchBarSteps.checkSearchResultForProduct("Belt");
    }

    @Test
    public void searchWithMixedLetters(){
        searchBarSteps.navigateToHomePage();
        searchBarSteps.navigateToSearchBar();
        searchBarSteps.writeProductName("HooDIE witH zIPPeR");
        searchBarSteps.clickSearchBarButton();
        searchBarSteps.checkSearchResultForProduct("Hoodie with Zipper");
    }
}
