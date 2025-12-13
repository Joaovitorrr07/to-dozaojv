package br.edu.ufape.todozao.controller;

import br.edu.ufape.todozao.model.Task;
import br.edu.ufape.todozao.model.TaskStatus;
import br.edu.ufape.todozao.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    public static class ChangeStatusRequest{
        public TaskStatus newStatus;
        public String notes;
    }

    @PatchMapping("/{id}/status")
    public Task changeStatus(@PathVariable Long id, @RequestBody ChangeStatusRequest request){
        return taskService.changeStatus(id, request.newStatus, request.notes);
    }
}















