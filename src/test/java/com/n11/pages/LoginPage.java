package com.n11.pages;


import com.n11.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{



    public void redirectingToFacebookAuth(){
        WebElement signInButton = Driver.get().findElement(By.className("btnSignIn"));
        signInButton.click();

        WebElement facebookLoginRedirect = Driver.get().findElement(By.xpath("//div[starts-with(@class,'facebook')]"));
        facebookLoginRedirect.click();
    }




}
