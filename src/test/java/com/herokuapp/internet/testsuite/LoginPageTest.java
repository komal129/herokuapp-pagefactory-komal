package com.herokuapp.internet.testsuite;

import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.pages.SecureAreaPage;
import com.herokuapp.internet.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// @Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    SecureAreaPage securearea;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        securearea = new SecureAreaPage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void UserShouldLoginSuccessfullyWithValidCredentials(){

        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedText = "Secure Area";
        Assert.assertEquals(securearea.getErrorMessage(), expectedText, "Secure Area text is not displayed");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheUsernameErrorMessage(){
        loginPage.enterUsername("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedUsernameText ="Your username is invalid!\n"+"×";
        Assert.assertEquals(loginPage.getUsernameErrorMessage(), expectedUsernameText, "Username error message is not displayed" );

    }

    @Test(groups = "regression")
    public void verifyThePasswordErrorMessage(){
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        String expectedPasswordMessage ="Your password is invalid!\n"+"×";
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), expectedPasswordMessage, "Password error message is not displayed");
    }

}
