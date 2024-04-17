package com.online_lessons.tests;

import com.online_lessons.pages.AccountPage;
import com.online_lessons.pages.HomePage;
import com.online_lessons.pages.LogInPage;
import com.online_lessons.pages.SignUpPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver)
                .verifySignUpButtonPresent()
                .clickOnSignUpButton();
    }

    @AfterMethod
    public void postCondition() {
        new HomePage(driver)
                .clickOnBurgerMenu()
                .clickOnMyAccountButton();
        new AccountPage(driver)
                .clickOnDeleteAccountButton("Ok");
        new HomePage(driver)
                .verifyPopUpUserDeleted();
    }

    @Test
    public void signUpPositiveTest() {
        new SignUpPage(driver)
                .enterSignUpData("newuser", "newuser@gmail.com", "Test1pass!")
                .clickOnSubmitSignUpButton();
        new HomePage(driver)
                .verifyPopUserSignedUpSuccess();
    }

    @Test
    public void checkVisibilityTogglePositiveTest() {
        new SignUpPage(driver)
                .enterSignUpData("newuser", "newuser@gmail.com", "Test1pass!")
                .clickOnVisibilityToggle()
                .verifyPassword("Test1pass!")
                .clickOnSubmitSignUpButton();
        new HomePage(driver)
                .verifyPopUserSignedUpSuccess();
    }

    @Test
    public void checkLoginLinkRedirection() {
        new SignUpPage(driver)
                .clickOnLoginLink();
        new LogInPage(driver)
                .verifyLoginPageOpened()
                .clickOnSignUpButton();
        new SignUpPage(driver)
                .enterSignUpData("newuser", "newuser@gmail.com", "Test1pass!")
                .clickOnSubmitSignUpButton();
        new HomePage(driver)
                .verifyPopUserSignedUpSuccess();
    }
}
