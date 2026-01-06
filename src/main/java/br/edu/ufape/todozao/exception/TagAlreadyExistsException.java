package br.edu.ufape.todozao.exception;

public class TagAlreadyExistsException extends RuntimeException {
    public TagAlreadyExistsException() {
        super("Já existe uma tag com esse nome para o usuário");
    }
}
