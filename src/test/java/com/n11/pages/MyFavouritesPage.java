package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyFavouritesPage extends BasePage{

    @FindBy(className = "deleteProFromFavorites")
    public WebElement deleteFromFavouritesButton;

    @FindBy(className = "message")
    public WebElement successMessage;

    @FindBy(xpath = "//span[@class='btn btnBlack confirm']")
    public WebElement confirmationButton;
}
