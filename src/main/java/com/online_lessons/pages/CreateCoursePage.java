package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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
        uploadFile(uploadPhotoButton, photo_path);

        return this;
    }

    @FindBy(css = ".create-course-submit")
    WebElement saveCourseButton;

    public MyCoursesPage clickOnSaveButtonPositive() {
        click(saveCourseButton);
        return new MyCoursesPage(driver);
    }

    public CreateCoursePage clickOnSaveButtonNegative() {
        click(saveCourseButton);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(), 'Please correct the errors before submitting.')]")
    WebElement popUpCourseIsNotCreated;

    public CreateCoursePage verifyPopUpCourseNotCreated() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpCourseIsNotCreated));
        Assert.assertTrue(isElementPresent(popUpCourseIsNotCreated));
        return this;
    }

    public CreateCoursePage verifySaveButtonExists() {
        Assert.assertTrue(isElementPresent(saveCourseButton));
        return this;
    }

    @FindBy(xpath = "//*[.='Home']")
    WebElement homeLink;

    public HomePage clickOnHomeLink() {
        click(homeLink);
        return new HomePage(driver);
    }

    @FindBy(css = ".burgerMenu")
    WebElement burgerMenu;
    
    public CreateCoursePage clickOnBurgerMenu() {
        click(burgerMenu);
        return this;
    }

    @FindBy(css = "[href='/']")
    WebElement logOutLink;

    public HomePage clickOnLogOut() {
        click(logOutLink);
        return new HomePage(driver);
    }

    @FindBy(css = "[href='/my_account']")
    WebElement myAccountButton;

    public AccountPage clickOnMyAccount() {
        click(myAccountButton);
        return new AccountPage(driver);
    }
}
