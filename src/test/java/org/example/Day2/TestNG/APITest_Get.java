package org.example.Day2.TestNG;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITest_Get {
    @Test
    public void test_get(){
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/2")
                .when()
                    .get()
                .then().log().all()
                    .statusCode(200);
    }
}
