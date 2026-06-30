package org.example.Day2.TestNG;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class API_Post {

    //https://restful-booker.herokuapp.com/auth
    /*curl -X POST \
  https://restful-booker.herokuapp.com/auth \
  -H 'Content-Type: application/json' \
  -d '{
    "username" : "admin",
    "password" : "password123"
}'*/


    @Description("Non-BDD Style")
    @Test
    public void post_req(){
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON)
                    .log().all()
                    .body(payload)
                .when()
                    .post()
                .then()
                    .log().all()
                    .statusCode(200);

    }

}
