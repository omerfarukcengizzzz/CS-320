import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the ContactService class.
 *
 * Author: Omer Cengiz
 * Date: October 2024
 */
public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setup() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Street");
        contactService.addContact(contact);
        assertNotNull(contactService.getContact("123"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Street");
        contactService.addContact(contact);
        contactService.deleteContact("123");
        assertNull(contactService.getContact("123"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Street");
        contactService.addContact(contact);

        contactService.updateContact("123", "Jane", "Smith", "0987654321", "456 Avenue");
        Contact updatedContact = contactService.getContact("123");

        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhoneNumber());
        assertEquals("456 Avenue", updatedContact.getAddress());
    }
}
