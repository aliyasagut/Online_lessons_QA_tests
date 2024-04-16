package com.online_lessons.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "delete-btn")
    WebElement deleteAccountButton;

    public HomePage clickOnDeleteAccountButton(String confirm) {
        click(deleteAccountButton);
        if (confirm != null && confirm.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (confirm != null && confirm.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return new HomePage(driver);
    }

    @FindBy(xpath = "//button[text()='Change password']")
    WebElement changePasswordButton;

    public ChangePasswordPage clickOnChangePasswordLink() {
        click(changePasswordButton);
        return new ChangePasswordPage(driver);
    }
}
