package br.edu.ufape.todozao.repository;

import br.edu.ufape.todozao.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    boolean existsByNameAndUserId(String name, Long userId);

    List<Project> findByUserId(Long userId);
}
