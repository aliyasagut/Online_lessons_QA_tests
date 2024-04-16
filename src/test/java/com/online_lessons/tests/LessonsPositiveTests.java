package com.online_lessons.tests;

import com.online_lessons.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LessonsPositiveTests extends TestBase{

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
                        "The Soft Skills: Developing Interpersonal Abilities course offers a unique opportunity for participants to enhance their soft skills, which are deemed crucial for both career success and personal growth. In today's world, where the importance of interpersonal communication, time management, problem-solving, and leadership skills is ever-growing, the ability to effectively apply soft skills becomes paramount to success.",
                        "C:\\Project\\cats.jpg")
                .clickOnSaveButtonPositive();
    }

    @AfterMethod
    public void postCondition() {
        new MyCoursesPage(driver)
                .clickOnBurgerMenu()
                .clickOnMyAccountButton();
        new AccountPage(driver)
                .clickOnDeleteAccountButton("Ok");
        new HomePage(driver)
                .verifySignUpButtonPresent();
    }

    @Test
    public void addLessonPositiveTest() {
        new MyCoursesPage(driver)
                .clickOnMyCreatedCourses();
        new MyCreatedCoursesPage(driver)
                .clickAddLessonButton();
        new CreateLessonPage(driver)
                .enterLessonsData("Lesson 1: Effective Communication in the Workplace",
                        "In this Soft Skills course, you'll learn the art of effective communication in the workplace. From mastering the art of active listening to delivering impactful presentations, this course covers essential communication techniques that are vital for success in any professional environment. Through practical exercises and real-world examples, you'll develop the skills needed to express your ideas clearly, resolve conflicts constructively, and build strong professional relationships. Whether you're a seasoned professional or just starting your career journey, this course will empower you to communicate with confidence and clarity in any situation.",
                        "C:\\Project\\lesson1.png")
                .clickAddLessonButton()
                .enterLessonsData("Lesson 2: Building Strong Interpersonal Relationships",
                        "In this Soft Skills course, we explore the importance of building strong interpersonal relationships. From understanding non-verbal cues to fostering empathy and trust, this course delves into the key components of successful relationships both in the workplace and beyond. Through interactive activities and practical scenarios, you'll learn how to navigate diverse personalities, communicate effectively, and resolve conflicts diplomatically. By mastering the art of relationship-building, you'll enhance your professional network, boost team collaboration, and create a positive work environment conducive to growth and success.",
                        "C:\\Project\\lesson2.jpg")
                .clickAddLessonButton()
                .enterLessonsData("Lesson 3: Effective Communication Strategies",
                        "Welcome to the third lesson of the Soft Skills course: Effective Communication Strategies. In this module, we'll delve into the intricacies of communication and discover how to convey messages with clarity and impact. From active listening techniques to choosing the appropriate communication channels, you'll learn how to articulate your ideas effectively and understand the perspectives of others. Through practical exercises and real-world examples, you'll enhance your verbal and written communication skills, build rapport with colleagues and clients, and navigate challenging conversations with confidence. By mastering effective communication strategies, you'll become a more persuasive and influential communicator in both personal and professional contexts.",
                        "C:\\Project\\lesson2.jpg")
                .clickAddLessonButton()
                .clickSubmitAllLessonsButton();
    }


}
