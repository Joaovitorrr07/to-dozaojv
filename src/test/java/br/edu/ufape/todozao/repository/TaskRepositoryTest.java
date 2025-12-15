package br.edu.ufape.todozao.repository;

import br.edu.ufape.todozao.model.Task;
import br.edu.ufape.todozao.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void deveSalvarEBuscarTask() {
        User user = User.builder()
                .name("João")
                .email("joao@email.com")
                .password("123")
                .build();

        user = userRepository.save(user);

        Task task = Task.builder()
                .title("Fazer testes")
                .priority("MEDIA")
                .user(user)
                .build();

        Task savedTask = taskRepository.save(task);

        assertThat(savedTask.getId()).isNotNull();
        assertThat(taskRepository.findById(savedTask.getId())).isPresent();
    }
}
