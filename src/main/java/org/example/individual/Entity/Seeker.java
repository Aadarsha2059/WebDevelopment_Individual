package org.example.individual.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "seeker")
@Setter
@Getter

public class Seeker {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seeker_seq_gen")
    @SequenceGenerator(name = "seeker_seq_gen", sequenceName = "seeker_seq", allocationSize = 1, initialValue = 1)
    @Id
    private Integer id;

    @Column(name = "seekerName", length = 255)
    private String seekerName;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password",length=255)
    private String password;

    @Column(name = "address", length = 255)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "seeker_user_id"))
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "seeker_book_id"))
    private Book book;
}
