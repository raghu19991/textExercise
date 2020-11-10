package com.trademe.automation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UsedCarsStepDefinitions {
    @Steps
    EndUserSteps application;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Given("I access Used Cars Page using {}")
    public void i_access_Used_Cars_Page_using(String user_interface) {
        application.SetApplicationType(user_interface);
        if (user_interface.equals("WEB")){
            application.PageIsOpened("https://api.trademe.co.nz/v1/Search/Motors/Used.json");
        }
        else if (user_interface.equals("API")){
            Response resp=application.ConnectAPI("https://api.tmsandbox.co.nz/v1/Listings/2149206009.json",true);
            assertThat(resp.statusCode()==200);
        }
    }

    @When("I view the details of any Used Car")
    public void i_view_the_details_of_any_Used_Car() {
        String sampleUsedCarListing="2149206009";
        application.ViewCarDetails("https://www.tmsandbox.co.nz/motors/used-cars/bmw/auction-2149206009.htm");
    }

    @Then("I verify that the following details of the car exists")
    public void i_verify_that_the_following_details_of_the_car_exists(List<String> fields) {
        fields.stream().forEach(field -> {application.CheckField(field);});

    }
}
