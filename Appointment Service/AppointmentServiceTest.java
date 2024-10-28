import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

/**
 * Unit tests for the AppointmentService class.
 *
 * Author: Omer Cengiz
 * Date: October 2024
 */
public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    public void setup() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("123", futureDate, "Doctor Appointment");
        appointmentService.addAppointment(appointment);
        assertNotNull(appointmentService.getAppointment("123"));
    }

    @Test
    public void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("123", futureDate, "Doctor Appointment");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("123");
        assertNull(appointmentService.getAppointment("123"));
    }

    @Test
    public void testUpdateAppointmentDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("123", futureDate, "Doctor Appointment");
        appointmentService.addAppointment(appointment);

        appointmentService.updateAppointmentDescription("123", "Updated Description");
        assertEquals("Updated Description", appointmentService.getAppointment("123").getDescription());
    }
}
