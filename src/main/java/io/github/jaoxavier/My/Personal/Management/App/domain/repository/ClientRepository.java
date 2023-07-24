package io.github.jaoxavier.My.Personal.Management.App.domain.repository;

import io.github.jaoxavier.My.Personal.Management.App.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
