package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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

    public HomePage submitLoginPositive() {
        click(submitLoginButton);
        return new HomePage(driver);
    }

    public LogInPage submitLoginNegative() {
        click(submitLoginButton);
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

    @FindBy(css = ".login-toggle-password")
    WebElement visibilityToggle;

    public LogInPage clickOnVisibilityToggle() {
        click(visibilityToggle);
        return this;
    }

    @FindBy(css = "[value='Test1pass!']")
    WebElement passwordInputText;

    public LogInPage verifyPassword(String password) {
        String actualPassword = passwordInputText.getAttribute("value");
        Assert.assertEquals(actualPassword, password);
        return this;
    }

    @FindBy(xpath = "//div[@class='Toastify__toast-body' and contains(., 'Email and password must not be empty')]")
    WebElement popUpEmptyData;

    public LogInPage verifyPopUpEmptyData() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(popUpEmptyData));
        Assert.assertTrue(popUpEmptyData.getText().contains("Email and password must not be empty"));
        return this;
    }
}
