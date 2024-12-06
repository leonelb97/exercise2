package org.example.screens;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.example.BaseTest.page;

public class LoginPage {

    private final String usernameField = "input[formcontrolname='email']";
    private final String passwordField = "input[formcontrolname='password']";
    private final String submitButton = "button[type='submit']";

    public LoginPage() {

    }

    public LoginPage navigateToLoginPage() {
        page.navigate("https://club-administration.qa.qubika.com/#/auth/login");
        return this;
    }

    public LoginPage enterUsername(String username) {
        page.fill(usernameField, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        page.fill(passwordField, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        page.click(submitButton);
        return this;
    }

    public boolean isOnDashboard(String expectedUrl) {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return page.url().equals(expectedUrl);
    }

    public LoginPage verifyScreen() {
        assertThat(page.locator(usernameField)).isVisible();
        assertThat(page.locator(passwordField)).isVisible();
        assertThat(page.locator(submitButton)).isVisible();
        return this;
    }
}
