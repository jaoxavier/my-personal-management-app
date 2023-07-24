package io.github.jaoxavier.My.Personal.Management.App.rest.controller;

import io.github.jaoxavier.My.Personal.Management.App.domain.entity.Book;
import io.github.jaoxavier.My.Personal.Management.App.domain.entity.Client;
import io.github.jaoxavier.My.Personal.Management.App.domain.repository.BookRepository;
import io.github.jaoxavier.My.Personal.Management.App.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {

    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;
    @PostMapping("/{id}")
    public Book create(@RequestBody Book book, @PathVariable Integer id){
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("[404] - Client not found - [BookController: Can't create new book]")
        );
        book.setClient(client);
        return bookRepository.save(book);
    }

    @GetMapping("/{id}/client/{client_id}")
    public Book getBookById(@PathVariable Integer id, @PathVariable Integer client_id){
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("[404] - Book not found [BookController: can't get book by id]")
        );

        if(book.getClient().getId().equals(client_id)){
            return book;
        }

        throw new RuntimeException("[400] - The client is not the owner of the book - [BookController: can't get book by id]");
    }

    @GetMapping("/client/{id}")
    public List<Book> getBookByClient(@PathVariable Integer id){
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("[404] - Client not found [BookController: can't get book by client]")
        );

        return bookRepository.findByClient(client);
    }

    @PatchMapping
    public Book patchBook(@RequestBody Book book){
        return bookRepository.save(book);
    }



}
