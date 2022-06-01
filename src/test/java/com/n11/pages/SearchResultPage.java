package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{

    @FindBy(className = "resultText")
    public WebElement resultMessage;

    public void addingProductToFavourites(String productNumber){
        WebElement addToFavourites = Driver.get().findElement(By.xpath("(//span[@title='Favorilere ekle'])["+productNumber+"]"));
        addToFavourites.click();
    }
}
