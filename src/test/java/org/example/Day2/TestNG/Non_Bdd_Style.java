package org.example.Day2.TestNG;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Non_Bdd_Style {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Non-BDD Style")
    @Test
    public void Non_Bdd_Style(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("IN/110001");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }
}
