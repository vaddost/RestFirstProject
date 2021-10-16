package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.Booking;

import static io.restassured.RestAssured.given;


public class BookingService {
    private static final String BASE_URL = "http://localhost:3001/booking";
    private RequestSpecification requestSpec;

    public BookingService(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();
    }

    public Response getAllBookings(){
        return given(requestSpec).get();
    }

    public Response getBookingById(final String id){
        return given(requestSpec).pathParam("id", id).get("/{id}");
    }

    public Response getBookingByFirstName(final String firstName){
        return given(requestSpec).queryParam("firstname", firstName)
                .get();
    }

    public Response getBookingByLastName(final String lastName){
        return given(requestSpec).queryParam("lastname", lastName)
                .get();
    }

    public Response getBookingByName(final String firstName, final String lastName){
        return given(requestSpec).queryParam("firstname", firstName)
                .queryParam("lastname", lastName)
                .get();
    }

    public Response getBookingsByCheckInDate(final String checkIn){
        return given(requestSpec).queryParam("checkin", checkIn)
                .get();
    }

    public Response getBookingsByCheckOutDate(final String checkOut){
        return given(requestSpec).queryParam("checkout", checkOut)
                .get();
    }

    public Response getBookingsByDate(final String checkIn, final String checkOut){
        return given(requestSpec).queryParam("checkin", checkIn).queryParam("checkout", checkOut)
                .get();
    }

    public void setAuthToken(final String token){
        requestSpec = requestSpec.auth().oauth2(token);
    }

    public Response createBooking(Booking booking){
        return given(requestSpec).body(booking).post();
    }

    public Response updateBooking(Booking booking, final String id){
        return given(requestSpec).body(booking).pathParam("id", id).put("/{id}");
    }

    public Response deleteBooking(final String id){
        return given(requestSpec).pathParam("id", id).delete("/{id}");
    }
}
