package com.trademe.automation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.assertThat;

public class CharitiesStepDefinitions {
    @Steps
    EndUserSteps application;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Given("I am able to access Charity listings API")
    public void i_am_able_to_access_Charity_listings_API() {
        Response resp=application.ConnectAPI("https://api.trademe.co.nz/v1/Charities.json",false);
        assertThat(resp.statusCode()==200);
    }

    @When("I view all the listings")
    public void i_view_all_the_listings() {
        application.viewCharities();
    }

    @Then("I verify that {string} is included in the list")
    public void i_verify_that_is_included_in_the_list(String string) {
        String list=application.getCharitiesList();
        Assert.assertTrue(list.contains(string));
    }
}
