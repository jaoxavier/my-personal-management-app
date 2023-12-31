package io.github.jaoxavier.My.Personal.Management.App.domain.repository;

import io.github.jaoxavier.My.Personal.Management.App.domain.entity.Book;
import io.github.jaoxavier.My.Personal.Management.App.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByClient(Client client);
}
