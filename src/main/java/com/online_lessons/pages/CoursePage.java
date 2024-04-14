package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class CoursePage extends BasePage{
    public CoursePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "title")
    WebElement courseTitle;

    @FindBy(id = "price")
    WebElement coursePrice;

    @FindBy(id = "description")
    WebElement courseDescription;

    @FindBy(id = "coverPhoto")
    WebElement uploadPhotoButton;

    public CoursePage enterNewCourseData(String title, int price, String description) {
        type(courseTitle, title);
        type(coursePrice, String.valueOf(price));
        type(courseDescription, description);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return this;
    }

    @FindBy(css = ".edit-course-submit")
    WebElement saveButton;

    public MyCoursesPage clickOnSaveButtonPositive() {
        click(saveButton);
        return new MyCoursesPage(driver);
    }
}
