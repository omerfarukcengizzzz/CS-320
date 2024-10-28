import java.util.HashMap;
import java.util.Map;

/**
 * Manages appointments by providing methods to add, delete, and update appointments.
 *
 * Author: Omer Cengiz
 * Date: October 2024
 */
public class AppointmentService {
    private Map<String, Appointment> appointments;

    /**
     * Initializes the AppointmentService with an empty HashMap.
     */
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    /**
     * Adds a new appointment.
     *
     * @param appointment The appointment to add.
     * @throws IllegalArgumentException if the appointment ID already exists.
     */
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    /**
     * Deletes an appointment by its ID.
     *
     * @param appointmentID The ID of the appointment to delete.
     * @throws IllegalArgumentException if the appointment ID does not exist.
     */
    public void deleteAppointment(String appointmentID) {
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment not found");
        }
        appointments.remove(appointmentID);
    }

    /**
     * Updates the description of an appointment.
     *
     * @param appointmentID The ID of the appointment to update.
     * @param description   The new description.
     * @throws IllegalArgumentException if the appointment ID does not exist.
     */
    public void updateAppointmentDescription(String appointmentID, String description) {
        Appointment appointment = appointments.get(appointmentID);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment not found");
        }
        appointment.setDescription(description);
    }

    /**
     * Retrieves an appointment by its ID.
     *
     * @param appointmentID The ID of the appointment to retrieve.
     * @return The appointment, or null if not found.
     */
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }
}
