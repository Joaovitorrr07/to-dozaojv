package br.edu.ufape.todozao.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskViewDTO {

    private Long id;
    private String title;
    private String description;
    private String priority;
    private String status;
}

