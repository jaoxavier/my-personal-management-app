package io.github.jaoxavier.My.Personal.Management.App.domain.entity;

import io.github.jaoxavier.My.Personal.Management.App.domain.enums.book.Difficulty;
import io.github.jaoxavier.My.Personal.Management.App.domain.enums.book.Opinion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Client client;
    private String name;
    private Integer pages;
    private Integer read = 0;
    private Boolean finished = false;
    private LocalDateTime start_reading = LocalDateTime.now();
    private LocalDateTime end_reading;
    private String observation;
    private Difficulty difficulty;
    private Opinion opinion;

    public Book(String name, Integer pages){
        this.name = name;
        this.pages = pages;
    }
}
