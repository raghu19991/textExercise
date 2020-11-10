package com.trademe.automation;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",glue = "com.trademe.automation")
public class TestRunner {
    @Managed(driver="chrome")
    WebDriver driver;
}
