package com.online_lessons.tests;

import com.online_lessons.pages.HomePage;
import com.online_lessons.pages.LogInPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).verifyLoginButtonPresent()
                .clickOnLoginButton();
    }


    @Test
    public void logInPositiveTest() {
        new LogInPage(driver).enterLogInData("newuser@gmail.com", "Test1pass!")
                .submitLogin()
                .verifyLogOutButtonPresent();
    }
}
