package br.edu.ufape.todozao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.todozao.model.TaskDependency;

public interface TaskDependencyRepository extends JpaRepository<TaskDependency, Long> {

    List<TaskDependency> findByTaskId(Long taskId);

    boolean existsByTaskIdAndDependsOnId(Long taskId, Long dependsOnId);
}
