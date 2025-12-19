package br.edu.ufape.todozao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDependencyCreateDTO {
    private Long taskId;
    private Long dependsOnId;
}
