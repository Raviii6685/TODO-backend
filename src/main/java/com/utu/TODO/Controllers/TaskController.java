package com.utu.TODO.Controllers;


import com.utu.TODO.Entities.Task;
import com.utu.TODO.Services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/addTask")
    public ResponseEntity<?> createTask(@RequestBody String title){
        taskService.createTask(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Task>> deleteTask(@PathVariable Long id){
        return ResponseEntity.ok().body(taskService.deleteTask(id));
    }

    @PutMapping("/complete/{id}")
    public ResponseEntity<?> toggleComplete(@PathVariable Long id){
        return ResponseEntity.ok().body(taskService.updateTask(id));
    }
}
