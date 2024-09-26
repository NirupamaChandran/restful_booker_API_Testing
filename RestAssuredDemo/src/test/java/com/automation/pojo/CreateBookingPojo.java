package com.automation.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingPojo {

    String firstname;
    String lastname;
    int totalprice;
    boolean depositpaid;
    BookingDates bookingdates;
    String additionalneeds;


}
