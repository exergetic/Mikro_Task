package com.n11.step_definitions;

import com.n11.pages.*;
import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class stepDefs {

    FacebookAuthPage facebookAuthPage = new FacebookAuthPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyFavouritesPage myFavouritesPage = new MyFavouritesPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    WishListPage wishListPage = new WishListPage();


    @When("user navigates to homepage")
    public void userNavigatesToHomepage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("verify that the page title is {string}")
    public void verify_that_the_page_title_is(String pageTitle) {
        String actualPageTitle = Driver.get().getTitle();
        String expectedPageTitle = pageTitle;

        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @When("user logs in with Facebook")
    public void user_logs_in_with_Facebook() {
        loginPage.redirectingToFacebookAuth();
        facebookAuthPage.loginWithFacebook();
    }

    @Then("verify that username {string} is visible under My Account")
    public void verify_that_is_visible_under_My_Account(String expectedUsername) {
        String currentWindowHandle = Driver.get().getWindowHandle();
        homePage.switchToNewWindow(currentWindowHandle);
        Assert.assertEquals(expectedUsername, homePage.username.getText());
    }

    @When("user searches for {string}")
    public void user_searches_for(String productName) {
        homePage.searchInputBox.sendKeys(productName);
        homePage.searchButton.click();

    }
    @Then("verify that user sees the results for {string}")
    public void verify_that_user_sees_the_results_for(String searchKeyword) {
        System.out.println(searchResultPage.resultMessage.getText());
        Assert.assertTrue(searchResultPage.resultMessage.getText().startsWith(searchKeyword));
    }

    @When("when user navigates to results page number {string}")
    public void when_user_navigates_to_results_page_number(String pageNumber) {
        WebElement pagination = Driver.get().findElement(By.xpath("//*[.='"+pageNumber+"']"));
        pagination.click();
    }

    @Then("verify that {string} is seen at the end of the page title")
    public void verify_that_is_seen_at_the_end_of_the_page_title(String expectedPageNumber) {
        Assert.assertTrue(Driver.get().getTitle().endsWith(expectedPageNumber));
    }

    @When("user adds the product number {string} on the page to Favourites")
    public void user_adds_the_product_number_on_the_page_to_Favourites(String productNumber) {
        searchResultPage.addingProductToFavourites(productNumber);
    }

    @When("user navigates to {string}")
    public void user_navigates_to(String myAccountSubPageName) {
        searchResultPage.navigateToMyAccountSubPages(myAccountSubPageName);
    }

    @Then("verify that page title starts with {string}")
    public void verify_that_user_is_on_the_page(String expectedPageName) {
        wishListPage.favouritesButton.click();
        Assert.assertTrue(Driver.get().getTitle().startsWith(expectedPageName));
    }

    @When("user deletes the product from the favorites")
    public void user_deletes_the_product_from_the_favorites() {
        myFavouritesPage.deleteFromFavouritesButton.click();
    }

    @Then("verify that {string} message is displayed")
    public void verify_that_the_image_which_shows_the_list_empty_is_visible(String expectedMessage) {
        Assert.assertEquals(expectedMessage, myFavouritesPage.successMessage.getText());
        myFavouritesPage.confirmationButton.click();
    }


}
