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

    @FindBy(css = ".edit-button")
    WebElement editCourseButton;

    public CoursePage clickOnEditCourseCard() {
        click(editCourseButton);
        return new CoursePage(driver);
    }

    @FindBy(css = ".delete-button")
    WebElement deleteCourseButton;

    public MyCreatedCoursesPage clickOnDeleteButton(String confirm) {
        click(deleteCourseButton);
        if (confirm != null && confirm.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (confirm != null && confirm.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }
}
