package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    public CoursePage clickOnSaveButtonNegative() {
        click(saveButton);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(), 'Please correct the errors before submitting.')]")
    WebElement popUpIncorrectFields;

    public CoursePage verifyPopUpIncorrectFields() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpIncorrectFields));
        Assert.assertTrue(isElementPresent(popUpIncorrectFields));
        return this;
    }

    @FindBy(css = ".burgerMenu")
    WebElement burgerMenu;

    public CoursePage clickOnBurgerMenu() {
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
