package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
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

    public MyCoursesPage selectMyCourses() {
        click(myCoursesLink);
        return new MyCoursesPage(driver);
    }

    @FindBy(css = "[href='/my_account']")
    WebElement myAccountButton;

    public AccountPage clickOnMyAccountButton() {
        click(myAccountButton);
        return new AccountPage(driver);
    }
}
