package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SecureAreaPage extends Utility {

 //   By errorMessage = By.xpath("//div[@class = 'example']/h2[contains(text(), 'Secure Area')]");
     @CacheLookup
    @FindBy(xpath = "//div[@class = 'example']/h2[contains(text(), 'Secure Area')]")
    WebElement errorMessage;

    public SecureAreaPage() {
        PageFactory.initElements(driver, this);
    }

    public String getErrorMessage(){
        Reporter.log("Error message is displayed");
        return getTextFromElement(errorMessage);
    }
}
