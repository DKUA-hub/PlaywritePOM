package org.example.tests;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;

    @BeforeTest
    public void setUp(){
        getBrowser("Chrome", "false");
    }

    @Test
    public void testLogin(){
        page.navigate("https://www.automationexercise.com/login");
        loginPage = new LoginPage(page);
        loginPage.doLogin("dk@mailinator.com", "password123");
        homePage = new HomePage(page);
        Assert.assertTrue(homePage.isLogged(), "User logged label is not displayed");
    }

    @AfterTest
    public void tearDown(){
        closeConnection();
    }
}
