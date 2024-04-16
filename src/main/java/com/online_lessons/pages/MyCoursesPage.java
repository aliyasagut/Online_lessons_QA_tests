package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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

    @FindBy(xpath = "//div[contains(text(), 'Course updated successfully')]")
    WebElement popUpCourseUpdatedPositive;

    public MyCoursesPage verifyPopUpCourseUpdatedPositive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpCourseUpdatedPositive));
        Assert.assertTrue(isElementPresent(popUpCourseUpdatedPositive));
        return this;
    }

    @FindBy(xpath = "//div[contains(text(), 'Please correct the errors before submitting.')]")
    WebElement popUpCourseUpdatedNegative;

    public MyCoursesPage verifyPopUpCourseUpdatedNegative() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpCourseUpdatedNegative));
        Assert.assertTrue(isElementPresent(popUpCourseUpdatedNegative));
        return this;
    }

    @FindBy(xpath = "//div[contains(text(), 'Course created successfully')]")
    WebElement popUpCourseCreatedSuccessfully;

    public MyCoursesPage verifyPopUpCourseCreatedSuccessfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpCourseCreatedSuccessfully));
        Assert.assertTrue(isElementPresent(popUpCourseCreatedSuccessfully));

        return this;
    }

    @FindBy(css = ".burgerMenu")
    WebElement burgerMenu;

    public MyCoursesPage clickOnBurgerMenu() {
        click(burgerMenu);
        return this;
    }

    @FindBy(css = "[href='/my_account']")
    WebElement myAccountButton;

    public AccountPage clickOnMyAccountButton() {
        click(myAccountButton);
        return new AccountPage(driver);
    }
}
