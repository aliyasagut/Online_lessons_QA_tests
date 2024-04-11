package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LogInPage extends BasePage{
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    public LogInPage enterLogInData(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        return this;
    }

    @FindBy(css = ".submit-log-button")
    WebElement submitLoginButton;

    public LogInPage submitLogin() {
        click(submitLoginButton);
        return this;
    }

    @FindBy(css = ".burgerMenu")
    WebElement burgerMenu;

    @FindBy(css = "[href='/']")
    WebElement logOutLink;

    public LogInPage verifyLogOutButtonPresent() {
        click(burgerMenu);
        Assert.assertTrue(isElementPresent(logOutLink));
        return this;
    }

    public LogInPage verifyLoginPageOpened() {
        Assert.assertTrue(isElementPresent(submitLoginButton));
        return this;
    }

    @FindBy(css = ".signUpBtn")
    WebElement signUpButton;

    public SignUpPage clickOnSignUpButton() {
        click(signUpButton);
        return new SignUpPage(driver);
    }
}
