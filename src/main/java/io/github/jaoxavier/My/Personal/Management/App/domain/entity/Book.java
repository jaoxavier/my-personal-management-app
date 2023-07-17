package io.github.jaoxavier.My.Personal.Management.App.domain.entity;

import io.github.jaoxavier.My.Personal.Management.App.domain.enums.book.Difficulty;
import io.github.jaoxavier.My.Personal.Management.App.domain.enums.book.Opinion;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer pages;
    private Integer read = 0;
    private Difficulty difficulty;
    private Opinion opinion;
}
