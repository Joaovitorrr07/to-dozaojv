package br.edu.ufape.todozao.controller;

import br.edu.ufape.todozao.model.Task;
import br.edu.ufape.todozao.model.User;
import br.edu.ufape.todozao.repository.TaskRepository;
import br.edu.ufape.todozao.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void deveBuscarTasksPorTitulo() throws Exception {
        // arrange
        User user = User.builder()
                .name("Ana")
                .email("ana@email.com")
                .password("123")
                .build();
        user = userRepository.save(user);

        Task t1 = Task.builder()
                .title("Estudar POO")
                .user(user)
                .build();

        Task t2 = Task.builder()
                .title("Fazer compras")
                .user(user)
                .build();

        taskRepository.save(t1);
        taskRepository.save(t2);

        // act + assert
        mockMvc.perform(get("/api/tasks")
                        .param("title", "estudar"))
                .andExpect(status().isOk())
                // verifica que só UMA task voltou
                .andExpect(jsonPath("$.length()").value(1))
                // verifica o conteúdo
                .andExpect(jsonPath("$[0].title").value("Estudar POO"));
    }
}
