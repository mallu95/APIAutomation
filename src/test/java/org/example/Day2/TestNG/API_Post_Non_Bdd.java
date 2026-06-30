package org.example.Day2.TestNG;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Post_Non_Bdd {
    @Description("Non-BDD Style")
    @Test
    public void post_req(){
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RequestSpecification r =RestAssured.given();
                                r.baseUri("https://restful-booker.herokuapp.com");
                                r.basePath("/auth");
                                r.contentType(ContentType.JSON).log().all();
                                r.body(payload);
                                r.when().post();
                                r.then().log().all().statusCode(200);
    }
}
