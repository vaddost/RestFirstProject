package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"firstName", "lasName", "totalPrice", "depositPaid", "bookingDates", "additionalNeeds"})
public class Booking {

    private String firstName;
    private String lastName;
    private int totalPrice;
    private boolean depositPaid;
    private String additionalNeeds;
    private BookingDates bookingDates;

    public Booking(String firstName, String lastName, int totalPrice, boolean depositPaid, String additionalNeeds, BookingDates bookingDates) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.additionalNeeds = additionalNeeds;
        this.bookingDates = bookingDates;
    }

    @JsonProperty("firstname")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstname")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastname")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastname")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("totalprice")
    public int getTotalPrice() {
        return totalPrice;
    }

    @JsonProperty("totalprice")
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @JsonProperty("depositpaid")
    public boolean isDepositPaid() {
        return depositPaid;
    }

    @JsonProperty("depositpaid")
    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    @JsonProperty("additionalneeds")
    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    @JsonProperty("additionalneeds")
    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }

    @JsonProperty("bookingdates")
    public BookingDates getBookingDates() {
        return bookingDates;
    }

    @JsonProperty("bookingdates")
    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    class BookingDates {
        private String checkIn;
        private String checkOut;

        public BookingDates(String checkIn, String checkOut) {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

        @JsonProperty("checkin")
        public String getCheckIn() {
            return checkIn;
        }

        @JsonProperty("checkin")
        public void setCheckIn(String checkIn) {
            this.checkIn = checkIn;
        }

        @JsonProperty("checkout")
        public String getCheckOut() {
            return checkOut;
        }

        @JsonProperty("checkout")
        public void setCheckOut(String checkOut) {
            this.checkOut = checkOut;
        }
    }
}
