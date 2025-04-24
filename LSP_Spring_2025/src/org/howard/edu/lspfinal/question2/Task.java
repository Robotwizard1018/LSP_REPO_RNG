package org.howard.edu.lspfinal.question2;

/**
 * Represents a task with a name, priority, and status.
 *
 */
public class Task {
    private String name;
    private int priority;
    private String status;

    /**
     * Constructs a new Task with the specified arguments.
     *
     * @param name      
     * @param priority 
     * @param status    
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Returns the name of the task.
     *
     * @return The task name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the priority level of the task.
     * 
     *
     * @return The priority value
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the current status of the task.
     *
     * @return The status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the task.
     *
     * @param status The new status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return Formatted string representation
     */
    @Override
    public String toString() {
        return String.format("%s (Priority: %d)", name, priority);
    }
}