package com.online_lessons.tests;

import com.online_lessons.pages.AccountPage;
import com.online_lessons.pages.HomePage;
import com.online_lessons.pages.LogInPage;
import com.online_lessons.pages.SignUpPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver)
                .clickOnSignUpButton();
        new SignUpPage(driver)
                .enterSignUpData("newuser", "newuser@gmail.com", "Test1pass!")
                .clickOnSubmitSignUpButton()
                .clickOnBurgerMenu()
                .clickOnLogOutButton();
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
    public void logInPositiveTest() {
        new HomePage(driver)
                .clickOnLoginButton();
        new LogInPage(driver)
                .enterLogInData("newuser@gmail.com", "Test1pass!")
                .clickOnVisibilityToggle()
                .verifyPassword("Test1pass!")
                .submitLoginPositive();
        new HomePage(driver)
                .verifyPopUpLoginSuccessful();
    }
}
