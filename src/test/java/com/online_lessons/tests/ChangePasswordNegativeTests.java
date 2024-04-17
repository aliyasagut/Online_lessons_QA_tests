package com.online_lessons.tests;

import com.online_lessons.pages.AccountPage;
import com.online_lessons.pages.ChangePasswordPage;
import com.online_lessons.pages.HomePage;
import com.online_lessons.pages.SignUpPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePasswordNegativeTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver)
                .clickOnSignUpButton();
        new SignUpPage(driver)
                .enterSignUpData("newuser", "newuser@gmail.com", "Test1pass!")
                .clickOnSubmitSignUpButton();
    }

    @AfterMethod
    public void postCondition() {
        new ChangePasswordPage(driver)
                .clickOnAccountInfoLink();
        new AccountPage(driver)
                .clickOnDeleteAccountButton("Ok");
        new HomePage(driver)
                .verifyPopUpUserDeleted();
    }

    @Test
    public void changePasswordNegativeTest() {
        new HomePage(driver)
                .clickOnBurgerMenu()
                .clickOnMyAccountButton();
        new AccountPage(driver)
                .clickOnChangePasswordLink();
        new ChangePasswordPage(driver)
                .enterChangePasswordData("Test1pass!", "New11pass!1", "New11pass!")
                .clickSavePasswordButton()
                .verifyPopUpPasswordMismatch();
    }

}
