package com.automation.demo;

import com.automation.pojo.CreateBookingPojo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SerializationExample {

    public static void main(String[] args) throws Exception {
        String content = getDataFromFile("src/test/resources/json/create_booking.json");

        ObjectMapper mapper = new ObjectMapper();
        CreateBookingPojo createBookingPojo = mapper.readValue(content, CreateBookingPojo.class);
        createBookingPojo.setDepositpaid(false);
    }

    public static String getDataFromFile(String filePath) throws FileNotFoundException {
        String content = new Scanner(new FileInputStream(filePath)).useDelimiter("\\z").next();
        return content;
    }
}
