package edu.escuelaing.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.task.service.TaskService;
import edu.escuelaing.task.data.Task;
import edu.escuelaing.task.dto.TaskDto;



@RestController
@RequestMapping("/v1/task")
public class TaskController {
	
	private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService )
    {
        this.taskService = taskService;
    }

 
    @GetMapping
    public ResponseEntity<List<Task>> all()
    {
    	try {
            return new ResponseEntity<>(taskService.all(),HttpStatus.ACCEPTED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping( "/{id}" )
    public ResponseEntity<Task> findById( @PathVariable String id )
    {
    	try {
            return new ResponseEntity<>(taskService.findById(id),HttpStatus.FOUND);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping
    public ResponseEntity<Task> create( @RequestBody TaskDto taskDto )
    {
    	try {
    		Task task=new Task(taskDto.getName(),taskDto.getDescription(),taskDto.getStatus(),taskDto.getAssignedTo(),taskDto.getDueDate(),taskDto.getCreated());
            return new ResponseEntity<>(taskService.create(task),HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update( @RequestBody TaskDto taskDto, @PathVariable String id )
    {
    	try {
    		Task task=new Task(taskDto.getName(),taskDto.getDescription(),taskDto.getStatus(),taskDto.getAssignedTo(),taskDto.getDueDate(),taskDto.getCreated());
            return new ResponseEntity<>(taskService.update(task, id),HttpStatus.ACCEPTED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
    	try {
    		taskService.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        }catch(Exception e) {
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

}
