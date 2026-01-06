package br.edu.ufape.todozao.exception;

public class UnauthorizedTagAccessException extends RuntimeException {
    public UnauthorizedTagAccessException() {
        super("Usuário não pode remover essa tag");
    }
}
