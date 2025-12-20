package br.edu.ufape.todozao.controller;

import br.edu.ufape.todozao.dto.ProjectCreateDTO;
import br.edu.ufape.todozao.dto.ProjectViewDTO;
import br.edu.ufape.todozao.model.Project;
import br.edu.ufape.todozao.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProjectViewDTO> criar(@Valid @RequestBody ProjectCreateDTO dto) {
        Project project = service.criarProjeto(dto);

        return ResponseEntity.ok(
                ProjectViewDTO.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .color(project.getColor())
                        .build()
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProjectViewDTO>> listar(@PathVariable Long userId) {
        List<ProjectViewDTO> result =
                service.listarProjetosDoUsuario(userId)
                        .stream()
                        .map(p -> ProjectViewDTO.builder()
                                .id(p.getId())
                                .name(p.getName())
                                .color(p.getColor())
                                .build())
                        .toList();

        return ResponseEntity.ok(result);
    }
}
