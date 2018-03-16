package com.delivermoreservices.apitesting;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeliveronServicesTest
{
@Test
    public void BmiInputs18_5to25ShouldBeNormal()
    {
        given().
            queryParam("weight", "150").
            queryParam("height", "65").
        when().
            get("http://sampleapi.azurewebsites.net/api/bmi").
        then().    
            body("value", equalTo("24.96")).
            body("category", equalTo("Normal"));
    }

    @Test
    public void InvalidBmiInputsShouldreturnvalidationerror()
    {
        given().
            queryParam("weight", "0").
            queryParam("height", "0").
        when().
            get("http://sampleapi.azurewebsites.net/api/bmi").
        then().    
            statusCode(400);
    }
}