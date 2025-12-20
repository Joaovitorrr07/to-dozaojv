package br.edu.ufape.todozao.controller;

import br.edu.ufape.todozao.dto.TaskCreateDTO;
import br.edu.ufape.todozao.dto.TaskViewDTO;
import br.edu.ufape.todozao.model.Task;
import br.edu.ufape.todozao.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TaskViewDTO> criar(@Valid @RequestBody TaskCreateDTO dto) {
        Task task = service.criarTask(dto);

        return ResponseEntity.ok(
                TaskViewDTO.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .priority(task.getPriority())
                        .status(task.getTaskStatus().name())
                        .build()
        );
    }
}
