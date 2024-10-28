/**
 * Represents a task with an ID, name, and description.
 * 
 * Author: Omer Cengiz
 * Date: October 2024
 */
public class Task {
    private final String taskID; // Cannot be updated once set
    private String name;
    private String description;

    /**
     * Constructor to initialize a task with validation for all fields.
     *
     * @param taskID      The unique ID of the task (max length 10, cannot be null).
     * @param name        The name of the task (max length 20, cannot be null).
     * @param description The description of the task (max length 50, cannot be null).
     * @throws IllegalArgumentException if any parameter is invalid.
     */
    public Task(String taskID, String name, String description) {
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Invalid Task ID");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid Task Name");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Task Description");
        }

        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid Task Name");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Task Description");
        }
        this.description = description;
    }
}
