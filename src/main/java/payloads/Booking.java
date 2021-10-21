package payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({"firstName", "lasName", "totalPrice", "depositPaid", "bookingDates", "additionalNeeds"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Booking {

    private String firstName;
    private String lastName;
    private int totalPrice;
    private boolean depositPaid;
    private String additionalNeeds;
    private BookingDates bookingDates;

    public static class BookingBuilder {
        private String firstName;
        private String lastName;
        private int totalPrice;
        private boolean depositPaid;
        private String additionalNeeds;
        private BookingDates bookingDates;

        public BookingBuilder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public BookingBuilder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public BookingBuilder setTotalPrice(int totalPrice){
            this.totalPrice = totalPrice;
            return this;
        }

        public BookingBuilder setDepositPaid(boolean depositPaid){
            this.depositPaid = depositPaid;
            return this;
        }

        public BookingBuilder setAdditionalNeeds(String additionalNeeds){
            this.additionalNeeds = additionalNeeds;
            return this;
        }

        public BookingBuilder setBookingDates(String checkIn, String checkOut){
            this.bookingDates = new BookingDates.BookingDatesBuilder()
                    .setCheckIn(checkIn)
                    .setCheckOut(checkOut)
                    .build();
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }
    }

    public Booking(){
        this.firstName = null;
        this.lastName = null;
        this.totalPrice = 0;
        this.depositPaid = false;
        this.additionalNeeds = null;
        this.bookingDates = null;
    }

    public Booking(BookingBuilder bookingBuilder){
        this.firstName = bookingBuilder.firstName;
        this.lastName = bookingBuilder.lastName;
        this.totalPrice = bookingBuilder.totalPrice;
        this.depositPaid = bookingBuilder.depositPaid;
        this.additionalNeeds = bookingBuilder.additionalNeeds;
        this.bookingDates = bookingBuilder.bookingDates;
    }

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
    public void setBookingDates(String checkIn, String checkOut) {
        this.bookingDates = new BookingDates(checkIn, checkOut);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return totalPrice == booking.totalPrice &&
                depositPaid == booking.depositPaid &&
                firstName.equals(booking.firstName) &&
                lastName.equals(booking.lastName) &&
                Objects.equals(additionalNeeds, booking.additionalNeeds) &&
                bookingDates.equals(booking.bookingDates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, totalPrice, depositPaid, additionalNeeds, bookingDates);
    }
}
