package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateLessonPage extends BasePage{

    public CreateLessonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "title")
    WebElement titleField;

    @FindBy(id = "content")
    WebElement contentField;

    @FindBy(id = "lessonPhoto")
    WebElement lessonPhotoField;

    public CreateLessonPage enterLessonsData(String title, String content, String photoPath) {
        type(titleField, title);
        type(contentField, content);
        type(lessonPhotoField, photoPath);
        return this;
    }

    @FindBy(css = ".create-lesson-submit")
    WebElement addLessonButton;

    public CreateLessonPage clickAddLessonButton() {
        click(addLessonButton);
        return this;
    }

    @FindBy(xpath = "//button[text()='Submit All Lessons']")
    WebElement submitAllLessonsButton;

    public MyCoursesPage clickSubmitAllLessonsButton() {
        click(submitAllLessonsButton);
        return new MyCoursesPage(driver);
    }
}
