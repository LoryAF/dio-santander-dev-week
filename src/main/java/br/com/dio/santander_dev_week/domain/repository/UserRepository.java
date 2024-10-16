package br.com.dio.santander_dev_week.domain.repository;

import br.com.dio.santander_dev_week.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
