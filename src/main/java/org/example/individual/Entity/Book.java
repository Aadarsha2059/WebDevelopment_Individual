package org.example.individual.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Setter
@Getter
public class Book {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_gen")
    @SequenceGenerator(name = "book_seq_gen", sequenceName = "book_seq", allocationSize = 1, initialValue = 1)
    @Id
    private Integer id;

    @Column(name = "book_name", length = 255)
    private String booksName;

    @Column(name = "genres", length = 255)
    private String genres;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "books_user_id"))
    private User user;
}
