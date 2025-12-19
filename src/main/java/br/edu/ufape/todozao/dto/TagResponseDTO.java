package br.edu.ufape.todozao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TagResponseDTO {

    private Long id;
    private String name;
    private String color;
}
