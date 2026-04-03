package com.example.pages;

import com.microsoft.playwright.Page;

public class BrowserStackPage {
    private Page page;

    public BrowserStackPage(Page page) {
        this.page = page;
    }

    public void navigateToBrowserStack() {
        page.navigate("https://www.gov.ie/en/");
    }

    public String getTitle() {
        return page.title();
    }
}