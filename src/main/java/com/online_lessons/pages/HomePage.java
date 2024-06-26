package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".loginBtn")
    WebElement logInButton;

    public LogInPage clickOnLoginButton() {
        click(logInButton);
        return new LogInPage(driver);
    }

    public HomePage verifyLoginButtonPresent() {
        isElementPresent(logInButton);
        return this;
    }

    @FindBy(css = ".signUpBtn")
    WebElement signUpButton;

    public SignUpPage clickOnSignUpButton() {
        click(signUpButton);
        return new SignUpPage(driver);
    }

    public HomePage verifySignUpButtonPresent() {
        isElementPresent(signUpButton);
        return this;
    }

    @FindBy(css = ".burgerMenu")
    WebElement burgerMenu;

    public HomePage clickOnBurgerMenu() {
        click(burgerMenu);
        return this;
    }

    @FindBy(css = "[href='/my_courses']")
    WebElement myCoursesLink;

    public MyCoursesPage clickOnMyCoursesButton() {
        click(myCoursesLink);
        return new MyCoursesPage(driver);
    }

    @FindBy(css = "[href='/my_account']")
    WebElement myAccountButton;

    public AccountPage clickOnMyAccountButton() {
        click(myAccountButton);
        return new AccountPage(driver);
    }

    @FindBy(xpath = "//div[@class='burgerMenuContent show']/a[3]")
    WebElement logOutLink;

    public HomePage verifyLogOutButtonPresent() {
        click(burgerMenu);
        Assert.assertTrue(isElementPresent(logOutLink));
        return this;
    }

    public HomePage clickOnLogOutButton() {
        click(logOutLink);
        return this;
    }

    @FindBy(xpath = "//div[@class='Toastify__toast-body' and contains(., 'You logged out.')]")
    WebElement popUpUserLogin;

    public HomePage verifyPopUpUserLoggedOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpUserLogin));
        Assert.assertTrue(isElementPresent(popUpUserLogin));
        return this;
    }

    @FindBy(xpath = "//div[@class='Toastify__toast-body' and contains(., 'User newuser deleted')]")
    WebElement popUpUserDeleted;

    public HomePage verifyPopUpUserDeleted() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpUserDeleted));
        Assert.assertTrue(isElementPresent(popUpUserDeleted));
        return this;
    }

    public HomePage verifyLogoutButtonPresent() {
        return this;
    }


    @FindBy(xpath = "//div[@class='Toastify__toast-body' and contains(., 'You logged in.')]")
    WebElement popUpLoginSuccessful;

    public HomePage verifyPopUpLoginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpLoginSuccessful));
        Assert.assertTrue(isElementPresent(popUpLoginSuccessful));
        return this;
    }

    @FindBy(xpath = "//div[@class='Toastify__toast-body' and contains(., 'Account has been created and you are logged in.')]")
    WebElement popUpSignupSuccessful;

    public HomePage verifyPopUserSignedUpSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpSignupSuccessful));
        Assert.assertTrue(isElementPresent(popUpSignupSuccessful));
        return this;
    }
}

