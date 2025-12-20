package br.edu.ufape.todozao.service;

import br.edu.ufape.todozao.model.User;

import java.util.List;

public interface UserService {

    User criar(User user);

    User buscarPorId(Long id);

    List<User> listar();
}
