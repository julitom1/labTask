package edu.escuelaing.task.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import edu.escuelaing.task.data.Task;
import edu.escuelaing.task.service.TaskService;
import edu.escuelaing.task.service.TaskServiceNotFoundException;

@Service
public class MemoryUserTaskService implements TaskService{

	private static final ConcurrentHashMap<String,Task> tasks=new ConcurrentHashMap<>();
	@Override
	public Task create(Task task) {
		task.setId(generarId());
		tasks.put(task.getId(), task);
		return task;
	}

	@Override
	public Task findById(String id) throws TaskServiceNotFoundException {
		Task task=null;
		if(tasks.containsKey(id)) {
			task=tasks.get(id);
		}else {
			throw new TaskServiceNotFoundException("Not found TaskService with id: "+id);
		}
		return task;
	}

	@Override
	public List<Task> all() {
		List<Task> taskList=new ArrayList<>();
        for(String userId : tasks.keySet()){
        	taskList.add(tasks.get(userId));
        }
        return taskList;
	}

	@Override
	public void deleteById(String id) throws TaskServiceNotFoundException {
		if(tasks.containsKey(id)) {
			tasks.remove(id);
		}else {
			throw new TaskServiceNotFoundException("Not found TaskService with id: "+id);
		}
		
	}

	@Override
	public Task update(Task task, String id) throws TaskServiceNotFoundException {
		Task taskNew=null;
		if(tasks.containsKey(id)) {
			tasks.put(id,task);
			taskNew=tasks.get(id);
		}else {
			throw new TaskServiceNotFoundException("Not found TaskService with id: "+id);
		}
		return taskNew;
	}
	
	private String generarId() {
    	int mayorId=0;
    	for(String userId : tasks.keySet()){
        	if(mayorId<Integer.parseInt(userId)) {
        		mayorId=Integer.parseInt(userId);
        	}
        }
    	mayorId+=1; 
    	return mayorId+"";
    }

}
