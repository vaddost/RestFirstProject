package tests;

import org.junit.BeforeClass;
import services.AuthService;
import services.BookingService;

public class BaseTests {
    static BookingService bookingService;
    static AuthService authService;

    @BeforeClass
    public static void setUp(){
        bookingService = new BookingService();
        authService = new AuthService();
    }
}
