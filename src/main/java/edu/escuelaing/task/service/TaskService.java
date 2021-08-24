package edu.escuelaing.task.service;

import java.util.List;

import edu.escuelaing.task.data.Task;

public interface TaskService {
	
	Task create( Task task );

    Task findById( String id ) throws TaskServiceNotFoundException;
    
    List<Task> all();

    void deleteById( String id ) throws TaskServiceNotFoundException;

    Task update( Task task, String id ) throws TaskServiceNotFoundException;

}
