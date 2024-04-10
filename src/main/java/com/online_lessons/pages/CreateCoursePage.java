package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCoursePage extends BasePage{
    public CreateCoursePage(WebDriver driver) {
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

    public CreateCoursePage enterNewCourseData(String title, int price, String description, String photo_path) {
        type(courseTitle, title);
        type(coursePrice, String.valueOf(price));
        type(courseDescription, description);

        uploadFile(photo_path);

        return this;
    }

    public void uploadFile(String filePath) {
        uploadPhotoButton.sendKeys(filePath);
    }

    @FindBy(css = ".create-course-submit")
    WebElement saveCourseButton;

    public CreateCoursePage clickOnSaveButton() {
        click(saveCourseButton);
        return this;
    }
}
