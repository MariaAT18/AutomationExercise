package com.jalasoft.automation.steps.web;

import controller.UIController;
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
    // private final UIController controller;

    // public LoginSteps(UIController controller) {
    public LoginSteps() {
        this.pageTransporter = PageTransporter.getInstance();
        // this.controller = controller;
    }

    @Given("^the user is in the Login page$")
    public void navigateToLandingPage() {
        landingPage = pageTransporter.navigateToLandingPage();
    }

    @Given("^the user logs in with her \"(.*?)\" valid account$")
    public void loginWebSite(String userWebsite) {
        loginPage = landingPage.getTopHeader().clickLoginLink();
        homePage = loginPage.loginWithProfileUser(userWebsite);
    }

    @Then("^the user should login into the page successfully$")
    public void verifyLoginToWebsite() {
        boolean isLoggedInTextDisplayed = homePage.getTopBarMenu().isTheLogoutLinkDisplayed();
        Assert.assertTrue(isLoggedInTextDisplayed, "Logged in as text is not displayed");
        // System.out.println(homePage.getTopBarMenuAuthenticated().getUserName());
        // System.out.println(controller.getUserName());
        // Assert.assertEquals(homePage.getTopBarMenuAuthenticated().getUserName(), controller.getUserName());
    }
}