package tests;

import org.junit.Test;
import payloads.Booking;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class GetBookingsByIdTests extends BaseTests{

    @Test
    public void checkResponseBody(){
        bookingService.getBookingById("1")
        .then()
                .assertThat()
                .body("firstname", is(notNullValue()))
                .body("lastname", is(notNullValue()))
                .body("totalprice", not(equalTo(0)))
                .body("bookingdates.checkin", is(notNullValue()))
                .body("bookingdates.checkout", is(notNullValue()));
    }
}
