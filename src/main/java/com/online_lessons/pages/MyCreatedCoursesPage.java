package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCreatedCoursesPage extends BasePage{
    public MyCreatedCoursesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".create-course-button")
    WebElement createNewCourseButton;

    public MyCreatedCoursesPage clickOnCreateNewCourseButton() {
        click(createNewCourseButton);
        return this;
    }
}
