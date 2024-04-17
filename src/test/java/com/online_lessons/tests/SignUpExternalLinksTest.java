package com.online_lessons.tests;

import com.online_lessons.pages.HomePage;
import com.online_lessons.pages.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpExternalLinksTest extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver)
                .clickOnSignUpButton();
    }

    @Test
    public void checkTermOfUseLink() {
        new SignUpPage(driver)
                .enterSignUpData("newuser", "newuser@gmail.com", "Test1pass!")
                .clickOnTermsOfUseLink(1)
                .verifyNewTabText("Terms of service");
    }

    @Test
    public void checkPrivacyPolicyLink() {
        new SignUpPage(driver)
                .enterSignUpData("newuser1", "newuser1@gmail.com", "Test1pass!")
                .clickOnPrivacyPolicyLink(1)
                .verifyNewTabText("Privacy policy");
    }

}
