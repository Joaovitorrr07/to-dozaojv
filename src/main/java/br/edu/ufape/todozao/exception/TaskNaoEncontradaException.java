package br.edu.ufape.todozao.exception;

public class TaskNaoEncontradaException extends RuntimeException {
    public TaskNaoEncontradaException(Long id) {
        super("Task com id " + id + " não encontrada");
    }
}
