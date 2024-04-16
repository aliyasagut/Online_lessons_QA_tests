package com.online_lessons.tests;

import com.online_lessons.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAccountPositiveTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver)
                .clickOnSignUpButton();
        new SignUpPage(driver)
                .enterSignUpData("newuser", "newuser@gmail.com", "Test1pass!")
                .clickOnSubmitSignUpButton();
    }

    @Test
    public void deleteAccountTest() {
        new HomePage(driver)
                .clickOnBurgerMenu()
                .clickOnMyAccountButton();
        new AccountPage(driver)
                .clickOnDeleteAccountButton("Ok");
        new HomePage(driver)
                .verifyPopUpUserDeleted();
    }
}
