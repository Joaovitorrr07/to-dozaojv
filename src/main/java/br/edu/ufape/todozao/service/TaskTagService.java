package br.edu.ufape.todozao.service;

import java.util.List;

import br.edu.ufape.todozao.exception.TaskTagAlreadyExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.todozao.model.TaskTag;
import br.edu.ufape.todozao.repository.TaskTagRepository;

@Service
public class TaskTagService {

    private final TaskTagRepository repository;

    public TaskTagService(TaskTagRepository repository) {
        this.repository = repository;
    }

    public List<TaskTag> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public TaskTag salvar(TaskTag taskTag) {

        if (repository.existsByTaskIdAndTagId(
                taskTag.getTask().getId(),
                taskTag.getTag().getId())) {

            throw new TaskTagAlreadyExistsException();
        }

        return repository.save(taskTag);
    }


    @Transactional
    public void remover(Long id) {
        repository.deleteById(id);
    }
}

