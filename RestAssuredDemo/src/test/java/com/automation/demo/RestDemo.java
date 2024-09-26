package com.automation.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestDemo {
    public static void main(String[] args) throws FileNotFoundException {
//        RestAssured.given()
//                .baseUri("https://restful-booker.herokuapp.com")
//                .log().all().when().get("/booking").then()
//                .log().all().assertThat().statusCode(200);


        String requestBody=getDataFromFile("src/test/resources/json/create_booking.json");

        RequestSpecification requestSpecs=RestAssured.given();

        requestSpecs = requestSpecs.baseUri("https://restful-booker.herokuapp.com");

        requestSpecs = requestSpecs.body(requestBody);

        requestSpecs = requestSpecs.contentType("application/json");

        //giving query parameter
        requestSpecs = requestSpecs.queryParam("","");

        Response response = requestSpecs.post("/booking");

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
//        System.out.println(response.prettyPrint());


//        RestAssured.given()
//                .baseUri("https://restful-booker.herokuapp.com")
////                .header("Content-type","application/json")
//                .contentType("application/json")
//                .body(requestBody)
//                .log().all()
//                .when()
//                .post("/booking")
//                .then().log().all()
//                .assertThat().statusCode(200);
    }

    public static String getDataFromFile(String filePath) throws FileNotFoundException {
        String content =  new Scanner(new FileInputStream(filePath))
                .useDelimiter("\\z").next();
        return content;
    }
}
