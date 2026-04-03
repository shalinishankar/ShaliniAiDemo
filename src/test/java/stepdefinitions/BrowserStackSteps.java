package stepdefinitions;

import com.example.pages.BrowserStackPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

public class BrowserStackSteps {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private BrowserStackPage browserStackPage;
    private ExtentTest test;

    @Before
    public void setUp() {
        test = ExtentReportManager.createTest("BrowserStack Test");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        browserStackPage = new BrowserStackPage(page);
    }

    @Given("I launch Chrome browser")
    public void i_launch_chrome_browser() {
        test.info("Launching Chrome browser");
        // Browser is already launched in setUp
    }

    @When("I navigate to BrowserStack website")
    public void i_navigate_to_browser_stack_website() {
        test.info("Navigating to BrowserStack website");
        browserStackPage.navigateToBrowserStack();
    }

    @Then("I should see the BrowserStack page title")
    public void i_should_see_the_browser_stack_page_title() {
        test.info("Verifying page title");
        String title = browserStackPage.getTitle();
        if (title.contains("BrowserStack")) {
            test.pass("Page title contains BrowserStack: " + title);
        } else {
            test.fail("Page title does not contain BrowserStack: " + title);
        }
    }

    @After
    public void tearDown() {
        if (page != null) {
            page.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
        ExtentReportManager.flush();
    }
}