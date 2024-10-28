import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

/**
 * Unit tests for the Appointment class.
 *
 * Author: Omer Cengiz
 * Date: October 2024
 */
public class AppointmentTest {

    @Test
    public void testValidAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("123", futureDate, "Doctor Appointment");
        assertEquals("123", appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor Appointment", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 1 day in the past
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", pastDate, "Invalid Date");
        });
        assertEquals("Appointment date cannot be in the past", exception.getMessage());
    }

    @Test
    public void testSetInvalidDescription() {
        Appointment appointment = new Appointment("123", new Date(), "Valid Description");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription("This description is way too long and exceeds the 50 character limit.");
        });
        assertEquals("Invalid Appointment Description", exception.getMessage());
    }
}
