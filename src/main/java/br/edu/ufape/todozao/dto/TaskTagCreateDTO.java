package br.edu.ufape.todozao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskTagCreateDTO {
    private Long taskId;
    private Long tagId;
}
