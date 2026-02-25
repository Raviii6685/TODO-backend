package com.utu.TODO.Services;

import com.utu.TODO.Entities.Task;
import com.utu.TODO.Repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    @Override
    public List<Task> deleteTask(Long id) {
        taskRepository.deleteById(id);
        return taskRepository.findAll();
    }

    @Override
    public List<Task> updateTask(Long id) {
        Task task  = taskRepository.findById(id).orElseThrow();
        task.setCompleted(!task.getCompleted());
        taskRepository.save(task);
        return taskRepository.findAll();
    }
}
