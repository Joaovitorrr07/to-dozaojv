package br.edu.ufape.todozao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.todozao.dto.TaskTagCreateDTO;
import br.edu.ufape.todozao.model.Tag;
import br.edu.ufape.todozao.model.Task;
import br.edu.ufape.todozao.model.TaskTag;
import br.edu.ufape.todozao.service.TaskTagService;

@RestController
@RequestMapping("/task-tags")
public class TaskTagController {

    private final TaskTagService service;

    public TaskTagController(TaskTagService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody TaskTagCreateDTO dto) {

        Task task = new Task();
        task.setId(dto.getTaskId());

        Tag tag = new Tag();
        tag.setId(dto.getTagId());

        TaskTag taskTag = TaskTag.builder()
                .task(task)
                .tag(tag)
                .build();

        service.salvar(taskTag);
    }
}
