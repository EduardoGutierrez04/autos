package mx.uam.integracion.autos.autos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.uam.integracion.autos.autos.entity.User;

@Repository

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUser(String user);
}
