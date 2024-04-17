package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    public HomePage clickOnSubmitSignUpButton() {
        click(submitSignUpButton);
        return new HomePage(driver);
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

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));

        return this;
    }

    @FindBy(css = ".registration-terms-policy")
    WebElement privacyPolicyLink;

    public SignUpPage clickOnPrivacyPolicyLink(int index) {
        click(privacyPolicyLink);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));

        return this;
    }

    @FindBy(css = "h1")
    WebElement termsText;

    public SignUpPage verifyNewTabText(String text) {
        Assert.assertTrue(termsText.getText().contains(text));
        return this;
    }

    @FindBy(css = "div.login-link a[href='/log']")
    WebElement logInLink;

    public LogInPage clickOnLoginLink() {
        click(logInLink);
        return new LogInPage(driver);
    }

    @FindBy(css = ".registration-error-message")
    WebElement invalidFormatText;

    public SignUpPage verifyInvalidFormatText(String text) {
        String actual = invalidFormatText.getText();
        Assert.assertTrue(actual.contains(text));
        return this;
    }

    @FindBy(css = ".loginBtn")
    WebElement logInButton;

    public SignUpPage verifyLoginButtonPresent() {
        Assert.assertTrue(isElementPresent(logInButton)); 
        return this;
    }

    @FindBy(xpath = "//div[@class='Toastify__toast-body' and contains(., 'This nickname is already taken')]")
    WebElement popUpUserExists;

    public SignUpPage verifyPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpUserExists));
        Assert.assertTrue(isElementPresent(popUpUserExists));
        return this;
    }

    public SignUpPage clickOnSubmitSignUpButtonNegative() {
        click(submitSignUpButton);
        return this;
    }
}
