package com.online_lessons.tests;

import com.online_lessons.fw.DataProviders;
import com.online_lessons.models.User;
import com.online_lessons.pages.HomePage;
import com.online_lessons.pages.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpNegativeTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver)
                .verifySignUpButtonPresent()
                .clickOnSignUpButton();
    }

    @Test(dataProvider = "signUpNegativeFromCsv", dataProviderClass = DataProviders.class)
    public void signUpWithInvalidDataWithCsv(User user) {
        new SignUpPage(driver)
                .enterSignUpData(user.getNickname(), user.getEmail(), user.getPassword())
                .verifyInvalidFormatText("Invalid")
                .clickOnSubmitSignUpButtonNegative()
                .verifyLoginButtonPresent();
    }

    @Test(dataProvider = "signUpWithEmptyFieldsFromCsv", dataProviderClass = DataProviders.class)
    public void signUpWithEmptyFieldsWithCsv(User user) {
        new SignUpPage(driver)
                .enterSignUpData(user.getNickname(), user.getEmail(), user.getPassword())
                .clickOnSubmitSignUpButtonNegative()
                .verifyInvalidFormatText("Invalid");
    }

    @Test
    public void signInWithExistedAccount() {
        new SignUpPage(driver)
                .enterSignUpData("newuser", "newuser@gmail.com", "Test1pass!")
                .clickOnSubmitSignUpButtonNegative()
                .verifyPopUp();
    }
}
