import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the TaskService class.
 *
 * Author: Omer Cengiz
 * Date: October 2024
 */
public class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    public void setup() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("123", "Task Name", "Task Description");
        taskService.addTask(task);
        assertNotNull(taskService.getTask("123"));
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("123", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.deleteTask("123");
        assertNull(taskService.getTask("123"));
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("123", "Task Name", "Task Description");
        taskService.addTask(task);

        taskService.updateTask("123", "Updated Name", "Updated Description");
        Task updatedTask = taskService.getTask("123");

        assertEquals("Updated Name", updatedTask.getName());
        assertEquals("Updated Description", updatedTask.getDescription());
    }
}
