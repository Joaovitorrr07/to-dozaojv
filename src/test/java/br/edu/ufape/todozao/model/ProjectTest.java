package br.edu.ufape.todozao.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void deveCriarProjetoCorretamente() {
        Project project = Project.builder()
                .name("Projeto To-dozão")
                .color("#FF5733")
                .build();

        assertEquals("Projeto To-dozão", project.getName());
        assertEquals("#FF5733", project.getColor());
        assertNotNull(project);
    }
}
