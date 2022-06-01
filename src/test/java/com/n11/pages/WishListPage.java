package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{

    @FindBy(className = "listItemTitle")
    public WebElement favouritesButton;
}
