package com.online_lessons.tests;

import com.online_lessons.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCoursePositiveTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver)
                .clickOnSignUpButton();
        new SignUpPage(driver)
                .enterSignUpData("newuser", "newuser@gmail.com", "Test1pass!")
                .clickOnSubmitSignUpButton();
        new HomePage(driver)
                .clickOnBurgerMenu()
                .clickOnMyCoursesButton();
        new MyCoursesPage(driver)
                .clickOnMyCreatedCourses();
        new MyCreatedCoursesPage(driver)
                .clickOnCreateNewCourseButton();
    }

    @AfterMethod
    public void postCondition() {
        new MyCoursesPage(driver)
                .clickOnBurgerMenu()
                .clickOnMyAccountButton();
        new AccountPage(driver)
                .clickOnDeleteAccountButton("Ok");
        new HomePage(driver)
                .verifyPopUpUserDeleted();
    }

    @Test
    public void createCoursePositiveTest() {
        new CreateCoursePage(driver)
                .enterNewCourseData("Soft skills course", 99,
                "The Soft Skills: Developing Interpersonal Abilities course offers a unique opportunity for participants to enhance their soft skills, which are deemed crucial for both career success and personal growth. In today's world, where the importance of interpersonal communication, time management, problem-solving, and leadership skills is ever-growing, the ability to effectively apply soft skills becomes paramount to success.",
                        "C:\\Project\\cats.jpg")
                .clickOnSaveButtonPositive();
        new MyCoursesPage(driver)
                .verifyPopUpCourseCreatedSuccessfully();
    }

}
