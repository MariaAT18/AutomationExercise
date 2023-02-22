package com.jalasoft.automation.steps.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import ui.PageTransporter;
import ui.web.pages.HomePage;
import ui.web.pages.LandingPage;
import ui.web.pages.LoginPage;

public class LoginSteps {
    private final PageTransporter pageTransporter;
    private LandingPage landingPage;
    private LoginPage loginPage;
    private HomePage homePage;

    public LoginSteps() {
        this.pageTransporter = PageTransporter.getInstance();
    }

    @Given("^I navigate to Automation page$")
    public void navigateToLandingPage() {
        landingPage = pageTransporter.navigateToLandingPage();
    }

    @Given("^I login to Automation page with a valid \"(.*?)\" account$")
    public void loginWebSite(String userWebsite) {
        loginPage = landingPage.getTopHeader().clickLoginLink();
        homePage = loginPage.loginWithProfileUser(userWebsite);
    }

    @Then("^I should login to Automation page successfully$")
    public void verifyLoginToWebsite() {
        boolean isLoggedInTextDisplayed = homePage.getTopBarMenuAuthenticated().isTheLogoutLinkDisplayed();
        Assert.assertTrue(isLoggedInTextDisplayed, "Logged in as text is not displayed");
    }
}
