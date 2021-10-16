package tests;

import org.junit.BeforeClass;
import services.BookingService;

public class BaseTests {
    static BookingService bookingService;
    @BeforeClass
    public static void setUp(){
        bookingService = new BookingService();
    }
}
