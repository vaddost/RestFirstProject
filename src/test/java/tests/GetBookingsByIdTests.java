package tests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

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
