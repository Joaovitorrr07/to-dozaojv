package br.edu.ufape.todozao.exception;

public class InvalidTaskDependencyException extends RuntimeException {
    public InvalidTaskDependencyException(String message) {
        super(message);
    }
}
