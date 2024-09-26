package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode,RestAssuredUtils.getStatusCode());
    }

    @And("verify booking id is not empty")
    public void verifyBookingIdIsNotEmpty() {
//        Assert.assertFalse(RestAssuredUtils.get().toString().isEmpty());
        String bookingId=RestAssuredUtils.getResponse().jsonPath().getString("bookingid");
        Assert.assertTrue(!bookingId.isEmpty());
    }

    @And("stores created booking id into {string}")
    public void storesCreatedBookingIdInto(String key) {
        ConfigReader.setConfigValue(key
                ,RestAssuredUtils.getResponse().jsonPath().getString("bookingid"));
    }

    @And("store token value to {string}")
    public void storeTokenValueTo(String key) {
        String token = RestAssuredUtils.getResponse().jsonPath().getString("token");
        ConfigReader.setConfigValue(key, token);
    }

    @Then("verify response message is {string}")
    public void verifyResponseMessageIs(String message) {
        Assert.assertEquals(message,RestAssuredUtils.getResponseFieldValue("reason"));
    }
}
