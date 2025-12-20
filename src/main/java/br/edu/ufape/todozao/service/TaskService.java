package br.edu.ufape.todozao.service;

import br.edu.ufape.todozao.dto.TaskDTO;
import br.edu.ufape.todozao.model.Task;
import br.edu.ufape.todozao.model.TaskStatus;
import br.edu.ufape.todozao.repository.TaskRepository;
import br.edu.ufape.todozao.repository.UserRepository;
import br.edu.ufape.todozao.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setColor(taskDTO.getColor());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());
        task.setType(taskDTO.getType());
        task.setResetRule(taskDTO.getResetRule());
        task.setTaskStatus(TaskStatus.PENDING);

        if (taskDTO.getUserId() != null) {
            task.setUser(userRepository.findById(taskDTO.getUserId()).orElse(null));
        }

        if (taskDTO.getProjectId() != null) {
            task.setProject(projectRepository.findById(taskDTO.getProjectId()).orElse(null));
        }

        Task savedTask = taskRepository.save(task);
        return convertToDTO(savedTask);
    }

    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setColor(taskDTO.getColor());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());
        task.setType(taskDTO.getType());
        task.setResetRule(taskDTO.getResetRule());

        if (taskDTO.getUserId() != null) {
            task.setUser(userRepository.findById(taskDTO.getUserId()).orElse(null));
        }

        if (taskDTO.getProjectId() != null) {
            task.setProject(projectRepository.findById(taskDTO.getProjectId()).orElse(null));
        }

        Task updatedTask = taskRepository.save(task);
        return convertToDTO(updatedTask);
    }

    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return convertToDTO(task);
    }

    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<TaskDTO> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<TaskDTO> getTasksByProjectId(Long projectId) {
        return taskRepository.findByProjectId(projectId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }

    public TaskDTO changeTaskStatus(Long id, TaskStatus taskStatus) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTaskStatus(taskStatus);
        Task updatedTask = taskRepository.save(task);
        return convertToDTO(updatedTask);
    }

    private TaskDTO convertToDTO(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .color(task.getColor())
                .priority(task.getPriority())
                .taskStatus(task.getTaskStatus().toString())
                .dueDate(task.getDueDate())
                .type(task.getType())
                .resetRule(task.getResetRule())
                .userId(task.getUser() != null ? task.getUser().getId() : null)
                .projectId(task.getProject() != null ? task.getProject().getId() : null)
                .build();
    }
}