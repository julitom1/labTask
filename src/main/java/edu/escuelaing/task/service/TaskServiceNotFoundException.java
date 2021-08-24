package edu.escuelaing.task.service;

public class TaskServiceNotFoundException extends Exception{

	public TaskServiceNotFoundException(String message) {
        super(message);
    }

    public TaskServiceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
