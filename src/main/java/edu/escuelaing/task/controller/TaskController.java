package edu.escuelaing.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.escuelaing.task.service.TaskService;
import edu.escuelaing.task.data.Task;
import edu.escuelaing.task.dto.TaskDto;




public class TaskController {
	
	private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService )
    {
        this.taskService = taskService;
    }

 
    @GetMapping
    public ResponseEntity<List<Task>> all()
    {
    	return null;
    }
    
    @GetMapping( "/{id}" )
    public ResponseEntity<Task> findById( @PathVariable String id )
    {
    	return null;
    }
    
    
    @PostMapping
    public ResponseEntity<Task> create( @RequestBody TaskDto taskDto )
    {
    	return null;
    }
    
    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update( @RequestBody TaskDto taskDto, @PathVariable String id )
    {
    	return null;
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
    	return null;
    }

}
