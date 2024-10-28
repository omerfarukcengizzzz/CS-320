import java.util.Date;

/**
 * Represents an appointment with a unique ID, date, and description.
 * Validates that the appointment ID is not null and does not exceed 10 characters,
 * that the appointment date is not null and is not in the past, 
 * and that the description is not null and does not exceed 50 characters.
 * 
 * Author: Omer Cengiz
 * Date: October 2024
 */
public class Appointment {
    private final String appointmentID; // Unique appointment ID (cannot be changed after creation)
    private Date appointmentDate; // Appointment date
    private String description; // Appointment description

    /**
     * Constructs a new Appointment object with the specified ID, date, and description.
     *
     * @param appointmentID The unique ID for the appointment (max length 10).
     * @param appointmentDate The date of the appointment (must be a future date).
     * @param description A brief description of the appointment (max length 50).
     * @throws IllegalArgumentException if any parameters are invalid.
     */
    public Appointment(String appointmentID, Date appointmentDate, String description) {
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Invalid Appointment ID");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid Appointment Date");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }

        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    /**
     * Gets the appointment ID.
     *
     * @return The unique appointment ID.
     */
    public String getAppointmentID() {
        return appointmentID;
    }

    /**
     * Gets the appointment date.
     *
     * @return The appointment date.
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Sets the appointment date.
     *
     * @param appointmentDate The new appointment date (must be a future date).
     * @throws IllegalArgumentException if the date is in the past.
     */
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid Appointment Date");
        }
        this.appointmentDate = appointmentDate;
    }

    /**
     * Gets the appointment description.
     *
     * @return The appointment description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the appointment description.
     *
     * @param description The new description (max length 50).
     * @throws IllegalArgumentException if the description is invalid.
     */
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.description = description;
    }
}
