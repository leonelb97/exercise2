package org.example.screens;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.example.BaseTest.page;

public class UserBaseTestScreen {
    static String DashboardItem = "Dashboard";
    static String ContribucionesItem = "a[href='#/contributions']";
    static String TiposDeCategoriasItem = "a[href='#/category-type']";
    static String ContribucionesSugeridas = "a[href='#/contribution-suggested']";
    static String Miembros = "a[href='#/members']";
    static String Socios = "a[href='#/partners']";
    static String Reportes = "a[href='#/reports']";


    UserBaseTestScreen clickDashboard() {
        page.locator(DashboardItem).click();
        return this;
    }
    UserBaseTestScreen clickContribuciones() {
        page.locator(ContribucionesItem).click();
        return this;
    }
    public UserBaseTestScreen clickTiposDeCategorias() {
        page.locator(TiposDeCategoriasItem).click();
        return this;
    }
    UserBaseTestScreen clickContribucionesSugeridas() {
        page.locator(ContribucionesSugeridas).click();
        return this;
    }
    UserBaseTestScreen clickMiembros() {
        page.locator(Miembros).click();
        return this;
    }
    UserBaseTestScreen clickSocios() {
        page.locator(Socios).click();
        return this;
    }
    UserBaseTestScreen clickReportes() {
        page.locator(Reportes).click();
        return this;
    }

    public UserBaseTestScreen verifySideBar() {
        assertThat(page.getByText(DashboardItem)).isVisible();
        assertThat(page.locator(ContribucionesItem)).isVisible();
        assertThat(page.locator(TiposDeCategoriasItem)).isVisible();
        assertThat(page.locator(ContribucionesSugeridas)).isVisible();
        assertThat(page.locator(Miembros)).isVisible();
        assertThat(page.locator(Socios)).isVisible();
        assertThat(page.locator(Reportes)).isVisible();
        return this;
    }
}
