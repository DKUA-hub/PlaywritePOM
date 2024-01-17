package org.example.pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page;

public class HomePage {

    Page page;

    private String loggedLink = "//a[contains(i/@class, \"fa-user\") and contains(text(), \"Logged in as\") and b[contains(text(), \"DK\")]]";

    public HomePage(Page page){
        this.page = page;
    }

    public boolean isLogged(){
        return page.locator(loggedLink).isVisible();
    }

}
