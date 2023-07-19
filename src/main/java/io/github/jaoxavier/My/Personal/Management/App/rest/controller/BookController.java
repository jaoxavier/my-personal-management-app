package io.github.jaoxavier.My.Personal.Management.App.rest.controller;

import io.github.jaoxavier.My.Personal.Management.App.domain.entity.Book;
import io.github.jaoxavier.My.Personal.Management.App.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {

    private final BookRepository bookRepository;
    @PostMapping
    public Book create(@RequestBody Book book){
        return bookRepository.save(book);
    }

}
