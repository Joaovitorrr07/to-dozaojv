package br.edu.ufape.todozao.exception;

public class TaskTagAlreadyExistsException extends RuntimeException {
    public TaskTagAlreadyExistsException() {
        super("Tag já associada à task");
    }
}
