package com.n11.pages;

import com.n11.utilities.BrowserUtils;
import com.n11.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//a[@class='menuLink user']")
    public WebElement username;

    @FindBy(id = "searchData")
    public WebElement searchInputBox;

    @FindBy(className = "searchBtn")
    public WebElement searchButton;

    @FindBy(className = "logoutBtn")
    public WebElement logOutButton;

    public void navigateToMyAccountSubPages(String subPageName){
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(username).perform();
        WebDriverWait wait = new WebDriverWait(Driver.get(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(Driver.get().findElement(By.linkText(subPageName))));
        WebElement myAccountSubPage = Driver.get().findElement(By.linkText(subPageName));
        myAccountSubPage.click();

    }




    public void switchToNewWindow(String currentWindowHandle){
        for (String windowHandle : Driver.get().getWindowHandles()) {
            if(!windowHandle.equals(currentWindowHandle)){
                Driver.get().switchTo().window(windowHandle);
            }
        }
    }

}
