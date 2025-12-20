package br.edu.ufape.todozao.service;

import br.edu.ufape.todozao.exception.TaskInvalidaException;
import br.edu.ufape.todozao.model.User;
import br.edu.ufape.todozao.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User criar(User user) {
        if (userRepo.existsByEmail(user.getEmail())) {
            throw new TaskInvalidaException("Email já cadastrado");
        }

        user.setCreatedAt(LocalDateTime.now());
        return userRepo.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User buscarPorId(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() ->
                        new TaskInvalidaException("Usuário com id " + id + " não encontrado"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listar() {
        return userRepo.findAll();
    }
}
