package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BookingDates {

    private String checkIn;
    private String checkOut;

    public BookingDates() {
        this.checkIn = null;
        this.checkOut = null;
    }

    public BookingDates(BookingDatesBuilder bookingDatesBuilder){
        this.checkIn = bookingDatesBuilder.checkIn;
        this.checkOut = bookingDatesBuilder.checkOut;
    }

    public BookingDates(String checkIn, String checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public static class BookingDatesBuilder{
        private String checkIn;
        private String checkOut;

        public BookingDatesBuilder setCheckIn(String checkIn){
            this.checkIn = checkIn;
            return this;
        }

        public BookingDatesBuilder setCheckOut(String checkOut){
            this.checkOut = checkOut;
            return this;
        }

        public BookingDates build(){
            return new BookingDates(this);
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingDates that = (BookingDates) o;
        return checkIn.equals(that.checkIn) && checkOut.equals(that.checkOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkIn, checkOut);
    }
}
