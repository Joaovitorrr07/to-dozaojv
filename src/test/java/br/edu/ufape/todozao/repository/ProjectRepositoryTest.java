package br.edu.ufape.todozao.repository;

import br.edu.ufape.todozao.model.Project;
import br.edu.ufape.todozao.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void deveSalvarEBuscarProjeto() {
        User user = User.builder()
                .name("Ana")
                .email("ana@email.com")
                .password("123456")
                .build();

        user = userRepository.save(user);

        Project project = Project.builder()
                .name("Projeto Teste")
                .color("#00FF00")
                .user(user)
                .build();

        Project savedProject = projectRepository.save(project);

        assertThat(savedProject.getId()).isNotNull();
        assertThat(projectRepository.findById(savedProject.getId())).isPresent();
    }
}
