package com.online_lessons.tests;

import com.online_lessons.pages.HomePage;
import com.online_lessons.pages.LogInPage;
import com.online_lessons.pages.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).verifySignUpButtonPresent()
                .clickOnSignUpButton();
    }

    @Test
    public void signUpPositiveTest() {
        new SignUpPage(driver).enterSignUpData("newuser2", "newuser2@gmail.com", "Test1pass!")
                .enterSubmitSignUpButton()
                .verifyLogoutButtonPresent();
    }

    @Test
    public void checkVisibilityTogglePositiveTest() {
        new SignUpPage(driver).enterSignUpData("newuser2", "newuser2@gmail.com", "Test1pass!")
                .clickOnVisibilityToggle()
                .verifyPassword("Test1pass!");
    }

    @Test
    public void checkTermOfUseLink() {
        new SignUpPage(driver).enterSignUpData("newuser2", "newuser2@gmail.com", "Test1pass!")
                .clickOnTermsOfUseLink(1)
                .verifyNewTabText("Terms of service");
    }

    @Test
    public void checkPrivacyPolicyLink() {
        new SignUpPage(driver).enterSignUpData("newuser2", "newuser2@gmail.com", "Test1pass!")
                .clickOnPrivacyPolicyLink(1)
                .verifyNewTabText("Privacy policy");
    }

    @Test
    public void checkLoginLinkRedirection() {
        new SignUpPage(driver).clickOnLoginLink();
        new LogInPage(driver).verifyLoginPageOpened();
    }
}
