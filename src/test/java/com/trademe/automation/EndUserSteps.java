package com.trademe.automation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class EndUserSteps {

    UsedCarPage usedCarPage;
    CommonActions commonActions;

    Response r;
    String applicationType;
    List<Map<String, String>> attributes;
    String charitiesList;

    public Response getUsedCarsAPIListing(){
        return  r;
    }

    public String getApplicationType(){
        return applicationType;
    }
    public String getCharitiesList(){
        return charitiesList;
    }
    @Step
    public void PageIsOpened(String s){
        usedCarPage.open();
        usedCarPage.load(s);
    }
    @Step
    public Response ConnectAPI(String url,boolean auth){
        if(auth){
            r=RestAssured.given().auth().oauth("FE59BC8407F91CD9735B0913DAF13D7F", "0EA6EED4A742F0985DE2C97079571714","82C15B5E8E371C91AC6B89062A3D524A","2F80D41F9601B020350A08D1A148DF5A").
                    when().get(url);
        } else{
            r=RestAssured.when().get(url);
        }
        return r;
    }

    public void ViewCarDetails(String listing) {
        if(applicationType.equals("WEB")){
            usedCarPage.getDriver().get(listing);
            usedCarPage.loadViewPage(listing);
        }
        else if(applicationType.equals("API")){
            JsonPath json= r.jsonPath();
            attributes = json.getList("Attributes");
        }

    }

    public void CheckField(String s) {
        if(applicationType.equals("WEB")){
            usedCarPage.LocateField(s);
        }
        else if(applicationType.equals("API")){
            if(s.equals("Body")){
                s="Body style";
            }
            boolean found=false;
            assertThat(attributes.contains(s));
            for(int i=0;i<attributes.size();i++){
                if(attributes.get(i).get("DisplayName").equals(s)){
                    found=true;
                    break;
                }
            }
            if (!found){
                fail("The label '%s' was not found in the API details of the Car",s);
        }

    }}

    public void SetApplicationType(String user_interface) {
        applicationType= user_interface;
    }

    public void viewCharities() {
        charitiesList = r.getBody().asString();
    }
}
