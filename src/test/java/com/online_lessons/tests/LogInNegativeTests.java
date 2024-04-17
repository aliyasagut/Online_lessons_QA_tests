package com.online_lessons.tests;

import com.online_lessons.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInNegativeTests extends TestBase{

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
        new LogInPage(driver)
                .enterLogInData("newuser@gmail.com", "Test1pass!")
                .submitLoginPositive();
        new HomePage(driver)
                .clickOnBurgerMenu()
                .clickOnMyAccountButton();
        new AccountPage(driver)
                .clickOnDeleteAccountButton("Ok");
        new HomePage(driver)
                .verifyPopUpUserDeleted();
    }

    @Test
    public void logWithEmptyEmailNegative() {
        new HomePage(driver)
                .clickOnLoginButton();
        new LogInPage(driver)
                .enterLogInData("", "Test1pass!")
                .submitLoginNegative()
                .verifyPopUpEmptyData();
    }

    @Test
    public void logWithEmptyPasswordNegative() {
        new HomePage(driver)
                .clickOnLoginButton();
        new LogInPage(driver)
                .enterLogInData("newuser@gmail.com", "")
                .submitLoginNegative()
                .verifyPopUpEmptyData();
    }
}
