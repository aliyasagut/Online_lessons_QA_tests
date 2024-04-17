package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ChangePasswordPage extends BasePage{
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldPassword")
    WebElement oldPasswordInput;

    @FindBy(id = "newPassword")
    WebElement newPasswordInput;

    @FindBy(id = "confrimNewPassword")
    WebElement confrimNewPasswordInput;

    public ChangePasswordPage enterChangePasswordData(String oldPassword, String newPassword, String confirmPassword) {
        type(oldPasswordInput, oldPassword);
        type(newPasswordInput, newPassword);
        type(confrimNewPasswordInput, confirmPassword);
        return this;
    }

    @FindBy(id = "save-btn")
    WebElement savePasswordButton;

    public ChangePasswordPage clickSavePasswordButton() {
        click(savePasswordButton);
        return this;
    }

    @FindBy(xpath = "//button[text()='Account info']")
    WebElement accountInfoLink;

    public AccountPage clickOnAccountInfoLink() {
        click(accountInfoLink);
        return new AccountPage(driver);
    }

    @FindBy(xpath = "//div[contains(text(), 'Password changed successfully')]")
    WebElement popUpPasswordChangedSuccessfully;

    public ChangePasswordPage verifyPopUpPasswordChangedSuccessfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpPasswordChangedSuccessfully));
        Assert.assertTrue(isElementPresent(popUpPasswordChangedSuccessfully));
        return this;
    }

    @FindBy(xpath = "//div[contains(text(), 'New password and confirm password mismatch')]")
    WebElement popUpPasswordMismatch;

    public ChangePasswordPage verifyPopUpPasswordMismatch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(popUpPasswordMismatch));
        Assert.assertTrue(isElementPresent(popUpPasswordMismatch));
        return this;
    }
}
