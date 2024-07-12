package it.epicode.verificaSecurity.repository;

import it.epicode.verificaSecurity.data.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findOneByName(String roleName);
}
