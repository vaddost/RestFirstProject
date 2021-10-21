package tests;

import io.restassured.http.ContentType;

import org.testng.annotations.Test;
import payloads.Booking;

import static org.testng.Assert.assertEquals;


public class CreateBookingTests extends BaseTests{
    @Test
    public void testCheckThatNewBookingIsCreated(){
        Booking booking = new Booking();
        booking.setFirstName("John");
        //booking.setLastName("Cohn");
        booking.setTotalPrice(100);
        booking.setDepositPaid(true);
        booking.setBookingDates("2021-10-10", "2021-11-01");
        booking.setAdditionalNeeds("coffee");

        authService.createToken();

        bookingService.setAuthToken(authService.getToken());
        int bookingId = bookingService.createBooking(booking).then().log().body().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().path("bookingid");

        Booking createdBooking = bookingService.getBookingById(Integer.toString(bookingId))
                .then().log().body().assertThat()
                .statusCode(200)
                .extract().as(Booking.class);

        assertEquals(createdBooking, booking);
    }
}
