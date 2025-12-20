package br.edu.ufape.todozao.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectCreateDTO {

    @NotBlank
    private String name;

    private String color;

    private Long userId;
}
