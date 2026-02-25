package com.utu.TODO.Services;


import com.utu.TODO.Entities.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    List<Task> getAllTasks();

    void createTask(String title);

    List<Task> deleteTask(Long id);

    List<Task> updateTask(Long id);
}
