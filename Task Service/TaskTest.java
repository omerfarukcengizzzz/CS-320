import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Task class.
 *
 * Author: Omer Cengiz
 * Date: October 2024
 */
public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("123", "Task Name", "Task Description");
        assertEquals("123", task.getTaskID());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    public void testInvalidTaskID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task Name", "Task Description");
        });
        assertEquals("Invalid Task ID", exception.getMessage());
    }

    @Test
    public void testSetName() {
        Task task = new Task("123", "Task Name", "Task Description");
        task.setName("Updated Name");
        assertEquals("Updated Name", task.getName());
    }

    @Test
    public void testInvalidName() {
        Task task = new Task("123", "Task Name", "Task Description");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This name is way too long to be valid.");
        });
        assertEquals("Invalid Task Name", exception.getMessage());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task("123", "Task Name", "Task Description");
        task.setDescription("Updated Description");
        assertEquals("Updated Description", task.getDescription());
    }
}
