import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Contact class.
 *
 * Author: Omer Cengiz
 * Date: October 2024
 */
public class ContactTest {

    @Test
    public void testValidContactCreation() {
        // Test that a valid contact can be created
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("123", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactCreationWithInvalidID() {
        // Test that a contact with an invalid ID throws an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid Contact ID", exception.getMessage());
    }

    @Test
    public void testContactCreationWithInvalidFirstName() {
        // Test that a contact with an invalid first name throws an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "LongFirstName", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid First Name", exception.getMessage());
    }

    @Test
    public void testSetFirstName() {
        // Test that the first name can be updated correctly
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testSetInvalidPhoneNumber() {
        // Test that setting an invalid phone number throws an exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("123");
        });
        assertEquals("Invalid Phone Number", exception.getMessage());
    }

    @Test
    public void testSetAddress() {
        // Test that the address can be updated correctly
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    public void testSetInvalidAddress() {
        // Test that setting an invalid address throws an exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This address is way too long to be valid and exceeds the 30 character limit.");
        });
        assertEquals("Invalid Address", exception.getMessage());
    }
}
