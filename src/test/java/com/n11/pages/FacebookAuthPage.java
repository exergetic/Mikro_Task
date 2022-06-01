package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FacebookAuthPage extends BasePage {

    public void loginWithFacebook(){
        String currentWindowHandle = Driver.get().getWindowHandle();
        switchToNewWindow(currentWindowHandle);

        WebElement facebookEmailInputBox = Driver.get().findElement(By.xpath("//div[@id='email_container']//input[@id='email']"));
        WebElement facebookPasswordInputBox = Driver.get().findElement(By.xpath("//input[@id='pass']"));

        facebookEmailInputBox.sendKeys("elifulker1521@gmail.com");
        facebookPasswordInputBox.sendKeys("e123456u");

        WebElement facebookLoginButton = Driver.get().findElement(By.xpath("//div[@id='buttons']//input[@name='login']"));
        facebookLoginButton.click();
        }


}
