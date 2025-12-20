package br.edu.ufape.todozao.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagCreateDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String color;
}
