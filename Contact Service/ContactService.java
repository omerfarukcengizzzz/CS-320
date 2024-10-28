import java.util.HashMap;
import java.util.Map;

/**
 * Manages contacts, providing methods to add, delete, and update contacts.
 *
 * Author: Omer Cengiz
 * Date: October 2024
 */
public class ContactService {
    private Map<String, Contact> contacts;

    /**
     * Initializes the contact service with an empty HashMap.
     */
    public ContactService() {
        contacts = new HashMap<>();
    }

    /**
     * Adds a new contact to the service.
     *
     * @param contact The contact to add.
     * @throws IllegalArgumentException if the contact ID already exists.
     */
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactID(), contact);
    }

    /**
     * Deletes a contact by its ID.
     *
     * @param contactID The ID of the contact to delete.
     * @throws IllegalArgumentException if the contact is not found.
     */
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactID);
    }

    /**
     * Updates the fields of a contact.
     *
     * @param contactID   The ID of the contact to update.
     * @param firstName   The new first name.
     * @param lastName    The new last name.
     * @param phoneNumber The new phone number.
     * @param address     The new address.
     * @throws IllegalArgumentException if the contact is not found.
     */
    public void updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        contact.setAddress(address);
    }

    /**
     * Retrieves a contact by its ID.
     *
     * @param contactID The ID of the contact to retrieve.
     * @return The contact, or null if not found.
     */
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
