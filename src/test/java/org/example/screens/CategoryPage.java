package org.example.screens;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.example.BaseTest.page;

public class CategoryPage extends UserBaseTestScreen{
    private String addButton = "button:has-text('Adicionar')";
    private String inputUsernameField = "#input-username";
    private String submitButton = "button[type='submit']";
    private String pageSelector = "li.page-item";
    private String categoryNameField = "td.ng-star-inserted";
    private String subCategoryCheckBox = "input[formcontrolname='subCategory']";
    private String categoryListButton = "div[role='combobox']";
    private String categoryListItem = "div[role='option']";

    public CategoryPage clickAddButton(){
        page.locator(addButton).click();
        return this;
    }

    public CategoryPage fillCategoryName(String categoryName){
        assertThat(page.locator(inputUsernameField)).isVisible();
        page.locator(inputUsernameField).fill(categoryName);
        return this;
    }

    public CategoryPage clickSubmitButton(){
        page.locator(submitButton).click();
        return this;
    }

    public CategoryPage clickOnLastPage() {
        int count = page.locator(pageSelector).count();
        page.locator(pageSelector).nth(count -2).click();
        return this;
    }

    public CategoryPage validateCategory(String categoryName){
        assertThat(page.locator(categoryNameField, new Page.LocatorOptions().setHasText(categoryName))).isVisible();
        return this;
    }

    public CategoryPage clickSubCategoryCheckBox(){
        page.locator(subCategoryCheckBox).click(new Locator.ClickOptions().setForce(true));
        return this;
    }

    public CategoryPage clickCategoryList(){
        assertThat(page.locator(categoryListButton)).isVisible();
        page.locator(categoryListButton).click();
        return this;
    }

    public CategoryPage clickFirstCategoryListItem(){
        assertThat(page.locator(categoryListItem).first()).isVisible();
        page.locator(categoryListItem).first().click();
        return this;
    }

    public CategoryPage verifyScreen(){
        assertThat(page.locator(addButton)).isVisible();
        assertThat(page.locator(categoryNameField).first()).isVisible();
        return this;
    }
}
