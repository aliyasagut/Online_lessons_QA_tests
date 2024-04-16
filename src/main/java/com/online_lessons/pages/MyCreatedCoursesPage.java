package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MyCreatedCoursesPage extends BasePage{
    public MyCreatedCoursesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".create-course-button")
    WebElement createNewCourseButton;

    public CreateCoursePage clickOnCreateNewCourseButton() {
        click(createNewCourseButton);
        return new CreateCoursePage(driver);
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

    @FindBy(xpath = "//div[contains(text(), 'Course deleted successfully.')]")
    WebElement popUpCourseDeleted;

    public MyCreatedCoursesPage verifyPopUpCourseDeleted() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpCourseDeleted));
        Assert.assertTrue(isElementPresent(popUpCourseDeleted));
        return this;
    }

    @FindBy(css = ".add-button")
    WebElement addLessonButton;

    public CreateLessonPage clickAddLessonButton() {
        click(addLessonButton);
        return new CreateLessonPage(driver);
    }
}
