package org.example.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {
    Playwright playwright;
    Browser browser;
    Page page;


    public void getBrowser(String browserType, String headless){
        playwright = Playwright.create();
        boolean headlessFlag = true;
        if (headless == "false") headlessFlag = false;
        switch(browserType){
            case ("Chrome"):
                browser = playwright
                        .chromium()
                        .launch(new BrowserType
                                .LaunchOptions()
                                .setHeadless(headlessFlag)
                                .setSlowMo(50)
                        );
            case ("Firefox"):
                browser = playwright
                        .firefox()
                        .launch(new BrowserType
                                .LaunchOptions()
                                .setHeadless(headlessFlag)
                                .setSlowMo(50)
                        );
            case ("Webkit"):
                browser = playwright
                        .webkit()
                        .launch(new BrowserType
                                .LaunchOptions()
                                .setHeadless(headlessFlag)
                                .setSlowMo(50)
                        );
        }
        page = browser.newPage();
        System.out.println(" *** Started browser *** "+ browserType + " version: "+browser.version());
    }

    public void navigate(String url){
        page.navigate(url);
        page.waitForSelector("");
    }

    public void closeConnection(){
        page.close();
        browser.close();
        playwright.close();
    }

}
