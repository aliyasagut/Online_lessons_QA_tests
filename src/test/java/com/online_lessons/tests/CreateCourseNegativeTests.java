package com.online_lessons.tests;

import com.online_lessons.fw.DataProviders;
import com.online_lessons.models.Course;
import com.online_lessons.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCourseNegativeTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver)
                .clickOnSignUpButton();
        new SignUpPage(driver)
                .enterSignUpData("newuser", "newuser@gmail.com", "Test1pass!")
                .clickOnSubmitSignUpButton();
        new HomePage(driver).clickOnBurgerMenu().clickOnMyCoursesButton();
        new MyCoursesPage(driver).clickOnMyCreatedCourses();
        new MyCreatedCoursesPage(driver).clickOnCreateNewCourseButton();
    }

    @AfterMethod
    public void postCondition() {
        new CreateCoursePage(driver)
                .clickOnBurgerMenu()
                .clickOnMyAccount();
        new AccountPage(driver)
                .clickOnDeleteAccountButton("Ok");
        new HomePage(driver)
                .verifyPopUpUserDeleted();
    }

    @Test(dataProvider = "createCourseNegativeFromCsv", dataProviderClass = DataProviders.class)
    public void createCourseNegativeTest(Course course) {
        System.out.println(course);
        new CreateCoursePage(driver)
                .enterNewCourseData(course.getTitle(), course.getPrice(), course.getDescription(), course.getPhotoPath())
                .clickOnSaveButtonNegative()
                .verifySaveButtonExists();
    }
}
