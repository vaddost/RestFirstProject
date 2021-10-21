package tests;

import org.testng.annotations.Test;
import responses.BookingId;

import java.util.Arrays;
import java.util.Objects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetAllBookingsTests extends BaseTests{

    @Test
    public void testCheckResponseBody() {
        BookingId[] bookingIds = bookingService.getAllBookings().as(BookingId[].class);

        assertTrue(bookingIds.length > 0);

        long count = Arrays.stream(bookingIds)
                .filter(Objects::isNull)
                .count();
        assertEquals(count, 0);
    }

    @Test
    public void testCheckThatAllIdsFromTheResponseCanBeCalledFromGetBookingsById(){
        BookingId[] bookingIds = bookingService.getAllBookings().as(BookingId[].class);

        for (var bookingId : bookingIds){
            String responseBody = bookingService.getBookingById(Integer.toString(bookingId.getBookingId()))
                    .then()
                    .log().body()
                    .assertThat()
                    .statusCode(200)
                    .extract().body().asString();

            assertTrue(responseBody.contains("firstname"));
            assertTrue(responseBody.contains("lastname"));
            assertTrue(responseBody.contains("totalprice"));
            assertTrue(responseBody.contains("depositpaid"));
            assertTrue(responseBody.contains("bookingdates"));
        }
    }
}
