package br.edu.ufape.todozao.repository;

import br.edu.ufape.todozao.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
