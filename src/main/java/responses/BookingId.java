package responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"bookingid"})
public class BookingId {

    private int bookingId;

    @JsonProperty("bookingid")
    public int getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingid")
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
