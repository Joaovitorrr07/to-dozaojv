package br.edu.ufape.todozao.service;

import br.edu.ufape.todozao.model.Task;
import br.edu.ufape.todozao.model.TaskStatus;
import br.edu.ufape.todozao.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskHistoryService taskHistoryService;

    public TaskService(TaskRepository taskRepository, TaskHistoryService taskHistoryService){
        this.taskRepository = taskRepository;
        this.taskHistoryService = taskHistoryService;
    }
    //altera o status d aatask e registra o histórico.
    //atualiza a task no DB.
    //chama taskHistoryService.register para gravar o registro

    @Transactional
    public Task changeStatus(Long taskid, TaskStatus newStatus, String notes){
        Task task = taskRepository.findById(taskid)
                .orElseThrow(() -> new IllegalArgumentException("Task not found: " + taskid));
        if (task.getStatus() == newStatus){
            return  task;
        }
        task.setStatus(newStatus);

        Task saved = taskRepository.save(task);
        taskHistoryService.register(saved, newStatus, notes);

        return saved;
    }

    public Task saveTestTask(Task task) {
        return taskRepository.save(task);
    }

}






































