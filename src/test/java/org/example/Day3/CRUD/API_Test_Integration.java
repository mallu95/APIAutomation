package org.example.Day3.CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class API_Test_Integration {
        //Create a token
        //Create a booking
        //Perform put request
        //Verify that put is successful by get request
        //Delete the Id
        //Verify it doesn't exist get request

        RequestSpecification rs;
        Response response;
        ValidatableResponse vr;

        String token;
        String bookingId;

        public String getToken(){
            String payload="{\n" +
                    "    \"username\" : \"admin\",\n" +
                    "    \"password\" : \"password123\"\n" +
                    "}";

            rs = RestAssured.given();
            rs.baseUri("https://restful-booker.herokuapp.com");
            rs.basePath("/auth");
            rs.contentType(ContentType.JSON).log().all();
            rs.body(payload);

        //When-Response
            Response response=rs.when().post();

        //Then-Validatable Response
           ValidatableResponse vr= response.then().log().all();
           vr.statusCode(200);

        //Extract the token
            token=response.jsonPath().getString("token");
            System.out.println("token:"+token);
            return token;
        }

        public String getBookingId(){
            String payload="{\n" +
                    "    \"firstname\" : \"James\",\n" +
                    "    \"lastname\" : \"Brown\",\n" +
                    "    \"totalprice\" : 111,\n" +
                    "    \"depositpaid\" : true,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2018-01-01\",\n" +
                    "        \"checkout\" : \"2019-01-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Breakfast\"\n" +
                    "}";
            RequestSpecification rs = RestAssured.given();
            rs.baseUri("https://restful-booker.herokuapp.com");
            rs.basePath("/booking");
            rs.contentType(ContentType.JSON);
            rs.cookie("token",token);
            rs.body(payload).log().all();

            //When-Response
            Response response =rs.when().post();

            //Then-Validatable responce
            ValidatableResponse vr=response.then().log().all();
            vr.statusCode(200);

            //Extract the BookingiD
            bookingId=response.jsonPath().getString("bookingid");
            System.out.println("bookingId:"+bookingId);
            return bookingId;
        }

        @Test
        public void update_req(){
            String token=getToken();
            System.out.println("token:"+token);
            String bookingId=getBookingId();
            System.out.println("bookingId:"+bookingId);

        }

        @Test
        public void update_after_get(){
            System.out.println(bookingId);
        }

        @Test
        public void delete_req(){
            System.out.println(bookingId);
            System.out.println(token);
        }

       @Test
        public void delete_after_get(){
            System.out.println(bookingId);
       }



}
