import java.util.HashMap;
import java.util.Map;

/**
 * Manages tasks, providing methods to add, delete, and update tasks.
 * 
 * Author: Omer Cengiz
 * Date: October 2024
 */
public class TaskService {
    private Map<String, Task> tasks;

    /**
     * Initializes the TaskService with an empty HashMap for tasks.
     */
    public TaskService() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a new task to the service.
     *
     * @param task The task to add.
     * @throws IllegalArgumentException if the task ID already exists.
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getTaskID(), task);
    }

    /**
     * Deletes a task by its ID.
     *
     * @param taskID The ID of the task to delete.
     * @throws IllegalArgumentException if the task ID does not exist.
     */
    public void deleteTask(String taskID) {
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task not found");
        }
        tasks.remove(taskID);
    }

    /**
     * Updates the name and description of a task by its ID.
     *
     * @param taskID      The ID of the task to update.
     * @param name        The new task name.
     * @param description The new task description.
     * @throws IllegalArgumentException if the task ID does not exist.
     */
    public void updateTask(String taskID, String name, String description) {
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }
        task.setName(name);
        task.setDescription(description);
    }

    /**
     * Retrieves a task by its ID.
     *
     * @param taskID The ID of the task to retrieve.
     * @return The task with the specified ID, or null if not found.
     */
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }
}
