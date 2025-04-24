package org.howard.edu.lspfinal.question2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// References, https://www.geeksforgeeks.org/throw-throws-java/, https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
/**
 * A manager class for tracking and organizing tasks by their status.
 *
 */
public class TaskManager {
    private final Map<String, Task> tasksByName = new HashMap<>();
    private final Map<String, List<Task>> tasksByStatus = new HashMap<>();

    /**
     * Constructs a new TaskManager and initializes the status groups.
     */
    public TaskManager() {
        // Initialize the status groups
        tasksByStatus.put("TODO", new ArrayList<>());
        tasksByStatus.put("IN_PROGRESS", new ArrayList<>());
        tasksByStatus.put("DONE", new ArrayList<>());
    }

    /**
     * Adds a new task to the manager.
     *
     * @param name     The unique name of the task
     * @param priority The priority of the task (lower number = higher priority)
     * @param status   The initial status of the task (TODO, IN_PROGRESS, or DONE)
     * @throws DuplicateTaskException    If a task with the same name already exists
     * @throws IllegalArgumentException If the status is invalid
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasksByName.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }

        if (!isValidStatus(status)) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }

        Task newTask = new Task(name, priority, status);
        tasksByName.put(name, newTask);
        tasksByStatus.get(status).add(newTask);
    }

    /**
     * Retrieves a task by its name.
     *
     * @param name The name of the task to retrieve
     * @return The requested Task object
     * @throws TaskNotFoundException 
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = tasksByName.get(name);
        if (task == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return task;
    }

    /**
     * Updates the status of an existing task.
     *
     * @param name      The name of the task to update
     * @param newStatus The new status (TODO, IN_PROGRESS, or DONE)
     * @throws TaskNotFoundException    If no task with the specified name exists
     * @throws IllegalArgumentException If the new status is invalid
     */
    public void updateStatus(String name, String newStatus) 
            throws TaskNotFoundException, IllegalArgumentException {
        Task task = getTaskByName(name); 
        
        if (!isValidStatus(newStatus)) {
            throw new IllegalArgumentException("Invalid status: " + newStatus);
        }

        // Remove from old status group
        tasksByStatus.get(task.getStatus()).remove(task);
        
        // Update status and add to new group
        task.setStatus(newStatus);
        tasksByStatus.get(newStatus).add(task);
    }

    /**
     * Prints all tasks grouped by their current status.
     *   
     * 
     */
    public void printTasksGroupedByStatus() {
        for (Map.Entry<String, List<Task>> entry : tasksByStatus.entrySet()) {
            System.out.println(entry.getKey() + ":");
            if (entry.getValue().isEmpty()) {
                System.out.println("  (No tasks)");
            } else {
                for (Task task : entry.getValue()) {
                    System.out.println("  Task{name='" + task.getName() + 
                                     "', priority=" + task.getPriority() + 
                                     ", status='" + task.getStatus() + "'}");
                }
            }
        }
    }

    /**
     * Validates that a status string is one of the allowed values.
     *
     * @param status The status string to validate
     * @return true if the status is valid, false otherwise
     */
    private boolean isValidStatus(String status) {
        return status.equals("TODO") || status.equals("IN_PROGRESS") || status.equals("DONE");
    }
}