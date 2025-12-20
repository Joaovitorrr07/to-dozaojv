package br.edu.ufape.todozao.controller;

import br.edu.ufape.todozao.model.User;
import br.edu.ufape.todozao.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> criar(@RequestBody @Valid User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.criar(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(userService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> listar() {
        return ResponseEntity.ok(userService.listar());
    }
}
