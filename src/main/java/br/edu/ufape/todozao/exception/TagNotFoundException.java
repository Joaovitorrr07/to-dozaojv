package br.edu.ufape.todozao.exception;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException() {
        super("Tag não encontrada");
    }
}
