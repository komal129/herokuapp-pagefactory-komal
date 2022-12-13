package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name = "username")
    WebElement userNameField;
    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement loginButton;


    @CacheLookup
    @FindBy(xpath = "//div/div[@id='flash']")
            WebElement usernameErrorMessage;

   @CacheLookup
    @FindBy(xpath = "//div/div[@id='flash']")
    WebElement passwordErrorMessage;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String email){
        Reporter.log("Enter username " + email + " to email field " + userNameField.toString());
        sendTextToElement(userNameField, email);
    }

    public void enterPassword(String password){
        Reporter.log("Enter password " + password + " to password field " + password.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton(){
        Reporter.log("User clicks on Log In Button");
        clickOnElement(loginButton);
    }

    public String getUsernameErrorMessage(){
        Reporter.log("User gets error message");
        return getTextFromElement(usernameErrorMessage);
    }

    public String getPasswordErrorMessage(){
        Reporter.log("User gets error message");
        return getTextFromElement(passwordErrorMessage);
    }
}
