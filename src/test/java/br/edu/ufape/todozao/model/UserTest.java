package br.edu.ufape.todozao.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void deveCriarUsuarioCorretamente() {
        User user = User.builder()
                .name("Nathan")
                .email("nathan@email.com")
                .password("1234")
                .build();

        assertEquals("Nathan", user.getName());
        assertEquals("nathan@email.com", user.getEmail());
        assertEquals("1234", user.getPassword());
    }
}
