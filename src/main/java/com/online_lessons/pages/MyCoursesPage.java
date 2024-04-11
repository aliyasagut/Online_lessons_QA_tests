package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCoursesPage extends BasePage{
    public MyCoursesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[.='My Created Courses']")
    WebElement myCreatedCoursesLink;

    public MyCreatedCoursesPage clickOnMyCreatedCourses() {
        click(myCreatedCoursesLink);
        return new MyCreatedCoursesPage(driver);
    }
}
