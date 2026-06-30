package org.example.Day1;

import io.restassured.RestAssured;

public class APITest_001 {
    public static void main(String[] args) {
        //Gherkin Syntax
        //base Uri: https://restful-booker.herokuapp.com
        //base path: /booking/1
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/2")
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
