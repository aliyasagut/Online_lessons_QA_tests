package com.online_lessons.tests;

import com.online_lessons.fw.DataProviders;
import com.online_lessons.models.Course;
import com.online_lessons.pages.*;
import org.testng.annotations.*;

public class UpdateCoursePositiveTests extends TestBase {

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

    @Test(dataProvider = "updateCoursePositiveFromCsv", dataProviderClass = DataProviders.class)
    public void updateCourseTitleField(Course course) {
        new MyCreatedCoursesPage(driver)
                .clickOnEditCourseCard();
        new CoursePage(driver)
                .enterNewCourseData(course.getTitle(), course.getPrice(), course.getDescription())
                .clickOnSaveButtonPositive();
        new MyCoursesPage(driver)
                .verifyPopUpCourseUpdatedPositive();
    }

}
