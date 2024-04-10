package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "nickname")
    WebElement nicknameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    public SignUpPage enterSignUpData(String nickName, String email, String password) {
        type(nicknameField, nickName);
        type(emailField, email);
        type(passwordField, password);
        return this;
    }

    @FindBy(css = ".submit-reg-button")
    WebElement submitSignUpButton;

    public SignUpPage enterSubmitSignUpButton() {
        click(submitSignUpButton);
        return this;
    }

    @FindBy(css = ".burgerMenu")
    WebElement burgerMenu;

    @FindBy(css = "[href='/']")
    WebElement logOutLink;

    public SignUpPage verifyLogoutButtonPresent() {
        click(burgerMenu);
        Assert.assertTrue(isElementPresent(logOutLink));
        return this;
    }

    @FindBy(css = ".registration-toggle-password")
    WebElement visibilityToggle;

    public SignUpPage clickOnVisibilityToggle() {
        click(visibilityToggle);
        return this;
    }

    @FindBy(css = "[value='Test1pass!']")
    WebElement passwordInputText;

    public SignUpPage verifyPassword(String password) {
        String actualPassword = passwordInputText.getAttribute("value");
        Assert.assertEquals(actualPassword, password);
        return this;
    }

    @FindBy(css = ".terms-policy")
    WebElement termOfUseLink;

    public SignUpPage clickOnTermsOfUseLink(int index) {
        click(termOfUseLink);
        return this;
    }

    @FindBy(css = ".registration-terms-policy")
    WebElement privacyPolicyLink;

    public SignUpPage clickOnPrivacyPolicyLink(int index) {
        click(privacyPolicyLink);
        return this;
    }

    @FindBy(css = "h1")
    WebElement termsText;

    public SignUpPage verifyNewTabText(String text) {
        String actual = termsText.getText();
        Assert.assertTrue(shouldHaveText(termsText, text, 10));
        return this;
    }

    private boolean shouldHaveText(WebElement element, String text, int index) {
        return new WebDriverWait(driver, Duration.ofSeconds(index))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    @FindBy(css = "div.login-link a[href='/log']")
    WebElement logInLink;

    public LogInPage clickOnLoginLink() {
        click(logInLink);
        return new LogInPage(driver);
    }
}