package org.example.tests;

import org.example.BaseTest;
import org.example.screens.CategoryPage;
import org.example.screens.DashboardPage;
import org.example.screens.LoginPage;
import org.example.utils.APIUtils;
import org.example.utils.SignUpHelper;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;

public class Exercise2 extends BaseTest {


    @Test
    public void test() {
        String password = "dummyPassword";
        SignUpHelper signUpHelper = new SignUpHelper(password);
        APIUtils apiUtils = new APIUtils(apiRequestContext);

        apiUtils.createUser(signUpHelper);

        LoginPage loginPage = new LoginPage();
        Boolean isOnDashboard = loginPage
                .navigateToLoginPage()
                .verifyScreen()
                .enterUsername(signUpHelper.getEmail())
                .enterPassword(password)
                .clickLoginButton()
                .isOnDashboard("https://club-administration.qa.qubika.com/#/dashboard");
        assertTrue("Login failed", isOnDashboard);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage
                .verifySideBar()
                .clickTiposDeCategorias();
        CategoryPage categoryPage = new CategoryPage();

        categoryPage
                .verifyScreen()
                .clickAddButton()
                .fillCategoryName(signUpHelper.email)
                .clickSubmitButton()
                .clickOnLastPage()
                .validateCategory(signUpHelper.email )
                .clickAddButton()
                .fillCategoryName(signUpHelper.email + "subcategory")
                .clickSubCategoryCheckBox()
                .clickCategoryList()
                .clickFirstCategoryListItem()
                .clickSubmitButton()
                .validateCategory(signUpHelper.email + "subcategory");

    }
}
