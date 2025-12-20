package br.edu.ufape.todozao.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectViewDTO {
    private Long id;
    private String name;
    private String color;
}
