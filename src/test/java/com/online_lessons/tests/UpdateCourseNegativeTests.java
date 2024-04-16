package com.online_lessons.tests;

import com.online_lessons.fw.DataProviders;
import com.online_lessons.models.Course;
import com.online_lessons.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateCourseNegativeTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver)
                .clickOnLoginButton();
        new LogInPage(driver)
                .enterLogInData("newuser@gmail.com", "Test1pass!")
                .submitLoginPositive();
        new HomePage(driver)
                .clickOnBurgerMenu()
                .clickOnMyCoursesButton();
        new MyCoursesPage(driver)
                .clickOnMyCreatedCourses();
        new MyCreatedCoursesPage(driver)
                .clickOnCreateNewCourseButton();
        new CreateCoursePage(driver)
                .enterNewCourseData("Soft skills course", 99,
                        "The Soft Skills: Developing Interpersonal Abilities course offers a unique opportunity for participants to enhance their soft skills, " +
                                "which are deemed crucial for both career success and personal growth. In today's world, where the importance of interpersonal " +
                                "communication, time management, problem-solving, and leadership skills is ever-growing, the ability to effectively apply soft " +
                                "skills becomes paramount to success.", "C:\\Project\\cats.jpg")
                .clickOnSaveButtonPositive();
        new MyCoursesPage(driver)
                .clickOnMyCreatedCourses();
    }

    @Test(dataProvider = "updateCourseNegativeFromCsv", dataProviderClass = DataProviders.class)
    public void updateCourseNegativeWithCsv(Course course) {
        new MyCreatedCoursesPage(driver)
                .clickOnEditCourseCard();
        new CoursePage(driver)
                .enterNewCourseData(course.getTitle(), course.getPrice(), course.getDescription())
                .clickOnSaveButtonPositive();
        new MyCoursesPage(driver)
                .verifyPopUpCourseUpdatedNegative();
    }
}

