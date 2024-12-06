package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    public static  Page page;
    protected APIRequestContext apiRequestContext;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();

        // Initialize the APIRequestContext with the correct base URL
        apiRequestContext = playwright.request().newContext(
                new APIRequest.NewContextOptions().setBaseURL("https://api.club-administration.qa.qubika.com")
        );

        // Ensure the APIRequestContext is properly initialized
        if (apiRequestContext == null) {
            throw new IllegalStateException("APIRequestContext was not initialized properly.");
        }    }

    @AfterEach
    public void tearDown() {
        page.close();
        context.close();
        browser.close();
        apiRequestContext.dispose();
        playwright.close();
    }
}
