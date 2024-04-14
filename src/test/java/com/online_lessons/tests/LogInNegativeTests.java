package com.online_lessons.tests;

import com.online_lessons.pages.HomePage;
import com.online_lessons.pages.LogInPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInNegativeTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).verifyLoginButtonPresent()
                .clickOnLoginButton();
    }

    @Test
    public void logWithEmptyEmailNegative() {
        new LogInPage(driver).enterLogInData("", "Test1pass!")
                .submitLoginNegative()
                .verifyPopUpEmptyData();
    }
}
