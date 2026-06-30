package org.example.Day2.TestNG;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Bdd_Style {

    @Test
    public void test_Get_Positive()
    {
        String pincode="560037";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us/")
                    .basePath("IN/"+pincode)
                .when()
                    .get("")
                .then()
                    .log().all()
                    .statusCode(200);
    }
    @Test
    public void test_Get_Negative()
    {
        String pincode="-1";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us/")
                    .basePath("IN/"+pincode)
                .when()
                    .get("")
                .then()
                    .log().all()
                    .statusCode(200);

    }
}
