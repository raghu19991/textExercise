package com.trademe.automation;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@DefaultUrl("https://www.tmsandbox.co.nz/motors/used-cars")
public class UsedCarPage extends CommonActions{
    public UsedCarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebDriver getDriver() {
        return super.getDriver();
    }

    @FindBy(xpath = "//h1[text()='Used Cars']")
    public WebElement ListingsPage;

    @FindBy(xpath = "//span[@class='listing-attribute-header' and text()='Key details']")
    public WebElement CarDetailsPage;

    public void load(String s) {
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOf(ListingsPage));
    }


    public void loadViewPage(String s) {
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOf(CarDetailsPage));
    }

    public void LocateField(String s) {
        String field = String.format("//label[@class='motors-attribute-label' and text()='%s']",s);
        try{
            assertThat(getDriver().findElement(By.xpath(field)).isDisplayed());
        } catch (NoSuchElementException e) {
            fail("The Label '%s' is not present in the car details",s);
        }

    }
}
