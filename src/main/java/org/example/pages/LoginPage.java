package org.example.pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginPage {

    Page page;

    private String emailField = "input[data-qa='login-email']";
    private String passwordField = "input[placeholder='Password']";
    private String loginButton = "button[data-qa='login-button']";

    public LoginPage(Page page){
        this.page = page;
    }

    public void setEmail(String email){
        page.fill(emailField, email);
    }

    public void setPassword(String password){
        page.fill(passwordField, password);
    }

    public void doLogin(String email, String password){
        setEmail(email);
        setPassword(password);
        page.click(loginButton);
    }
}
