package br.edu.ufape.todozao.repository;

import br.edu.ufape.todozao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
