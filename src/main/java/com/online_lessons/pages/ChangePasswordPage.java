package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    @FindBy(id = "success")
    WebElement confirmText;

    public ChangePasswordPage verifyConfirmText() {
        Assert.assertTrue(isElementPresent(confirmText));
        return this;
    }

    @FindBy(xpath = "//button[text()='Account info']")
    WebElement accountInfoLink;

    public AccountPage clickOnAccountInfoLink() {
        click(accountInfoLink);
        return new AccountPage(driver);
    }
}
